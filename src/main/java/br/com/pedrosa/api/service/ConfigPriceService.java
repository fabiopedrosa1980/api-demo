package br.com.pedrosa.api.service;

import br.com.pedrosa.api.domain.ConfigPrice;

public interface ConfigPriceService {
	
	public ConfigPrice findByDayAndGenreId(String day, Long genreId);
	
}
