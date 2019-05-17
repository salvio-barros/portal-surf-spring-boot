package com.portalsurf.api.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portalsurf.api.dtos.SolicitacaoDTO;
import com.portalsurf.api.entities.Solicitacao;
import com.portalsurf.api.exception.FalhaEmailException;
import com.portalsurf.api.response.Response;
import com.portalsurf.api.service.SolicitacaoService;
import com.portalsurf.api.utils.DateUtils;
import com.portalsurf.api.utils.EmailUtils;

@RestController
@RequestMapping("/api/pedidos")
public class SolicitacoesController {

	@Autowired
	private SolicitacaoService solicitacaoService;
	
	@Autowired
	private Validator validator;
	
	
	 @Autowired
	 private JavaMailSender mailSender;
	

	
	public SolicitacoesController(){
		
	}
	
	@PostMapping
	public ResponseEntity<Response<SolicitacaoDTO>> cadastrar (@RequestBody SolicitacaoDTO solicitacaoDTO,
			BindingResult result) throws NoSuchAlgorithmException, MailException, FalhaEmailException{
		

		Response<SolicitacaoDTO> response = new Response<SolicitacaoDTO>();
		
		Set<ConstraintViolation<SolicitacaoDTO>> constraintViolations = validator.validate(solicitacaoDTO);
		
		if(!constraintViolations.isEmpty()){
			for (ConstraintViolation<SolicitacaoDTO> constraintViolation : constraintViolations) {
				response.getErrors().add(constraintViolation.getMessage());
			}
		}				
		
		if(!response.getErrors().isEmpty()){
			return ResponseEntity.badRequest().body(response);
		}
		ModelMapper modelMapper = new ModelMapper();
		
		Solicitacao solicitacao = modelMapper.map(solicitacaoDTO,Solicitacao.class);
		
		SolicitacaoDTO dtoRetorno = modelMapper.map(this.solicitacaoService.criar(solicitacao), SolicitacaoDTO.class);
	
		response.setData(dtoRetorno);
		
		String emailMsg="Olá " + dtoRetorno.getNome()+ ".\n" + "Sua solicitação de número foi registrada em " + 
		DateUtils.format(dtoRetorno.getDataSolicitacao(), DateUtils.CST_STRING_DD_MM_YYYY_HH_MM_SS);
		
		mailSender.send(EmailUtils.gerarEmailParaEnvio(emailMsg, dtoRetorno.getEmail()));
		mailSender.send(EmailUtils.gerarEmailMimeMessage(mailSender,emailMsg, dtoRetorno.getEmail()));
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(value= "{cpf}/{id}")
	public ResponseEntity<Response<SolicitacaoDTO>> atribuirSolicitacao(@PathVariable("cpf") Long cpf, @PathVariable("id") Long id, BindingResult result ){
		Response<SolicitacaoDTO> response = new Response<SolicitacaoDTO>();
		
		Solicitacao solicitacao = solicitacaoService.atribuirSolicitacao(cpf, id);
		
		response.setData(gerarSolicitacaoDTO(solicitacao));
		
		return ResponseEntity.ok(response);
		
	}
		
	private SolicitacaoDTO gerarSolicitacaoDTO(Solicitacao solicitacao){
		
		SolicitacaoDTO solicitacaoDTO = new SolicitacaoDTO();
		solicitacaoDTO.setDescricao(solicitacao.getDescricao());
		solicitacaoDTO.setDataSolicitacao(solicitacao.getDataSolicitacao());
		return solicitacaoDTO;
		
	}
	

}
