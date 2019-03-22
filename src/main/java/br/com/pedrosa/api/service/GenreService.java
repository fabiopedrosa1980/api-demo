package br.com.pedrosa.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.pedrosa.api.dto.GenreDTO;

public interface GenreService {
	
	GenreDTO findByDescription(String description);
	
	Page<GenreDTO> listAll(Pageable pageable);
	
	
}
