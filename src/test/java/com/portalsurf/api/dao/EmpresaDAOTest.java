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

import com.portalsurf.api.dao.EmpresaDAO;
import com.portalsurf.api.entities.Empresa;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaDAOTest {

	@Autowired
	private EmpresaDAO empresaDAO;
		
	
	private static final Long CNPJ = 1L;
	
	@Before
	public void setUp(){
		this.empresaDAO.save(obterEmpresa());		
	}
	
	@After
	public void tearDown(){
		this.empresaDAO.deleteAll();
	}
	
	
	@Test
	public void findByCNPJSucesso(){
		Long cnpj = 1L;
		
		Empresa empresa = this.empresaDAO.findByCnpj(cnpj);
		Assert.assertEquals(CNPJ, empresa.getCnpj());
		
	}
	
	public Empresa obterEmpresa(){
		Empresa empresa = new Empresa();
		empresa.setIdEmpresa(1L);
		empresa.setCnpj(CNPJ);
		empresa.setRazaoSocial("INT Surfboards");
		
//		Funcionario funcionario = new Funcionario();
//		funcionario.setIdFuncionario(1L);
//		funcionario.setNome("Funcionário 1");
//		funcionario.setPerfil(PerfilEnum.ROLE_SHAPER);
//		funcionario.setCpf(11L);
//		funcionario.setEmpresa(empresa);
//		
//		List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
//		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
//		funcionario.setSolicitacoes(solicitacoes);
//		funcionarios.add(funcionario);
//			
//		
//		empresa.setFuncionarios(funcionarios);
		return empresa;
		
	}
}
