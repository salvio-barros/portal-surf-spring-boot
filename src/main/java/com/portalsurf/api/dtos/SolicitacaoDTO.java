package com.portalsurf.api.dtos;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import com.portalsurf.api.enums.ExperienciaEnum;

public class SolicitacaoDTO {

	@NotNull(message="descrição não pode ser vazio")
	private String descricao;
		
	private Date dataSolicitacao;
	
	@NotNull(message="CPF não pode ser vazio")
	private Long cpf;
	
	@NotNull(message="Nome não pode ser vazio")
	@Size(min= 3, max = 20, message= "Nome deve possuir entre 3 e 20 caracteres")
	private String nome;
	
	@Email(message="Email inválido")
	private String email;
	
	@NotNull(message="Telefone não pode ser vazio")
	private Long telefone;
	
	@NotNull(message="Peso não pode ser vazio")
	private BigDecimal peso;
	
	@NotNull(message="Altura não pode ser vazio")
	private BigDecimal altura;
	
	@NotNull(message="Experiência não pode ser vazio")
	private Integer experiencia;
	
	private Integer fase;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public Integer getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Integer experiencia) {
		this.experiencia = experiencia;
	}

	public Date getDataUltimaAtualização() {
		return dataUltimaAtualização;
	}

	public void setDataUltimaAtualização(Date dataUltimaAtualização) {
		this.dataUltimaAtualização = dataUltimaAtualização;
	}

	public Date getDataFinalização() {
		return dataFinalização;
	}

	public void setDataFinalização(Date dataFinalização) {
		this.dataFinalização = dataFinalização;
	}

	private Date dataUltimaAtualização;
	
	private Date dataFinalização;
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
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
