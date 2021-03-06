package br.com.pedrosa.api.service.impl;

import br.com.pedrosa.api.domain.Album;
import br.com.pedrosa.api.dto.AlbumDTO;
import br.com.pedrosa.api.exception.ResourceNotFoundException;
import br.com.pedrosa.api.repository.AlbumRepository;
import br.com.pedrosa.api.service.AlbumService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService {
	
	private AlbumRepository albumRepository;
	private ModelMapper modelMapper;

	@Override
	public void save(Album album) {
		albumRepository.save(album);
	}
	
	@Override
	public Page<AlbumDTO> findByGenreId(Long generoId, Pageable pageable) {
		return this.buildPageDTO(albumRepository.findByGeneroId(generoId, pageable));
	}

	@Override
	public Page<AlbumDTO> listAll(Pageable pageable) {
		return this.buildPageDTO(albumRepository.findAll(pageable));
	}
	
	@Override
	public AlbumDTO findById(Long id)throws ResourceNotFoundException {
		return this.convertToDTO(
				albumRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Album not found on "+ id)));
	}
	
	private Page<AlbumDTO> buildPageDTO(Page<Album> albuns) {
		return albuns.map(album -> convertToDTO(album));
	}
	
	private AlbumDTO convertToDTO(Album album) {
		return modelMapper.map(album, AlbumDTO.class);
	}

	
	

}
