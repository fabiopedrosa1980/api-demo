package br.com.pedrosa.api.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.pedrosa.api.spotify.dto.AuthResponseDTO;
import br.com.pedrosa.api.spotify.dto.ResponseSpotifyDTO;

@Service
public class ApiSpotifyService {
	
	@Value("${urlSpotify}")
	private String urlSpotify;

	@Value("${urlSpotifyToken}")
	private String urlSpotifyToken;
	
	@Value("${clientId}")
	private String clientId; 
	
	@Value("${clientSecret}")
	private String clientSecret; 
	
	private RestTemplate restTemplate;
	
	public ApiSpotifyService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public AuthResponseDTO getToken(){
		ResponseEntity<AuthResponseDTO> result = restTemplate.exchange(urlSpotifyToken, HttpMethod.POST, buildHttpAuthorizationBasic(),AuthResponseDTO.class);
		return result.getBody();
	}
	
	public ResponseSpotifyDTO getAlbunsByGenre(String genre){
		ResponseEntity<ResponseSpotifyDTO> result = restTemplate.exchange(urlSpotify + "search?q=" + genre + "&type=album&market=BR&limit=50", HttpMethod.GET, buildHttpAuthorizationBearer(),ResponseSpotifyDTO.class);
		return result.getBody();
	}	

	private HttpEntity<String> buildHttpAuthorizationBasic() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(clientId, clientSecret);
		return new HttpEntity<>(headers);
	}
	
	private HttpEntity<String> buildHttpAuthorizationBearer(){
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(this.getToken().getAccessToken());
		return new HttpEntity<>(headers);
	}
}
