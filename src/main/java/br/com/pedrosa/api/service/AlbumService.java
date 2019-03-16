package br.com.pedrosa.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.pedrosa.api.domain.Album;
import br.com.pedrosa.api.dto.AlbumDTO;

public interface AlbumService extends CrudService<Album, Long> {
	
	Page<AlbumDTO> findByGeneroId(Long generoId, Pageable pageable);
	
	Page<AlbumDTO> listAll(Pageable pageable);
	
	AlbumDTO findById(Long id);
}
