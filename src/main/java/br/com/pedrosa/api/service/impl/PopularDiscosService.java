package br.com.pedrosa.api.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.pedrosa.api.domain.Album;
import br.com.pedrosa.api.service.AlbumService;
import br.com.pedrosa.api.spotify.dto.ResponseSpotfyDTO;
import br.com.pedrosa.api.utils.ApiUtils;

@Service
public class PopularDiscosService {

	private String url_spotify = "https://api.spotify.com/v1/";

	private String accessToken = "BQCkOi3Eo6m473WaIwIWJjNT0fb_vZxMmTO93oAf5owg7h1l3jbWf5eTr2dP_AT-K33z5BxR7dzFXCNLCRJ--o6F1wovrJ8NcujjC3HwBFImgOMX-lk3DsvABhZ_xR-KNR3XgqAj1iRU1l_eq_q6kTT4RaDJIK-C4iEKKUMaXE7anRTD0MaGWYl7IfJ2GSdzKk5L7_IhCCG-FruLKivy4Ps";

	@Autowired
	private AlbumService albumService;

	@Autowired
	private RestTemplate restTemplate;

	public ResponseSpotfyDTO getAlbumsByGenre(String genre) throws RuntimeException {
		final HttpEntity<String> entity = buildHttpEntity();
		ResponseEntity<ResponseSpotfyDTO> result = restTemplate.exchange(url_spotify + "search?q=" + genre + "&type=album&market=BR&limit=50", HttpMethod.GET, entity,ResponseSpotfyDTO.class);
		if (result.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
			new RuntimeException("Token expirado, favor gerar um novo");
		}
		return result.getBody();
	}

	private HttpEntity<String> buildHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + accessToken);
		final HttpEntity<String> entity = new HttpEntity<String>(headers);
		return entity;
	}

	
	public boolean populaDiscosFromJson() throws JsonParseException, JsonMappingException, IOException {
		boolean retorno = false;
		String content = getJsonFromFile();
		ObjectMapper objectMapper = new ObjectMapper();
		List<Album> albuns = objectMapper.readValue(content, new TypeReference<List<Album>>() {});

		for (Album album : albuns) {
			album.setPreco(ApiUtils.geraPrecoRandom());
			albumService.salvar(album);
			retorno = true;
		}

		return retorno;

	}

	private String getJsonFromFile() throws FileNotFoundException, IOException {
		File file = ResourceUtils.getFile("classpath:albuns.json");
		String content = new String(Files.readAllBytes(file.toPath()));
		return content;
	}

}
