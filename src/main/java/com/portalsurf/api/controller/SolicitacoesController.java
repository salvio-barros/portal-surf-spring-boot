package com.portalsurf.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portalsurf.api.service.SolicitacaoService;

@RestController
@RequestMapping("/api/cadastro-pedidos")
public class SolicitacoesController {

	@Autowired
	private SolicitacaoService solicitacaoService;
	
	public SolicitacoesController(){
		
	}
	
//	@PostMapping
//	public 
}
