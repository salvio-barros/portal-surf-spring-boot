package com.portalsurf.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.portalsurf.api.enums.ExperienciaEnum;

@Entity
@Table(name= "solicitacao")
public class Solicitacao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idSolicitacao;
		
	private String descricao;
		
	private Date dataSolicitacao;
		
	private Funcionario funcionario;
		
	private ExperienciaEnum experiencia;
	
	public Solicitacao(){
		
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idSolicitacao", nullable = false)
	public Long getIdSolicitacao() {
		return idSolicitacao;
	}

	public void setIdSolicitacao(Long id) {
		this.idSolicitacao = id;
	}

	@Column(name= "nome_funcionario", nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Enumerated (EnumType.STRING)
	@Column(name= "cs_experiencia", nullable = false)
	public ExperienciaEnum getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(ExperienciaEnum experiencia) {
		this.experiencia = experiencia;
	}

	@Column(name= "dt_solicitacao", nullable = true)
	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	@ManyToOne (fetch = FetchType.EAGER)
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
