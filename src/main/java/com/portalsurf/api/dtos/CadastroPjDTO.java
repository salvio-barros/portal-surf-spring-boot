package com.portalsurf.api.dtos;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class CadastroPjDTO {

	@NotEmpty(message="Razão social não pode ser vazio")
	@Length(min= 3, max = 20, message= "Razão social deve possuir entre 3 e 20 caracteres")
	private String razaoSocial;

	@NotEmpty(message="CNPJ não pode ser vazio")
	@CNPJ(message="CNPJ inválido")
	private Long cnpj;
		
	private Date dataCriacao;
	
	@NotEmpty(message="CPF não pode ser vazio")
	@CPF(message="CPF inválido")
	private Long cpf;
	
	@NotEmpty(message="Nome não pode ser vazio")
	@Length(min= 3, max = 20, message= "Razão social deve possuir entre 3 e 20 caracteres")
	private String nome;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
