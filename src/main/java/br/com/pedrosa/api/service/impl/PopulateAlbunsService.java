package br.com.pedrosa.api.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.pedrosa.api.domain.Album;
import br.com.pedrosa.api.exception.SpotifyException;
import br.com.pedrosa.api.service.AlbumService;
import br.com.pedrosa.api.spotify.dto.ResponseSpotifyDTO;
import br.com.pedrosa.api.utils.ApiUtils;

@Service
public class PopulateAlbunsService {

	private String urlSpotify = "https://api.spotify.com/v1/";

	private String accessToken = "BQCkOi3Eo6m473WaIwIWJjNT0fb_vZxMmTO93oAf5owg7h1l3jbWf5eTr2dP_AT-K33z5BxR7dzFXCNLCRJ--o6F1wovrJ8NcujjC3HwBFImgOMX-lk3DsvABhZ_xR-KNR3XgqAj1iRU1l_eq_q6kTT4RaDJIK-C4iEKKUMaXE7anRTD0MaGWYl7IfJ2GSdzKk5L7_IhCCG-FruLKivy4Ps";

	@Autowired
	private AlbumService albumService;

	@Autowired
	private RestTemplate restTemplate;

	public ResponseSpotifyDTO getAlbumsByGenre(String genre) throws SpotifyException {
		final HttpEntity<String> entity = buildHttpEntity();
		ResponseEntity<ResponseSpotifyDTO> result = restTemplate.exchange(urlSpotify + "search?q=" + genre + "&type=album&market=BR&limit=50", HttpMethod.GET, entity,ResponseSpotifyDTO.class);
		if (result.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
			throw new SpotifyException("Token expirado, favor gerar um novo");
		}
		return result.getBody();
	}

	private HttpEntity<String> buildHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + accessToken);
		return new HttpEntity<>(headers);
	}
	
	public boolean populateAlbunsFromJson() throws  IOException {
		boolean retorno = false;
		String content = getJsonFromFile();
		ObjectMapper objectMapper = new ObjectMapper();
		List<Album> albuns = objectMapper.readValue(content, new TypeReference<List<Album>>() {});

		for (Album album : albuns) {
			album.setPrice(ApiUtils.generatePriceRandom(10,50));
			albumService.save(album);
			retorno = true;
		}

		return retorno;

	}

	private String getJsonFromFile() throws IOException {
		File file = ResourceUtils.getFile("classpath:albuns.json");
		return new String(Files.readAllBytes(file.toPath()));
	}

}
