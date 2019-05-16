package com.portalsurf.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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

import com.portalsurf.api.enums.ExperienciaEnum;

@Entity
@Table(name= "surfista")
public class Surfista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idSurfista", nullable = false)
	private Long idSurfista;
	
	@Column(name= "nome", nullable = false)
	private String nome;
	
	@Column(name= "email", nullable = false)
	private String email;
	
	@Column(name= "telefone", nullable = false)
	private Long telefone;
	
	@Column(name="peso", nullable = false)
	private BigDecimal peso;
	
	@Column(name="peso", nullable = false)
	private BigDecimal altura;
	
	@Column(name= "experiencia", nullable = false)
	private ExperienciaEnum experiencia;
	
	@OneToMany(mappedBy="surfista", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Solicitacao> solicitacoes;

	public Long getIdSurfista() {
		return idSurfista;
	}

	public void setIdSurfista(Long idSurfista) {
		this.idSurfista = idSurfista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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

	public ExperienciaEnum getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(ExperienciaEnum experiencia) {
		this.experiencia = experiencia;
	}

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
