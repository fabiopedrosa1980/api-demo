package br.com.pedrosa.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedrosa.api.dto.AlbumDTO;
import br.com.pedrosa.api.exception.ResourceNotFoundException;
import br.com.pedrosa.api.service.AlbumService;

@RestController
@RequestMapping("api/V1/album")
@AllArgsConstructor
public class AlbumController{
	
	private AlbumService albumService;

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public AlbumDTO findById(@PathVariable Long id) throws ResourceNotFoundException {
		return albumService.findById(id);
	}
	
	@GetMapping("genre/{genreId}")
	@ResponseStatus(HttpStatus.OK)
	public Page<AlbumDTO> findByGenreId(@PathVariable Long genreId,Pageable pageable) {
		return albumService.findByGenreId(genreId, pageable);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<AlbumDTO> listAll(Pageable pageable) {
		return albumService.listAll(pageable);
	}

}
