package br.com.pedrosa.api.service.impl;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.pedrosa.api.domain.Genre;
import br.com.pedrosa.api.dto.GenreDTO;
import br.com.pedrosa.api.repository.GenreRepository;
import br.com.pedrosa.api.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

	private GenreRepository generoRepository;
	
	private ModelMapper modelMapper;
	
	public GenreServiceImpl(GenreRepository generoRepository, ModelMapper modelMapper) {
		this.generoRepository = generoRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public GenreDTO findByDescription(String description) {
		return this.convertToDTO(generoRepository.findByDescription(description));
	}
	
	@Override
	public Page<GenreDTO> listAll(Pageable pageable) {
		return this.buildPageDTO(generoRepository.findAll(pageable));
	}
	
	private Page<GenreDTO> buildPageDTO(Page<Genre> genres) {
		return genres.map(new Function<Genre, GenreDTO>() {
		    @Override
		    public GenreDTO apply(Genre album) {
		        return convertToDTO(album);
		    }
		});
	}
	
	private GenreDTO convertToDTO(Genre genero) {
		return modelMapper.map(genero, GenreDTO.class);
	}

	
	

}
