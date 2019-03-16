package br.com.pedrosa.apibeblue;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pedrosa.api.service.impl.PopularDiscosService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PopulaDiscoServiceTest {
	
	@Autowired
	private PopularDiscosService popularDiscosService;

	@Test
	public void populaDiscosFromJsonTest() throws Exception {
		assertTrue(popularDiscosService.populaDiscosFromJson());
	}

}
