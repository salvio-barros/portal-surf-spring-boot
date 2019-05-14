package com.portalsurf.api.dtos;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

public class SolicitacaoDTO {

	@NotEmpty(message="descrição não pode ser vazio")
	private String descricao;
		
	private Date dataSolicitacao;
	
	@NotEmpty(message="CPF não pode ser vazio")
	@CPF(message="CPF inválido")
	private Long cpfUsuario;
	
	@NotEmpty(message="Nome não pode ser vazio")
	@Length(min= 3, max = 20, message= "Razão social deve possuir entre 3 e 20 caracteres")
	private String nomeUsuario;
	

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

	public Long getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(Long cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	
}
