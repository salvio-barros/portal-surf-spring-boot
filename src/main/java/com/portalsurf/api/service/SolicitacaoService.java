package com.portalsurf.api.service;

import java.util.List;

import com.portalsurf.api.entities.Funcionario;
import com.portalsurf.api.entities.Solicitacao;

public interface SolicitacaoService {

	public List<Solicitacao> obterSolicitacoesPorFuncionario(Long idFuncionario);
	
	public Solicitacao criar(Solicitacao solicitacao);
	
	public Solicitacao atribuirSolicitacao(Funcionario funcionario, Long idSolicitacao);

	public Solicitacao atualizarStatusSolicitacao(Long id, Integer status);
	
	//public List<Solicitacao> obterSolicitacoesPorUsuario(Long cpfUsuario);
}
