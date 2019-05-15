package com.portalsurf.api.dtos;


import java.util.ArrayList;
import java.util.List;

import com.portalsurf.api.entities.Empresa;	
import com.portalsurf.api.entities.Solicitacao;
import com.portalsurf.api.enums.PerfilEnum;

public class FuncionarioDTO {

	private String nomeFuncionario;
	
	private Long cpf;
	
	private PerfilEnum perfil;
	
	private List<Solicitacao> solicitacoes;
	
	private Empresa empresa;
	
		
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	public List<Solicitacao> getSolicitacoes() {
		if(solicitacoes == null){
			solicitacoes = new ArrayList<Solicitacao>();
		}
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}


	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
