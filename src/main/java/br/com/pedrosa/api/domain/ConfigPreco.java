package br.com.pedrosa.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="CONFIGPRECO")
public class ConfigPreco implements Serializable {

	private static final long serialVersionUID = 5036657966884765000L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	private String dia;
	
	private Double porcentagem;
	
	@ManyToOne
	private Genero genero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Double getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(Double porcentagem) {
		this.porcentagem = porcentagem;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
			
	
}
