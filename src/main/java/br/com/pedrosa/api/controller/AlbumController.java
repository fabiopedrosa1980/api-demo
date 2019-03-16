package br.com.pedrosa.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedrosa.api.dto.AlbumDTO;
import br.com.pedrosa.api.exception.ResourceNotFoundException;
import br.com.pedrosa.api.service.AlbumService;


@RestController
@RequestMapping("api/V1/album")
public class AlbumController{
	
	@Autowired
	private AlbumService albumService;
	
	@GetMapping("{id}")
	public ResponseEntity<AlbumDTO> findById(@PathVariable Long id) throws ResourceNotFoundException {
		return ResponseEntity.ok().body(albumService.findById(id));
	}
	
	@GetMapping("genre/{genreId}")
	public ResponseEntity<Page<AlbumDTO>> findByGenreId(@PathVariable Long genreId,Pageable pageable) {
		return ResponseEntity.ok().body(albumService.findByGeneroId(genreId, pageable));
	}
	
	@GetMapping
	public ResponseEntity<Page<AlbumDTO>> listAll(Pageable pageable) {
		return ResponseEntity.ok().body(albumService.listAll(pageable) );
	}

}
