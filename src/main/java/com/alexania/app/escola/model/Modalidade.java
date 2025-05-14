package com.alexania.app.escola.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_modalidade")
public class Modalidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo modalidade deverá ser preenchido.")
	private String modalidade;
	
	@NotBlank(message = "O atributo modalidade deverá ser preenchido.")
	private String descricao;
	
	@DecimalMin(value = "0.00", message = "O atributo valor aula não pode ser negativo!")
	private double valorAula;
	
	@Min(40)
	@Max(60)
	private int tempoAula;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorAula() {
		return valorAula;
	}

	public void setValorAula(double valorAula) {
		this.valorAula = valorAula;
	}

	public int getTempoAula() {
		return tempoAula;
	}

	public void setTempoAula(int tempoAula) {
		this.tempoAula = tempoAula;
	}
	
	
}
