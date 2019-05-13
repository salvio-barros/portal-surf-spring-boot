package com.portalsurf.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalsurf.api.dao.SolicitacaoDAO;
import com.portalsurf.api.entities.Solicitacao;
import com.portalsurf.api.service.SolicitacaoService;

@Service
public class SolicitacaoServiceImpl implements SolicitacaoService {

	@Autowired
	private SolicitacaoDAO solicitacaoDAO;
	
	@Override
	public List<Solicitacao> obterSolicitacoesPorFuncionario(Long idFuncionario) {
		// TODO Auto-generated method stub
		return solicitacaoDAO.findSolicitacaoByFuncionarioId(idFuncionario);
	}

	@Override
	public Solicitacao persistir(Solicitacao solicitacao) {
		// TODO Auto-generated method stub
		return solicitacaoDAO.save(solicitacao);
	}

}
