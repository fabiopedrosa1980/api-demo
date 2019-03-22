package br.com.pedrosa.api.dto;

import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SaleInDTO {

	private Set<AlbumDTO> albuns;
	
	@JsonIgnore
	private LocalDateTime dateSale =  LocalDateTime.now();

	@Valid
	public Set<AlbumDTO> getAlbuns() {
		return albuns;
	}

	public LocalDateTime getDateSale() {
		return dateSale;
	}

	public void setDateSale(LocalDateTime dateSale) {
		this.dateSale = dateSale;
	}

	public void setAlbuns(Set<AlbumDTO> albuns) {
		this.albuns = albuns;
	}


}
