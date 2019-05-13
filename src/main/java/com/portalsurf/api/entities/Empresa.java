package com.portalsurf.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "empresa")
public class Empresa implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Long idEmpresa;
	
	
	private String razaoSocial;
	
	
	private Long cnpj;
	
	
	private Date dataCriacao;
	
	
	private Date dataAtualizacao;
	
	
	private List<Funcionario> funcionarios;
	
	
	public Empresa(){
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdEmpresa() {
		return idEmpresa;
	}

	@Column(name="idEmpresa", nullable = false)
	public void setIdEmpresa(Long id) {
		this.idEmpresa = id;
	}

	@Column(name= "razao_social", nullable = false)
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	@Column(name= "dt_criacao", nullable = true)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Column(name= "dt_atualizacao", nullable = true)
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@OneToMany(mappedBy="empresa", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Column(name= "cnpj", nullable = false)
	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	
	
	
}
