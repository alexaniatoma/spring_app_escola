package com.alexania.app.escola.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;

@MappedSuperclass
public class Pessoa {
	
	@Column(nullable = false)
	@NotBlank(message = "O atributo nome é obrigatório")
	private String nome;
	
	@Column 
	private String foto;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	private String formacao;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@Column(name = "data_entrada")
	private Date dataEntrada;
	
	@Column(name = "data_saida")
	private Date dataSaida;

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}	
	
}
