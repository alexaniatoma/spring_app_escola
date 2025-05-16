package com.alexania.app.escola.model;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;

@MappedSuperclass
public class Pessoa {
	
	@Column(nullable = false)
	@NotBlank(message = "O atributo nome é obrigatório")
	private String nome;
	
	@Column(nullable = true)
	private String foto;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	private String formacao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_entrada")
	private LocalDate dataEntrada;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_saida", nullable = true)
	private LocalDate dataSaida;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}	
	
}
