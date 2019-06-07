package br.com.pedrosa.api.service.impl;

import br.com.pedrosa.api.domain.Album;
import br.com.pedrosa.api.dto.GenreDTO;
import br.com.pedrosa.api.service.AlbumService;
import br.com.pedrosa.api.service.GenreService;
import br.com.pedrosa.api.service.PopulateAlbunsService;
import br.com.pedrosa.api.spotify.dto.ArtistDTO;
import br.com.pedrosa.api.spotify.dto.ResponseSpotifyDTO;
import br.com.pedrosa.api.utils.ApiUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
@AllArgsConstructor
public class PopulateAlbunsServiceImpl implements PopulateAlbunsService {

	private AlbumService albumService;
	private ApiSpotifyServiceImpl apiSpotifyService;
	private GenreService genreService;
	
	@Override
	public void populateAlbunsFromJson() throws  IOException {
		String content = getJsonFromFile();
		ObjectMapper objectMapper = new ObjectMapper();
		List<Album> albuns = objectMapper.readValue(content, new TypeReference<List<Album>>() {});
		albuns.forEach(album ->{
			album.setPrice(ApiUtils.generatePriceRandom(10,50));
			albumService.save(album);
		});
	}
	
	@Override
	public void populateAlbunsFromApi(){
		Pageable pageable = PageRequest.of(0, 20);
		genreService.listAll(pageable).getContent().forEach(genreDTO -> {
			ResponseSpotifyDTO responseSpotifyDTO = apiSpotifyService.getAlbunsByGenre(genreDTO.getDescription());
			saveAlbuns(genreDTO, responseSpotifyDTO);
		});
	}

	private void saveAlbuns(GenreDTO genreDTO, ResponseSpotifyDTO responseSpotifyDTO) {
		responseSpotifyDTO.getAlbums().getItems().forEach(item -> {
			ArtistDTO artistDTO = item.getArtists().get(0);
			albumService.save(new Album(null,item.getName(),
					artistDTO.getName(),
					item.getTotalTracks(),
					item.getReleaseDate(),
					ApiUtils.generatePriceRandom(10,50),
					genreService.convertToEntity(genreDTO)));
		});
	}

	private String getJsonFromFile() throws IOException {
		File file = ResourceUtils.getFile("classpath:albuns.json");
		return new String(Files.readAllBytes(file.toPath()));
	}

}
