package br.com.pedrosa.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class VendaDTO implements Serializable {
	
	private static final long serialVersionUID = 6088447928589369131L;

	private Long id;

	private Double cashBack;

	private Double valorTotal;
	
	@JsonIgnore
	private Set<AlbumDTO> albuns;
	
	private Set<CashBackDTO> cashBacks;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDateTime dataVenda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Set<CashBackDTO> getCashBacks() {
		return cashBacks;
	}

	public void setCashBacks(Set<CashBackDTO> cashBacks) {
		this.cashBacks = cashBacks;
	}

}
