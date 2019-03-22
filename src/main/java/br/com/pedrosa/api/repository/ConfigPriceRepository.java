package br.com.pedrosa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pedrosa.api.domain.ConfigPrice;

public interface ConfigPriceRepository extends JpaRepository<ConfigPrice, Long> {
	
	@Query(value = "SELECT * FROM ConfigPrice cp WHERE cp.day = ?1 and cp.genre_id = ?2", nativeQuery = true)
	ConfigPrice findByDayAndGenreId(String day, Long genreId);
	
}
