package br.com.pedrosa.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ALBUM")
public class Album implements Serializable {

	private static final long serialVersionUID = 2466847570460914386L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	private String name;

	private String artist;

	private Integer tracks;

	private String dateRelease;

	private Double price;
	
	@OneToOne
	private Genre genre;

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

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
}
