package br.com.pedrosa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedrosa.api.domain.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
	
	Genero findByDescricao(String descricao);
	
	
}
