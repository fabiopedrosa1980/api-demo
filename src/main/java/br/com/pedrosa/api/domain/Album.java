package br.com.pedrosa.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ALBUM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	private String name;
	private String artist;
	private Integer tracks;
	private String dateRelease;
	private Double price;
	@OneToOne
	private Genre genre;
}
