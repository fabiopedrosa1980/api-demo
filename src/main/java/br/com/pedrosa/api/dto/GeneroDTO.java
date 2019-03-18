package br.com.pedrosa.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class GeneroDTO implements Serializable  {

	private static final long serialVersionUID = 5583646792340622221L;

	
	@NotNull(message="Id do Genero é obrigatório")
	private Long id;

	@NotEmpty(message="Descrição do Genero é obrigatório")
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
