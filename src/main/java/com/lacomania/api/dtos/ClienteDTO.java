package com.lacomania.api.dtos;


import java.util.List;

import com.lacomania.api.entities.Solicitacao;
import com.lacomania.api.enums.PerfilEnum;

import lombok.Data;

@Data
public class ClienteDTO {

	private String nome;
	
	private Long cpf;
	
	private PerfilEnum perfil;
	
	private List<Solicitacao> solicitacoes;
	
}
