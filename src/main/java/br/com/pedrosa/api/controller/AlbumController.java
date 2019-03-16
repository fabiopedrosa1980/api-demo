package br.com.pedrosa.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedrosa.api.dto.AlbumDTO;
import br.com.pedrosa.api.service.AlbumService;


@RestController
@RequestMapping("api/V1/album")
public class AlbumController{
	
	@Autowired
	private AlbumService albumService;
	
	@GetMapping("{id}")
	public ResponseEntity<AlbumDTO> findById(@PathVariable Long id) {
		AlbumDTO entity = albumService.findById(id);
		if (entity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AlbumDTO>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("genre/{genreId}")
	public ResponseEntity<Page<AlbumDTO>> findByGenreId(@PathVariable Long genreId,Pageable pageable) {
		Page<AlbumDTO> entity = albumService.findByGeneroId(genreId, pageable);
		if (entity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Page<AlbumDTO>>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Page<AlbumDTO>> listAll(Pageable pageable) {
		Page<AlbumDTO> entity = albumService.listAll(pageable);
		if (entity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Page<AlbumDTO>>(entity, new HttpHeaders(), HttpStatus.OK);
	}

}
