package br.com.pedrosa.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.pedrosa.api.domain.Album;
import br.com.pedrosa.api.dto.AlbumDTO;
import br.com.pedrosa.api.exception.ResourceNotFoundException;

public interface AlbumService{
	
	Page<AlbumDTO> findByGenreId(Long genreId, Pageable pageable);
	
	Page<AlbumDTO> listAll(Pageable pageable);
	
	AlbumDTO findById(Long id) throws ResourceNotFoundException;
	
	void save(Album album);
}
