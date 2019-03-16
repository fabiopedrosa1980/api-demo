package br.com.pedrosa.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.pedrosa.api.domain.Genero;
import br.com.pedrosa.api.dto.GeneroDTO;

public interface GeneroService extends CrudService<Genero, Long> {
	
	GeneroDTO findByDescricao(String descricao);
	
	Page<GeneroDTO> listAll(Pageable pageable);
	
	
}
