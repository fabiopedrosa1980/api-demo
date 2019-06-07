package br.com.pedrosa.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CashBackDTO {

	private Long id;
	private Double amount;
	private Long idSale;
	private Long idAlbum;
}
