package br.com.pedrosa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pedrosa.api.domain.ConfigPreco;

public interface ConfigPrecoRepository extends JpaRepository<ConfigPreco, Long> {
	
	@Query(value = "SELECT * FROM ConfigPreco cp WHERE cp.dia = ?1 and cp.genero_id = ?2", nativeQuery = true)
	ConfigPreco findByDiaAndGeneroId(String dia, Long generoId);
	
}
