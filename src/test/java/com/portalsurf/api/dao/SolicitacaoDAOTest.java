package com.portalsurf.api.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.portalsurf.api.entities.Funcionario;
import com.portalsurf.api.entities.Solicitacao;
import com.portalsurf.api.enums.ExperienciaEnum;
import com.portalsurf.api.enums.PerfilEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SolicitacaoDAOTest {

	@Autowired 
	private SolicitacaoDAO solicitacaoDao;
	
	@Before
	public void setup(){
		solicitacaoDao.save(obterSolicitacoes());
	}
	
	@Test
	public void findSolicitacaoSucesso(){
		
		
	}

	private List<Solicitacao> obterSolicitacoes() {
		// TODO Auto-generated method stub
		Solicitacao solic1 = new Solicitacao();
		solic1.setIdSolicitacao(1L);
		solic1.setExperiencia(ExperienciaEnum.UM_A_CINCO_ANOS);
		solic1.setDescricao("Prancha iniciante");
		solic1.setDataSolicitacao(new Date());
		
		Solicitacao solic2 = new Solicitacao();
		solic2.setIdSolicitacao(2L);
		solic2.setExperiencia(ExperienciaEnum.CINCO_A_DEZ_ANOS);
		solic2.setDescricao("Prancha intermediária");
		solic2.setDataSolicitacao(new Date());
		
		Solicitacao solic3 = new Solicitacao();
		solic3.setIdSolicitacao(3L);
		solic3.setExperiencia(ExperienciaEnum.ACIMA_DEZ_ANOS);
		solic3.setDescricao("Prancha avançada");
		solic3.setDataSolicitacao(new Date());
		
		Funcionario funcionario = new Funcionario();
		funcionario.setIdFuncionario(1L);
		funcionario.setNomeFuncionario("Funcionário 1");
		funcionario.setPerfil(PerfilEnum.ROLE_SHAPER);
		funcionario.setCpf(11L);
		
		List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
		solicitacoes.add(solic1);
		solicitacoes.add(solic2);
		funcionario.setSolicitacoes(solicitacoes); 
		
		
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setIdFuncionario(2L);
		funcionario2.setNomeFuncionario("Funcionário 2");
		funcionario2.setPerfil(PerfilEnum.ROLE_SHAPER);
		funcionario2.setCpf(12L);
		
		List<Solicitacao> solicitacoes2 = new ArrayList<Solicitacao>();
		solicitacoes2.add(solic3);
		funcionario.setSolicitacoes(solicitacoes2); 
		
		return null;
	}
}
