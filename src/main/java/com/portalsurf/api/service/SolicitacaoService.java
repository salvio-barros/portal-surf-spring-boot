package com.portalsurf.api.service;

import java.util.List;

import com.portalsurf.api.entities.Solicitacao;

public interface SolicitacaoService {

	public List<Solicitacao> obterSolicitacoesPorFuncionario(Long idFuncionario);
	
	public Solicitacao persistir(Solicitacao solicitacao);
	
	public Solicitacao atribuirSolicitacao(Long cpf, Long idSolicitacao);
	
	//public List<Solicitacao> obterSolicitacoesPorUsuario(Long cpfUsuario);
}
