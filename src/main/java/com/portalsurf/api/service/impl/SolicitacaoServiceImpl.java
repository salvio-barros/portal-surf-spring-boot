package com.portalsurf.api.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalsurf.api.dao.SolicitacaoDAO;
import com.portalsurf.api.entities.Funcionario;
import com.portalsurf.api.entities.Solicitacao;
import com.portalsurf.api.enums.FaseEnum;
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
	public Solicitacao criar(Solicitacao solicitacao) {
		
		solicitacao.setFase(FaseEnum.CONCEPCAO);
		solicitacao.setDataSolicitacao(new Date());
		return solicitacaoDAO.save(solicitacao);
	}

	@Override
	public Solicitacao atribuirSolicitacao(Funcionario funcionario, Long idSolicitacao) {
		// TODO Auto-generated method stub
		Solicitacao solicitacao = solicitacaoDAO.getOne(idSolicitacao);
			
		solicitacao.setFuncionario(funcionario);
		return solicitacaoDAO.save(solicitacao);	
	}

	@Override
	public Solicitacao atualizarStatusSolicitacao(Long id, Integer status) {
		// TODO Auto-generated method stub
		
		Optional<Solicitacao> solicitacao = Optional.ofNullable(solicitacaoDAO.getOne(id));
//		
		if(solicitacao.isPresent()){
			
			FaseEnum faseSelecionada = FaseEnum.valorPorId(status);
			
			Date currentTime = new Date();
			
			if(faseSelecionada.equals(FaseEnum.FINALIZADO)){
				solicitacao.get().setDataFinalização(currentTime);
			} else{
				solicitacao.get().setDataUltimaAtualização(currentTime);
			}
			solicitacao.get().setFase(faseSelecionada);
			return solicitacaoDAO.save(solicitacao.get());
		} else{
			return null;
		}
	
	}

}
