package com.portalsurf.api.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.portalsurf.api.enums.PerfilEnum;

@Entity
@Table(name= "funcionario")
public class Funcionario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long idFuncionario;

	private String nomeFuncionario;
	
	private Long cpf;
	
	private PerfilEnum perfil;
	
	private List<Solicitacao> solicitacoes;
	
	private Empresa empresa;
	
	public Funcionario(){
		
	}

	@OneToMany(mappedBy="funcionario", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	@ManyToOne
	@JoinColumn(name="idEmpresa")
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idFuncionario", nullable = false)
	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long id) {
		this.idFuncionario = id;
	}

	@Column(name= "nomeFuncionario", nullable = false)
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nome) {
		this.nomeFuncionario = nome;
	}

	@Column(name= "perfil", nullable = false)
	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	@Column(name= "cpf", nullable = false)
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	
	
	
}
