package br.com.pedrosa.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pedrosa.api.service.impl.PopulateAlbunsServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PopulateAlbumServiceTest {
	
	@Autowired
	private PopulateAlbunsServiceImpl populateAlbunsService;

	@Test
	public void populateAlbumFromJsonTest() throws Exception {
		populateAlbunsService.populateAlbunsFromJson();
	}
	
	@Test
	public void populateAlbumFromAPI() throws Exception {
		populateAlbunsService.populateAlbunsFromApi();
	}

}
