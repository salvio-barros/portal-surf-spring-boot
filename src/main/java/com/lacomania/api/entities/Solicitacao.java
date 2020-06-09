package com.lacomania.api.entities;

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

import com.lacomania.api.enums.FaseEnum;

@Entity
@Table(name= "solicitacao")
public class Solicitacao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idSolicitacao;
			
	@Column(name= "descricao", nullable = false)
	private String descricao;
	
	@Column(name= "data_solicitacao", nullable = true)
	private Date dataSolicitacao;
	
	@Column(name= "data_ultima_atualizacao", nullable = true)
	private Date dataUltimaAtualização;
	
	@Column(name= "data_finalizacao", nullable = true)
	private Date dataFinalização;
		
	private Cliente cliente;

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

	@Column(name= "descricao", nullable = false)
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
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
