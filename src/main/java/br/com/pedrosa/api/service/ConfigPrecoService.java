package br.com.pedrosa.api.service;

import br.com.pedrosa.api.domain.ConfigPreco;

public interface ConfigPrecoService extends CrudService<ConfigPreco, Long> {
	
	public ConfigPreco findByDiaAndGeneroId(String dia, Long generoId);
	
}
