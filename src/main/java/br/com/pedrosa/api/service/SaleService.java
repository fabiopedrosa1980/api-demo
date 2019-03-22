package br.com.pedrosa.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.pedrosa.api.dto.SaleDTO;
import br.com.pedrosa.api.dto.SaleInDTO;
import br.com.pedrosa.api.exception.ResourceNotFoundException;

public interface SaleService {
	
	Page<SaleDTO> findAllSallesByPeriod(String startDate, String endDate, Pageable page);
	
	SaleDTO findById(Long id) throws ResourceNotFoundException;
	
	SaleDTO sell(SaleInDTO sale);
	
}
