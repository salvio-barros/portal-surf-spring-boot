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

import com.lacomania.api.dao.ClienteDAO;
import com.lacomania.api.dao.SolicitacaoDAO;
import com.lacomania.api.entities.Cliente;
import com.lacomania.api.entities.Solicitacao;
import com.lacomania.api.enums.FaseEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SolicitacaoDAOTest {

	@Autowired 
	private SolicitacaoDAO solicitacaoDao;
	
	@Autowired
	private ClienteDAO funcionarioDAO;
		
	@Before
	public void setup(){
		Cliente fun = funcionarioDAO.save(preencherFuncionarios());
		solicitacaoDao.save(preencherSolicitacoesFuncionarios(fun));
	}
	
	private Cliente preencherFuncionarios() {
		// TODO Auto-generated method stub
		Cliente funcionario2 = new Cliente();
		funcionario2.setIdCliente(1L);
		funcionario2.setNome("Funcionário 1");
	  
		return funcionario2;
	}

	@After
	public void tearDown(){
		this.solicitacaoDao.deleteAll();
		this.funcionarioDAO.deleteAll();
	}
	
	
	@Test
	public void findSolicitacaoPorFuncionarioSucesso(){
	
		List<Solicitacao> listaUm = solicitacaoDao.findSolicitacaoByclienteId(1L);
		Assert.assertTrue(!listaUm.isEmpty());
		Assert.assertEquals(2, listaUm.size());
		
		
	}

	private List<Solicitacao> preencherSolicitacoesFuncionarios(Cliente funcionario) {
		// TODO Auto-generated method stub
		Solicitacao solic1 = new Solicitacao();
		solic1.setIdSolicitacao(1L);
		solic1.setDescricao("Prancha iniciante");
		solic1.setDataSolicitacao(new Date());
		solic1.setCliente(funcionario);
		solic1.setFase(FaseEnum.CONCEPCAO);
		
		Solicitacao solic2 = new Solicitacao();
		solic2.setIdSolicitacao(2L);
		solic2.setDescricao("Prancha intermediária");
		solic2.setDataSolicitacao(new Date());
		solic2.setCliente(funcionario);
		solic2.setFase(FaseEnum.CONCEPCAO);
		
		Solicitacao solic3 = new Solicitacao();
		solic3.setIdSolicitacao(3L);
		solic3.setDescricao("Prancha avançada");
		solic3.setDataSolicitacao(new Date());
		solic3.setCliente(funcionario);
		solic3.setFase(FaseEnum.CONCEPCAO);
	
		
		List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
		solicitacoes.add(solic1);
		solicitacoes.add(solic2);
					
		return solicitacoes;
	}
}
