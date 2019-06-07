package br.com.pedrosa.api.service.impl;

import br.com.pedrosa.api.domain.Genre;
import br.com.pedrosa.api.dto.GenreDTO;
import br.com.pedrosa.api.repository.GenreRepository;
import br.com.pedrosa.api.service.GenreService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

	private GenreRepository generoRepository;
	private ModelMapper modelMapper;

	@Override
	public GenreDTO findByDescription(String description) {
		return this.convertToDTO(generoRepository.findByDescription(description));
	}
	
	@Override
	public Page<GenreDTO> listAll(Pageable pageable) {
		return this.buildPageDTO(generoRepository.findAll(pageable));
	}
	
	private Page<GenreDTO> buildPageDTO(Page<Genre> genres) {
		return genres.map(genre -> convertToDTO(genre));
	}
	
	public GenreDTO convertToDTO(Genre genero) {
		return modelMapper.map(genero, GenreDTO.class);
	}
	
	public Genre convertToEntity(GenreDTO genreDTO) {
		return modelMapper.map(genreDTO, Genre.class);
	}

	
	

}
