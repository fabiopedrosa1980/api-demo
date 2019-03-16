package br.com.pedrosa.api.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pedrosa.api.domain.VendaAlbum;
import br.com.pedrosa.api.domain.VendaAlbumPK;

public interface VendaAlbumRepository extends JpaRepository<VendaAlbum, VendaAlbumPK> {
	
	@Query(value = "SELECT * FROM VENDA_ALBUM av WHERE av.id_venda = ?1 ", nativeQuery = true)
	Set<VendaAlbum> findByIdVenda(Long idVenda);

}
