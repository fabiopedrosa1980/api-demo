package br.com.pedrosa.api.service.impl;

import org.springframework.stereotype.Service;

import br.com.pedrosa.api.domain.ConfigPrice;
import br.com.pedrosa.api.repository.ConfigPriceRepository;
import br.com.pedrosa.api.service.ConfigPriceService;

@Service
public class ConfigPriceServiceImpl implements ConfigPriceService {
	
	private ConfigPriceRepository configPriceRepository;

	public ConfigPriceServiceImpl(ConfigPriceRepository configPriceRepository) {
		this.configPriceRepository = configPriceRepository;
	}

	@Override
	public ConfigPrice findByDayAndGenreId(String day, Long genreId) {
		return configPriceRepository.findByDayAndGenreId(day, genreId);
	}
	

}
