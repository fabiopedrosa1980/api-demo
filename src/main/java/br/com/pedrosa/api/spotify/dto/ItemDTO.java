package br.com.pedrosa.api.spotify.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemDTO {
	
	private String name;
	
	@JsonProperty(value="release_date")
	private String releaseDate;
	
	@JsonProperty(value="total_tracks")
	private Integer totalTracks;
	
	private List<ArtistDTO> artists;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getTotalTracks() {
		return totalTracks;
	}

	public void setTotalTracks(Integer totalTracks) {
		this.totalTracks = totalTracks;
	}

	public List<ArtistDTO> getArtists() {
		return artists;
	}

	public void setArtists(List<ArtistDTO> artists) {
		this.artists = artists;
	}

}
