package br.com.pedrosa.apibeblue;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pedrosa.api.dto.AlbumDTO;
import br.com.pedrosa.api.dto.VendaDTO;
import br.com.pedrosa.api.dto.VendaEntradaDTO;
import br.com.pedrosa.api.service.AlbumService;
import br.com.pedrosa.api.service.VendaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendaServiceTest {
	
	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private AlbumService albumService;
	

	@Test
	public void sellTest() {
		VendaEntradaDTO venda = new VendaEntradaDTO();
		Set<AlbumDTO> albums = new HashSet<>();
		albums.add(albumService.findById(1L));
		albums.add(albumService.findById(2L));
		albums.add(albumService.findById(3L));
		albums.add(albumService.findById(4L));
		venda.setAlbuns(albums);
		VendaDTO vendaDTO = vendaService.sell(venda);
		assertNotNull(vendaDTO);
		assertNotNull(vendaDTO.getValorTotal());
		assertNotNull(vendaDTO.getCashBack());
		assertNotNull(vendaDTO.getDataVenda());
		
	}
	
	/*@Test
	public void searchSalleTest() {
		VendaEntradaDTO venda = new VendaEntradaDTO();
		Set<AlbumDTO> albums = new HashSet<>();
		albums.add(albumService.findById(1L));
		venda.setAlbuns(albums);
		vendaService.sell(venda);
		
		LocalDate date = LocalDate.now();
	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String text = date.format(formatters);
		
		String startDate = text + " 00:00:00";
		String endDate =  text + " 23:59:59";
		Page<VendaDTO> vendasDTO = vendaService.findAllSallesByPeriod(startDate, endDate, null);
		assertNotNull(vendasDTO);
		
		
	}*/
	
	

}
