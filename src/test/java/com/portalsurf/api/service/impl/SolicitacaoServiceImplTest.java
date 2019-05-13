package com.portalsurf.api.service.impl;

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

import com.portalsurf.api.dao.SolicitacaoDAO;
import com.portalsurf.api.entities.Solicitacao;
import com.portalsurf.api.service.SolicitacaoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SolicitacaoServiceImplTest {

	@MockBean
	private SolicitacaoDAO solicitacaoDAO;
	
	@Autowired
	private SolicitacaoService solicitacaoService;
	
	@Before
	public void setup(){
		BDDMockito.given(solicitacaoDAO.save(Mockito.any(Solicitacao.class))).willReturn(new Solicitacao());
	}
	
	@Test
	public void testPersistirSolicitacaoSucesso(){
		//solicitacaoService.persistir(new Solicitacao());
	}
}
