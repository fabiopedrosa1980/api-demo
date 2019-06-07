package br.com.pedrosa.api.spotify.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
	
	private String name;
	
	@JsonProperty(value="release_date")
	private String releaseDate;
	
	@JsonProperty(value="total_tracks")
	private Integer totalTracks;
	
	private List<ArtistDTO> artists;

}
