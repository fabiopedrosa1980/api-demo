package br.com.pedrosa.api.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedrosa.api.dto.VendaDTO;
import br.com.pedrosa.api.dto.VendaEntradaDTO;
import br.com.pedrosa.api.exception.ResourceNotFoundException;
import br.com.pedrosa.api.service.VendaService;
import br.com.pedrosa.api.utils.ApiUtils;


@RestController
@RequestMapping("api/V1/sale")
public class VendaController   {
	
	@Autowired
	private VendaService vendaService;
	
	@GetMapping("{id}")
	public ResponseEntity<VendaDTO> findById(@PathVariable Long id) throws ResourceNotFoundException {
		return ResponseEntity.ok().body(vendaService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<VendaDTO> sell(@RequestBody VendaEntradaDTO venda) {
		VendaDTO vendaDTO = vendaService.sell(venda);
		return new ResponseEntity<VendaDTO>(vendaDTO, new HttpHeaders(), HttpStatus.CREATED);
		
	}
	
	@GetMapping("search/{startDate}/{endDate}")
	public ResponseEntity<Page<VendaDTO>> search(@PathVariable String startDate, @PathVariable String endDate,Pageable pageable) throws UnsupportedEncodingException {
		return ResponseEntity.ok().body( vendaService.findAllSallesByPeriod(ApiUtils.decode(startDate), ApiUtils.decode(endDate), pageable));
	}

}
