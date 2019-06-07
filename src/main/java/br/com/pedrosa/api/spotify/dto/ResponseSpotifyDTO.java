package br.com.pedrosa.api.spotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSpotifyDTO {
	
	private AlbumDTO albums;

}
