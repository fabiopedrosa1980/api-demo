package br.com.pedrosa.api.service.impl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.pedrosa.api.domain.Album;
import br.com.pedrosa.api.dto.AlbumDTO;
import br.com.pedrosa.api.exception.ResourceNotFoundException;
import br.com.pedrosa.api.repository.AlbumRepository;
import br.com.pedrosa.api.service.AlbumService;

@Service
public class AlbumServiceImpl extends AbstractService<Album, Long> implements AlbumService {
	
	private AlbumRepository albumRepository;
	
	@Autowired
	public void setRepository(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
		super.setRepository(albumRepository);
	}
	@Override
	public Page<AlbumDTO> findByGeneroId(Long generoId, Pageable pageable) {
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
		Page<AlbumDTO> dtoAlbum = albuns.map(new Function<Album, AlbumDTO>() {
		    @Override
		    public AlbumDTO apply(Album album) {
		        return convertToDTO(album);
		    }
		});
		return dtoAlbum;
	}
	
	private AlbumDTO convertToDTO(Album album) {
		AlbumDTO albumDTO = modelMapper.map(album, AlbumDTO.class);
		return albumDTO;
	}
	

}
