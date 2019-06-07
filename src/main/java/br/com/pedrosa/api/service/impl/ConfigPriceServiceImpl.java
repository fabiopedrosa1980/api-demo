package br.com.pedrosa.api.service.impl;

import br.com.pedrosa.api.domain.ConfigPrice;
import br.com.pedrosa.api.repository.ConfigPriceRepository;
import br.com.pedrosa.api.service.ConfigPriceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfigPriceServiceImpl implements ConfigPriceService {
	
	private ConfigPriceRepository configPriceRepository;

	@Override
	public ConfigPrice findByDayAndGenreId(String day, Long genreId) {
		return configPriceRepository.findByDayAndGenreId(day, genreId);
	}
	

}
