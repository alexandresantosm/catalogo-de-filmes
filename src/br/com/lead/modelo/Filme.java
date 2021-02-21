package br.com.lead.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nm_filme", nullable = false)
	private String nome;
	private String genero;
	private Integer ano;
	
	public Filme() {}

	public Filme(String nome, String genero, Integer ano) {
		this.nome = nome;
		this.genero = genero;
		this.ano = ano;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getGenero() {
		return genero;
	}

	public Integer getAno() {
		return ano;
	}

}
