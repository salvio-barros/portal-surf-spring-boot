package com.portalsurf.api.service.impl;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.portalsurf.api.dao.EmpresaDAO;
import com.portalsurf.api.entities.Empresa;
import com.portalsurf.api.service.EmpresaService;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaServiceImplTest {

	@Autowired
	private EmpresaService empresaService;
	
	@MockBean
	private EmpresaDAO empresaDAO;


	private static final Long CNPJ = 1L;

	@Before
	public void setUp(){
		BDDMockito.given(empresaDAO.findByCnpj(CNPJ)).willReturn(obterEmpresa());
		BDDMockito.given(empresaDAO.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
	}
	
	@Test
	public void buscarEmpresaPorCnpj(){
		Optional<Empresa> empresaRetorno = empresaService.buscarEmpresaPorCnpj(1L);
		Assert.assertTrue(empresaRetorno.isPresent());
		Assert.assertEquals(CNPJ,empresaRetorno.get().getCnpj());
		
	}
	
	@Test
	public void salvarEmpresaSucesso(){
		
		empresaService.salvar(obterEmpresa());
		Optional<Empresa> empresaRetorno = empresaService.buscarEmpresaPorCnpj(1L);
		Assert.assertTrue(empresaRetorno.isPresent());
		Assert.assertEquals(CNPJ,empresaRetorno.get().getCnpj());
		
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
