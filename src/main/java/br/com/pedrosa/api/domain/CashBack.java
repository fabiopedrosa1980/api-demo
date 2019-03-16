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

	private Double valor;
	
	private Long idVenda;
	
	private Long idAlbum;
	
	public CashBack() {}
	
	public CashBack(Double valor, Long idVenda, Long idAlbum) {
		super();
		this.valor = valor;
		this.idVenda = idVenda;
		this.idAlbum = idAlbum;
	}

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
