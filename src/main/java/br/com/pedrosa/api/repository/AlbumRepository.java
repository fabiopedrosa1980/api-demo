package br.com.pedrosa.api.repository;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pedrosa.api.domain.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

	@Query(value = "SELECT * FROM Album a WHERE a.genero_id = ?1 ORDER BY a.nome DESC", nativeQuery = true)
	Page<Album> findByGeneroId(Long generoId, Pageable pageable);
	
	@Query(value = "SELECT * FROM Album a WHERE a.venda_id = ?1 ORDER BY a.nome DESC", nativeQuery = true)
	Set<Album> findByIdVenda(Long idVenda);

}
