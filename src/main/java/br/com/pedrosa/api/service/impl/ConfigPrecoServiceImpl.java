package br.com.pedrosa.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedrosa.api.domain.ConfigPreco;
import br.com.pedrosa.api.repository.ConfigPrecoRepository;
import br.com.pedrosa.api.service.ConfigPrecoService;

@Service
public class ConfigPrecoServiceImpl extends AbstractService<ConfigPreco, Long> implements ConfigPrecoService {
	
	private ConfigPrecoRepository configPrecoRepository;
	
	@Autowired
	public void setRepository(ConfigPrecoRepository configPrecoRepository) {
		super.setRepository(configPrecoRepository);
		this.configPrecoRepository = configPrecoRepository;
	}

	@Override
	public ConfigPreco findByDiaAndGeneroId(String dia, Long generoId) {
		return configPrecoRepository.findByDiaAndGeneroId(dia, generoId);
	}

}
