package br.com.pedrosa.api;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pedrosa.api.exception.SpotifyException;
import br.com.pedrosa.api.service.impl.ApiSpotifyService;
import br.com.pedrosa.api.spotify.dto.AuthResponseDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenSpotifyTest {
 
    @Autowired
    private ApiSpotifyService apiSpotifyService;
    
    @Test
	public void getTokenFromSpotify() throws SpotifyException {
    	AuthResponseDTO authResponseDTO = apiSpotifyService.getToken();
    	assertNotNull(authResponseDTO.getAccessToken());
    	assertNotNull(authResponseDTO.getRefreshToken());
    	assertNotNull(authResponseDTO.getExpiresIn());
	}

}
