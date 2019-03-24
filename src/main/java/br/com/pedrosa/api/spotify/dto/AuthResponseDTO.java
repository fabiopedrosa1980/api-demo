package br.com.pedrosa.api.spotify.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponseDTO {
	
	@JsonProperty(value="access_token")
	private String accessToken;
	
	@JsonProperty(value="expires_in")
	private String expiresIn;
	
	@JsonProperty(value="refresh_token")
	private String refreshToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
