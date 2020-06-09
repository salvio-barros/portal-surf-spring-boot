package com.lacomania.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "cliente")
@Data
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idCliente", nullable = false)
	private Long idCliente;

	@Column(name= "nome", nullable = false)
	private String nome;
	
	@Column(name= "cpf", nullable = false)
	private Long cpf;
	
	@Column(name= "telefone", nullable = false)
	private Long telefone;
	
	@Getter @Setter
	@Column(name="email", nullable = false)
	private String email;
	
	@OneToMany(mappedBy="cliente", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Solicitacao> solicitacoes;
	
	public Cliente(){
		
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

	
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long id) {
		this.idCliente = id;
	}

	
	
	
	
}
