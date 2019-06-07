package br.com.pedrosa.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="SALE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	private Double cashBack;
	private Double totalOrder;
	@Transient
	private Set<Album> albuns;
	@Transient
	private Set<CashBack> cashBacks;
	private LocalDateTime dateSale;
	
}
