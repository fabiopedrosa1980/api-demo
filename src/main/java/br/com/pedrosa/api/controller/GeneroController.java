package br.com.pedrosa.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedrosa.api.dto.GeneroDTO;
import br.com.pedrosa.api.service.GeneroService;


@RestController
@RequestMapping("api/V1/genre")
public class GeneroController  {
	
	@Autowired
	private GeneroService generoService;
	
	@GetMapping
	public ResponseEntity<Page<GeneroDTO>> listAll(Pageable pageable) {
		Page<GeneroDTO> entity = generoService.listAll(pageable);
		if (entity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Page<GeneroDTO>>(entity, new HttpHeaders(), HttpStatus.OK);
	}

}
