package br.com.pedrosa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedrosa.api.domain.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
	
	Genre findByDescription(String description);
	
	
}
