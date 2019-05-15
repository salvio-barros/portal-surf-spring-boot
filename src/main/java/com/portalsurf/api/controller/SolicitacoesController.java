package com.portalsurf.api.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portalsurf.api.dtos.SolicitacaoDTO;
import com.portalsurf.api.entities.Solicitacao;
import com.portalsurf.api.enums.FaseEnum;
import com.portalsurf.api.response.Response;
import com.portalsurf.api.service.SolicitacaoService;

@RestController
@RequestMapping("/api/pedidos")
public class SolicitacoesController {

	@Autowired
	private SolicitacaoService solicitacaoService;
	
	public SolicitacoesController(){
		
	}
	
	@PostMapping
	public ResponseEntity<Response<SolicitacaoDTO>> cadastrar (@Valid @RequestBody SolicitacaoDTO solicitacaoDTO,
			BindingResult result) throws NoSuchAlgorithmException{
		
		Response<SolicitacaoDTO> response = new Response<SolicitacaoDTO>();
		Solicitacao solicitacao = gerarEntidadeSolicitacaoParaSalvar(solicitacaoDTO);
		
		this.solicitacaoService.persistir(solicitacao);
		response.setData(gerarSolicitacaoDTO(solicitacao));
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(value= "{cpf}/{id}")
	public ResponseEntity<Response<SolicitacaoDTO>> atribuirSolicitacao(@PathVariable("cpf") Long cpf, @PathVariable("id") Long id, BindingResult result ){
		Response<SolicitacaoDTO> response = new Response<SolicitacaoDTO>();
		
		Solicitacao solicitacao = solicitacaoService.atribuirSolicitacao(cpf, id);
		
		response.setData(gerarSolicitacaoDTO(solicitacao));
		
		return ResponseEntity.ok(response);
		
	}
	
	private Solicitacao gerarEntidadeSolicitacaoParaSalvar(SolicitacaoDTO solicitacaoDTO){
		
		Solicitacao solicitacao = new Solicitacao();
		solicitacao.setDescricao(solicitacaoDTO.getDescricao());
		solicitacao.setDataSolicitacao(new Date());
		solicitacao.setFase(FaseEnum.CONCEPCAO);	
		return solicitacao;
		
	}
	
	private SolicitacaoDTO gerarSolicitacaoDTO(Solicitacao solicitacao){
		
		SolicitacaoDTO solicitacaoDTO = new SolicitacaoDTO();
		solicitacaoDTO.setDescricao(solicitacao.getDescricao());
		solicitacaoDTO.setDataSolicitacao(solicitacao.getDataSolicitacao());
		return solicitacaoDTO;
		
	}

}
