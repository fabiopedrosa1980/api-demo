package br.com.pedrosa.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

	private Long id;
	private Double cashBack;
	private Double totalOrder;
	@JsonIgnore
	private Set<AlbumDTO> albuns;
	private Set<CashBackDTO> cashBacks;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDateTime dateSale;
}
