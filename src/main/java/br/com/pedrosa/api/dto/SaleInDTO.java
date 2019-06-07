package br.com.pedrosa.api.dto;

import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleInDTO {

	@Valid
	private Set<AlbumDTO> albuns;
	@JsonIgnore
	private LocalDateTime dateSale =  LocalDateTime.now();
}
