package br.com.pedrosa.api.dto;

import java.io.Serializable;

public class CashBackDTO implements Serializable {
	
	private static final long serialVersionUID = 2375164155797450815L;

	private Long id;

	private Double amount;
	
	private Long idSale;
	
	private Long idAlbum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getIdSale() {
		return idSale;
	}

	public void setIdSale(Long idSale) {
		this.idSale = idSale;
	}

	public Long getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(Long idAlbum) {
		this.idAlbum = idAlbum;
	}
	
}
