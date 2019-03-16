package br.com.pedrosa.api.dto;

import java.io.Serializable;

public class CashBackDTO implements Serializable {
	
	private static final long serialVersionUID = 2375164155797450815L;

	private Long id;

	private Double valor;
	
	private Long idVenda;
	
	private Long idAlbum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	public Long getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(Long idAlbum) {
		this.idAlbum = idAlbum;
	}

}
