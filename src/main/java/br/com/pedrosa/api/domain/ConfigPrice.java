package br.com.pedrosa.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name="CONFIGPRICE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigPrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	private String day;
	private Double percent;
	@ManyToOne
	private Genre genre;
}
