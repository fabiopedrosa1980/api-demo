package br.com.pedrosa.api.dto;

import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class VendaEntradaDTO {

	private Set<AlbumDTO> albuns;
	
	@JsonIgnore
	private LocalDateTime dataVenda =  LocalDateTime.now();

	@Valid
	public Set<AlbumDTO> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(Set<AlbumDTO> albuns) {
		this.albuns = albuns;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

	

}
