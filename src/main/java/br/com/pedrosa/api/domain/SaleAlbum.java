package br.com.pedrosa.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SALE_ALBUM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleAlbum {

	@EmbeddedId
	private SaleAlbumPK pk;
}
