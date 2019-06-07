package br.com.pedrosa.api.spotify.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
	
	@JsonProperty(value="access_token")
	private String accessToken;
	
	@JsonProperty(value="expires_in")
	private String expiresIn;
	
	@JsonProperty(value="refresh_token")
	private String refreshToken;



}
