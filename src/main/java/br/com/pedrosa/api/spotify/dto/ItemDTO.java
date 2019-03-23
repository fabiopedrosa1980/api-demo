package br.com.pedrosa.api.spotify.dto;

import java.util.List;

public class ItemDTO {
	
	private String name;
	
	private String release_date;
	
	private String total_tracks;
	
	private List<ArtistDTO> artists;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getTotal_tracks() {
		return total_tracks;
	}

	public void setTotal_tracks(String total_tracks) {
		this.total_tracks = total_tracks;
	}

	public List<ArtistDTO> getArtists() {
		return artists;
	}

	public void setArtists(List<ArtistDTO> artists) {
		this.artists = artists;
	}


}
