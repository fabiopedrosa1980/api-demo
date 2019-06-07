package br.com.pedrosa.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedrosa.api.dto.GenreDTO;
import br.com.pedrosa.api.service.GenreService;

@RestController
@RequestMapping("api/V1/genre")
@AllArgsConstructor
public class GenreController  {
	
	private GenreService generoService;

	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<GenreDTO> listAll(Pageable pageable) {
		return generoService.listAll(pageable);
	}

}
