package com.portalsurf.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import com.portalsurf.api.enums.FaseEnum;

@Entity
@Table(name= "solicitacao")
public class Solicitacao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idSolicitacao;
	
	@Column(name= "nome", nullable = false)
	private String nome;
	
	@Column(name= "cpf", nullable = false)
	private String cpf;
	
	@Column(name= "email", nullable = true)
	private String email;
	
	@Column(name= "telefone", nullable = false)
	private Long telefone;
	
	@Column(name="peso", nullable = false)
	private BigDecimal peso;
	
	@Column(name="altura", nullable = false)
	private BigDecimal altura;
	
	@Column(name= "experiencia", nullable = false)
	private ExperienciaEnum experiencia;
	
	@Column(name= "descricao", nullable = false)
	private String descricao;
	
	@Column(name= "data_solicitacao", nullable = true)
	private Date dataSolicitacao;
	
	@Column(name= "data_ultima_atualizacao", nullable = true)
	private Date dataUltimaAtualização;
	
	@Column(name= "data_finalizacao", nullable = true)
	private Date dataFinalização;
		
	private Funcionario funcionario;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "cs_fase", nullable = false)
	private FaseEnum fase;
		
	public Solicitacao(){
		
	}

	public FaseEnum getFase() {
		return fase;
	}


	public void setFase(FaseEnum fase) {
		this.fase = fase;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public ExperienciaEnum getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(ExperienciaEnum experiencia) {
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

		
	
}
