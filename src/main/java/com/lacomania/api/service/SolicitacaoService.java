package com.lacomania.api.service;

import java.util.List;

import com.lacomania.api.entities.Cliente;
import com.lacomania.api.entities.Solicitacao;

public interface SolicitacaoService {

	public List<Solicitacao> obterSolicitacoesPorFuncionario(Long idFuncionario);
	
	public Solicitacao criar(Solicitacao solicitacao);
	
	public Solicitacao atribuirSolicitacao(Cliente funcionario, Long idSolicitacao);

	public Solicitacao atualizarStatusSolicitacao(Long id, Integer status);
	
	//public List<Solicitacao> obterSolicitacoesPorUsuario(Long cpfUsuario);
}
