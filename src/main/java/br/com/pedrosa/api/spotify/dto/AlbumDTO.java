package br.com.pedrosa.api.spotify.dto;

import java.util.List;

public class AlbumDTO {
	
	private List<ItemDTO> items;

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

}
