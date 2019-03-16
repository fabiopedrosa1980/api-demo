package br.com.pedrosa.api.spotify.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/webhock")
public class WebHockSpotifyController {
	
	@GetMapping
	public String refreshToken(@RequestParam String code) {
		return "Codigo retornado " + code;
	}
	
	
}
