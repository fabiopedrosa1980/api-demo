package br.com.pedrosa.api.service;

import br.com.pedrosa.api.spotify.dto.AuthResponseDTO;
import br.com.pedrosa.api.spotify.dto.ResponseSpotifyDTO;

public interface ApiSpotifyService {
	
	public AuthResponseDTO getToken();
	
	public ResponseSpotifyDTO getAlbunsByGenre(String genre);
		

}
