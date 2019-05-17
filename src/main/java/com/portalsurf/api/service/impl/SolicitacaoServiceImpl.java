package com.portalsurf.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalsurf.api.dao.SolicitacaoDAO;
import com.portalsurf.api.entities.Funcionario;
import com.portalsurf.api.entities.Solicitacao;
import com.portalsurf.api.enums.FaseEnum;
import com.portalsurf.api.service.FuncionarioService;
import com.portalsurf.api.service.SolicitacaoService;

@Service
public class SolicitacaoServiceImpl implements SolicitacaoService {

	@Autowired
	private SolicitacaoDAO solicitacaoDAO;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Override
	public List<Solicitacao> obterSolicitacoesPorFuncionario(Long idFuncionario) {
		// TODO Auto-generated method stub
		return solicitacaoDAO.findSolicitacaoByFuncionarioId(idFuncionario);
	}

	@Override
	public Solicitacao criar(Solicitacao solicitacao) {
		
		solicitacao.setFase(FaseEnum.CONCEPCAO);
		solicitacao.setDataSolicitacao(new Date());
		return solicitacaoDAO.save(solicitacao);
	}

	@Override
	public Solicitacao atribuirSolicitacao(Long cpf, Long idSolicitacao) {
		// TODO Auto-generated method stub
		Funcionario funcionario = funcionarioService.buscarFuncionarioPorCpf(cpf).get();
		Solicitacao solicitacao = solicitacaoDAO.getOne(idSolicitacao);
			
		solicitacao.setFuncionario(funcionario);
		return solicitacaoDAO.save(solicitacao);	
	}

}
