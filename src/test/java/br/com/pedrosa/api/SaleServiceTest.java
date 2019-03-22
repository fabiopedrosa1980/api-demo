package br.com.pedrosa.api;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pedrosa.api.dto.AlbumDTO;
import br.com.pedrosa.api.dto.SaleDTO;
import br.com.pedrosa.api.dto.SaleInDTO;
import br.com.pedrosa.api.exception.ResourceNotFoundException;
import br.com.pedrosa.api.service.AlbumService;
import br.com.pedrosa.api.service.SaleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaleServiceTest {
	
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private AlbumService albumService;

	@Test
	public void sellTest() throws ResourceNotFoundException {
		SaleInDTO venda = new SaleInDTO();
		Set<AlbumDTO> albums = new HashSet<>();
		albums.add(albumService.findById(1L));
		albums.add(albumService.findById(2L));
		albums.add(albumService.findById(3L));
		albums.add(albumService.findById(4L));
		venda.setAlbuns(albums);
		SaleDTO vendaDTO = saleService.sell(venda);
		assertNotNull(vendaDTO);
		assertNotNull(vendaDTO.getTotalOrder());
		assertNotNull(vendaDTO.getCashBack());
		assertNotNull(vendaDTO.getDateSale());
		
	}
	

}
