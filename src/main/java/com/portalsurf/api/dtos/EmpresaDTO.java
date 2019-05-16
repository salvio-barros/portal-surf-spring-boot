package com.portalsurf.api.dtos;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class EmpresaDTO {


	@NotNull(message="Razão social não pode ser vazio")
	@Size(min= 3, max = 20, message= "Razão social deve possuir entre 3 e 20 caracteres")
	private String razaoSocial;
	

	@NotNull(message="CNPJ não pode ser vazio")
	@Min(value=1, message = "CNPJ deve possuir entre 1 e 14 caracteres")
	@Max(value = 14, message= "CNPJ deve possuir entre 1 e 14 caracteres")
	private Long cnpj;
		
	private Date dataCriacao;
	

	@NotNull(message="Nome não pode ser vazio")
	@Size(min= 3, max = 20, message= "Nome deve possuir entre 3 e 20 caracteres")
	private String nome;

	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	
	
	
}
