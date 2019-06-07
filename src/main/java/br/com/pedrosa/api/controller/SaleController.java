package br.com.pedrosa.api.controller;

import java.io.UnsupportedEncodingException;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedrosa.api.dto.SaleDTO;
import br.com.pedrosa.api.dto.SaleInDTO;
import br.com.pedrosa.api.exception.ResourceNotFoundException;
import br.com.pedrosa.api.service.SaleService;
import br.com.pedrosa.api.utils.ApiUtils;


@RestController
@RequestMapping("api/V1/sale")
@AllArgsConstructor
public class SaleController   {
	
	private SaleService vendaService;

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public SaleDTO findById(@PathVariable Long id) throws ResourceNotFoundException {
		return vendaService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SaleDTO sell(@Valid @RequestBody SaleInDTO venda) {
		return vendaService.sell(venda);
		
	}
	
	@GetMapping("search/{startDate}/{endDate}")
	@ResponseStatus(HttpStatus.OK)
	public Page<SaleDTO> search(@PathVariable String startDate, @PathVariable String endDate,Pageable pageable) throws UnsupportedEncodingException {
		return vendaService.findAllSallesByPeriod(ApiUtils.decode(startDate), ApiUtils.decode(endDate), pageable);
	}

}
