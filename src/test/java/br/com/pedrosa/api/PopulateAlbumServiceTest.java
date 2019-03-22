package br.com.pedrosa.api;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pedrosa.api.service.impl.PopulateAlbunsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PopulateAlbumServiceTest {
	
	@Autowired
	private PopulateAlbunsService populateAlbunsService;

	@Test
	public void populateAlbumFromJsonTest() throws Exception {
		assertTrue(populateAlbunsService.populateAlbunsFromJson());
	}

}
