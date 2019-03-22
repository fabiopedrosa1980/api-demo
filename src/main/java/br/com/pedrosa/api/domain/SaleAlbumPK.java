package br.com.pedrosa.api.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SaleAlbumPK implements Serializable {
	
	private static final long serialVersionUID = 7366226189173766783L;
	
	public SaleAlbumPK() {}

	public SaleAlbumPK(Long idVenda, Long idAlbum) {
		super();
		this.idVenda = idVenda;
		this.idAlbum = idAlbum;
	}

	private Long idVenda;
	
	private Long idAlbum;

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
