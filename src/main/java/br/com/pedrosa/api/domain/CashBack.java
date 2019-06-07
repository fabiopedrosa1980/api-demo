package br.com.pedrosa.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CASHBACK")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CashBack{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	private Double amount;
	private Long idSale;
	private Long idAlbum;
}
