package br.com.pedrosa.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {

	@NotNull(message="Id do Album é obrigatório")
	private Long id;

	@NotEmpty(message="Nome é obrigatório")
	private String name;

	@NotEmpty(message="Artista é obrigatório")
	private String artist;

	@NotNull(message="Faixas é obrigatório")
	private Integer tracks;

	@NotEmpty(message="Data de Lançamento é obrigatório")
	private String dateRelease;

	@NotNull(message="Preço é obrigatório")
	private Double price;
	
	@Valid
	private GenreDTO genre;


}
