package br.com.pedrosa.api.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="VENDA")
public class Venda implements Serializable {
	
	private static final long serialVersionUID = 5013830910329128861L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	private Double cashBack;
	
	private Double valorTotal;
	
	@Transient
	private Set<Album> albuns;
	
	@Transient
	private Set<CashBack> cashBacks;
	
	
	private LocalDateTime dataVenda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(Set<Album> albuns) {
		this.albuns = albuns;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Double getCashBack() {
		return cashBack;
	}

	public void setCashBack(Double cashBack) {
		this.cashBack = cashBack;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public Set<CashBack> getCashBacks() {
		return cashBacks;
	}

	public void setCashBacks(Set<CashBack> cashBacks) {
		this.cashBacks = cashBacks;
	}

	
	

}
