package com.alexania.app.escola.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_aluno")
public class Aluno extends Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Min(1)
	@Max(31)
	private int diaPagamento;
	
	@NotBlank(message = "O atributo plano deverá ser preenchido.")
	private String planoEscolhido;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getDiaPagamento() {
		return diaPagamento;
	}

	public void setDiaPagamento(int diaPagamento) {
		this.diaPagamento = diaPagamento;
	}

	public String getPlanoEscolhido() {
		return planoEscolhido;
	}

	public void setPlanoEscolhido(String planoEscolhido) {
		this.planoEscolhido = planoEscolhido;
	}
	
}
