package br.com.pedrosa.api.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="VENDA_ALBUM")
public class VendaAlbum implements Serializable  {
	
	private static final long serialVersionUID = -8890378410852160347L;
	
	@EmbeddedId
	private VendaAlbumPK pk;
	
	public VendaAlbum() {}
	
	public VendaAlbum(VendaAlbumPK pk) {
		super();
		this.pk = pk;
	}

	public VendaAlbumPK getPk() {
		return pk;
	}

	public void setPk(VendaAlbumPK pk) {
		this.pk = pk;
	}
	

}
