package br.com.pedrosa.apibeblue;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pedrosa.api.repository.AlbumRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumRepositoryTest {
 
    @Autowired
    private AlbumRepository albumRepository;
    
    @Test
	public void hasAlbum() {
		assertNotNull(albumRepository.findAll());
	}

    
    

}
