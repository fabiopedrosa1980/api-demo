package br.com.pedrosa.api;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.pedrosa.api.service.impl.PopulateAlbunsServiceImpl;

@SpringBootApplication
public class ApiApplication {
	
	@Autowired
	private PopulateAlbunsServiceImpl populateAlbunsService;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@PostConstruct
    public void init() {
      this.populateAlbunsService.populateAlbunsFromApi();
    }

}
