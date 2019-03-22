package br.com.pedrosa.api.spotify.dto;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ItemDTO {
	
	private String name;
	
	@JsonProperty("release_date")
	private String releaseDate;
	
	@JsonProperty("total_tracks")
	private String totalTracks;
	
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

	public String getTotalTracks() {
		return totalTracks;
	}

	public void setTotalTracks(String totalTracks) {
		this.totalTracks = totalTracks;
	}

	public List<ArtistDTO> getArtists() {
		return artists;
	}

	public void setArtists(List<ArtistDTO> artists) {
		this.artists = artists;
	}

}
