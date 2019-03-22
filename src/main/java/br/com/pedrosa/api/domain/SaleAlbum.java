package br.com.pedrosa.api.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SALE_ALBUM")
public class SaleAlbum implements Serializable  {
	
	private static final long serialVersionUID = -8890378410852160347L;
	
	@EmbeddedId
	private SaleAlbumPK pk;
	
	public SaleAlbum() {}
	
	public SaleAlbum(SaleAlbumPK pk) {
		super();
		this.pk = pk;
	}

	public SaleAlbumPK getPk() {
		return pk;
	}

	public void setPk(SaleAlbumPK pk) {
		this.pk = pk;
	}
	

}
