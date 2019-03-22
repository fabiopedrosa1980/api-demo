package br.com.pedrosa.api.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pedrosa.api.domain.SaleAlbum;
import br.com.pedrosa.api.domain.SaleAlbumPK;

public interface SaleAlbumRepository extends JpaRepository<SaleAlbum, SaleAlbumPK> {
	
	@Query(value = "SELECT * FROM SALE_ALBUM sa WHERE sa.id_sale = ?1 ", nativeQuery = true)
	Set<SaleAlbum> findByIdVenda(Long idVenda);

}
