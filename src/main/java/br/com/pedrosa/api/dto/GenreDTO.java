package br.com.pedrosa.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {

	@NotNull(message="Id do Genero é obrigatório")
	private Long id;
	@NotEmpty(message="Descrição do Genero é obrigatório")
	private String description;
}
