package br.com.pedrosa.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedrosa.api.dto.GeneroDTO;
import br.com.pedrosa.api.service.GeneroService;


@RestController
@RequestMapping("api/V1/genre")
public class GeneroController  {
	
	@Autowired
	private GeneroService generoService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<GeneroDTO> listAll(Pageable pageable) {
		return generoService.listAll(pageable);
	}

}
