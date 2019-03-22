package br.com.pedrosa.api.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class AlbumDTO implements Serializable {
	
	private static final long serialVersionUID = 6018637542879766039L;

	@NotNull(message="Id do Album é obrigatório")
	private Long id;

	@NotEmpty(message="Nome é obrigatório")
	private String name;

	@NotEmpty(message="Artista é obrigatório")
	private String artist;

	@NotNull(message="Faixas é obrigatório")
	private Integer tracks;

	@NotEmpty(message="Data de Lançamento é obrigatório")
	private String dateRelease;

	@NotNull(message="Preço é obrigatório")
	private Double price;
	
	@Valid
	private GenreDTO genre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Integer getTracks() {
		return tracks;
	}

	public void setTracks(Integer tracks) {
		this.tracks = tracks;
	}


	public String getDateRelease() {
		return dateRelease;
	}

	public void setDateRelease(String dateRelease) {
		this.dateRelease = dateRelease;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public GenreDTO getGenre() {
		return genre;
	}

	public void setGenre(GenreDTO genre) {
		this.genre = genre;
	}
	
}
