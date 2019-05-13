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

import com.portalsurf.api.entities.Empresa;
import com.portalsurf.api.entities.Funcionario;
import com.portalsurf.api.enums.PerfilEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioDAOTest {

	@Autowired
	private FuncionarioDAO funcionarioDAO;
		
	
	private static final Long CNPJ = 1L;
	
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
		
		Funcionario empresa = this.funcionarioDAO.findByCpf(cpf);
		Assert.assertEquals(CPF, empresa.getCpf());
		
	}
	
	public Funcionario obterFuncionario(){
		Empresa empresa = new Empresa();
		empresa.setIdEmpresa(1L);
		empresa.setCnpj(CNPJ);
		empresa.setRazaoSocial("INT Surfboards");
		
		Funcionario funcionario = new Funcionario();
		funcionario.setIdFuncionario(1L);
		funcionario.setNomeFuncionario("Funcionário 1");
		funcionario.setPerfil(PerfilEnum.ROLE_SHAPER);
		funcionario.setCpf(CPF);
		//funcionario.setEmpresa(empresa);
		
		return funcionario;
		
	}
	
	
}
