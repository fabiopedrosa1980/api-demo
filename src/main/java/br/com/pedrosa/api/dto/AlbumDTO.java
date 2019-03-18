package br.com.pedrosa.api.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class AlbumDTO implements Serializable {
	
	private static final long serialVersionUID = 6018637542879766039L;

	private Long id;

	@NotEmpty(message="Nome é obrigatório")
	private String nome;

	@NotEmpty(message="Artista é obrigatório")
	private String artista;

	@NotNull(message="Faixas é obrigatório")
	private Integer faixas;

	@NotEmpty(message="Data de Lançamento é obrigatório")
	private String dataLancamento;

	@NotNull(message="Preço é obrigatório")
	private Double preco;
	
	@Valid
	private GeneroDTO genero;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public Integer getFaixas() {
		return faixas;
	}

	public void setFaixas(Integer faixas) {
		this.faixas = faixas;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public GeneroDTO getGenero() {
		return genero;
	}

	public void setGenero(GeneroDTO genero) {
		this.genero = genero;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
