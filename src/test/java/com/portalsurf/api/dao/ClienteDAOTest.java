package com.portalsurf.api.dao;

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
import com.lacomania.api.entities.Cliente;
import com.lacomania.api.enums.PerfilEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClienteDAOTest {

	@Autowired
	private ClienteDAO funcionarioDAO;
		
	private static final Long CPF = 11L;
	
	@Before
	public void setUp(){
		this.funcionarioDAO.save(obterFuncionario());		
	}
	
	@After
	public void tearDown(){
		this.funcionarioDAO.deleteAll();
	}
	
	
	@Test
	public void findByCpfSucesso(){
		Long cpf = 11L;
		
		Cliente empresa = this.funcionarioDAO.findByCpf(cpf);
		Assert.assertEquals("Funcionário 1", empresa.getNome());
		
	}
	
	public Cliente obterFuncionario(){
			
		Cliente funcionario = new Cliente();
		funcionario.setIdCliente(1L);
		funcionario.setNome("Funcionário 1");
	 
		
		return funcionario;
		
	}
	
	
}
