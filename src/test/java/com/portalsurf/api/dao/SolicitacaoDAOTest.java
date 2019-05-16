package com.portalsurf.api.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
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
import com.portalsurf.api.enums.FaseEnum;
import com.portalsurf.api.enums.PerfilEnum;
import com.portalsurf.api.service.FuncionarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SolicitacaoDAOTest {

	@Autowired 
	private SolicitacaoDAO solicitacaoDao;
	
	@Autowired
	private FuncionarioDAO funcionarioDAO;
		
	@Before
	public void setup(){
		Funcionario fun = funcionarioDAO.save(preencherFuncionarios());
		solicitacaoDao.save(preencherSolicitacoesFuncionarios(fun));
	}
	
	private Funcionario preencherFuncionarios() {
		// TODO Auto-generated method stub
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setIdFuncionario(1L);
		funcionario2.setNomeFuncionario("Funcionário 1");
		funcionario2.setPerfil(PerfilEnum.ROLE_SHAPER);
		funcionario2.setCpf(11L);
		
		return funcionario2;
	}

	@After
	public void tearDown(){
		this.solicitacaoDao.deleteAll();
		this.funcionarioDAO.deleteAll();
	}
	
	
	@Test
	public void findSolicitacaoPorFuncionarioSucesso(){
	
		List<Solicitacao> listaUm = solicitacaoDao.findSolicitacaoByFuncionarioId(1L);
		Funcionario funcionario = funcionarioDAO.findByCpf(11L);
		Assert.assertNotNull(funcionario);
		Assert.assertTrue(!listaUm.isEmpty());
		Assert.assertEquals(2, listaUm.size());
		
		
	}

	private List<Solicitacao> preencherSolicitacoesFuncionarios(Funcionario funcionario) {
		// TODO Auto-generated method stub
		Solicitacao solic1 = new Solicitacao();
		solic1.setIdSolicitacao(1L);
		solic1.setDescricao("Prancha iniciante");
		solic1.setDataSolicitacao(new Date());
		solic1.setFuncionario(funcionario);
		solic1.setFase(FaseEnum.CONCEPCAO);
		
		Solicitacao solic2 = new Solicitacao();
		solic2.setIdSolicitacao(2L);
		solic2.setDescricao("Prancha intermediária");
		solic2.setDataSolicitacao(new Date());
		solic2.setFuncionario(funcionario);
		solic2.setFase(FaseEnum.CONCEPCAO);
		
		Solicitacao solic3 = new Solicitacao();
		solic3.setIdSolicitacao(3L);
		solic3.setDescricao("Prancha avançada");
		solic3.setDataSolicitacao(new Date());
		solic3.setFuncionario(funcionario);
		solic3.setFase(FaseEnum.CONCEPCAO);
	
		
		List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
		solicitacoes.add(solic1);
		solicitacoes.add(solic2);
					
		return solicitacoes;
	}
}
