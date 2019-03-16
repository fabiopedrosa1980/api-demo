package br.com.pedrosa.api.service.impl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.pedrosa.api.domain.Genero;
import br.com.pedrosa.api.dto.GeneroDTO;
import br.com.pedrosa.api.repository.GeneroRepository;
import br.com.pedrosa.api.service.GeneroService;

@Service
public class GeneroServiceImpl extends AbstractService<Genero, Long> implements GeneroService {
	
	private GeneroRepository generoRepository;
	
	@Autowired
	public void setRepository(GeneroRepository generoRepository) {
		super.setRepository(generoRepository);
		this.generoRepository = generoRepository;
	}

	@Override
	public GeneroDTO findByDescricao(String descricao) {
		return this.convertToDTO(generoRepository.findByDescricao(descricao));
	}
	
	@Override
	public Page<GeneroDTO> listAll(Pageable pageable) {
		return this.buildPageDTO(generoRepository.findAll(pageable));
	}
	
	private Page<GeneroDTO> buildPageDTO(Page<Genero> generos) {
		Page<GeneroDTO> dtoGenero = generos.map(new Function<Genero, GeneroDTO>() {
		    @Override
		    public GeneroDTO apply(Genero album) {
		        return convertToDTO(album);
		    }
		});
		return dtoGenero;
	}
	
	private GeneroDTO convertToDTO(Genero genero) {
		GeneroDTO generoDTO = modelMapper.map(genero, GeneroDTO.class);
		return generoDTO;
	}

	
	

}
