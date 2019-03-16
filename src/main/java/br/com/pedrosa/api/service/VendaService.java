package br.com.pedrosa.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.pedrosa.api.domain.Venda;
import br.com.pedrosa.api.dto.VendaDTO;
import br.com.pedrosa.api.dto.VendaEntradaDTO;

public interface VendaService extends CrudService<Venda, Long> {
	
	Page<VendaDTO> findAllSallesByPeriod(String startDate, String endDate, Pageable page);
	
	VendaDTO findById(Long id);
	
	VendaDTO sell(VendaEntradaDTO venda);
	
}
