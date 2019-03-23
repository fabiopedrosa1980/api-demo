package br.com.pedrosa.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CASHBACK")
public class CashBack implements Serializable {
	
	private static final long serialVersionUID = -5274686763884511801L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	private Double amount;
	
	private Long idSale;
	
	private Long idAlbum;
	
	public CashBack() {}
	
	public CashBack(Double amount, Long idSale, Long idAlbum) {
		super();
		this.amount = amount;
		this.idSale = idSale;
		this.idAlbum = idAlbum;
	}

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
