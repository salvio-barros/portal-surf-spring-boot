package com.lacomania.api.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;
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

import com.lacomania.api.dtos.SolicitacaoDTO;
import com.lacomania.api.entities.Cliente;
import com.lacomania.api.entities.Solicitacao;
import com.lacomania.api.enums.FaseEnum;
import com.lacomania.api.exception.FalhaEmailException;
import com.lacomania.api.response.Response;
import com.lacomania.api.service.FuncionarioService;
import com.lacomania.api.service.SolicitacaoService;
import com.lacomania.api.utils.DateUtils;
import com.lacomania.api.utils.EmailUtils;

@RestController
@RequestMapping("/api/pedidos")
public class SolicitacoesController {

	@Autowired
	private SolicitacaoService solicitacaoService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
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
		
		String msg = gerarConteudoEmail(dtoRetorno);
		
		//mailSender.send(EmailUtils.gerarEmailParaEnvio(msg, dtoRetorno.getEmail()));
		mailSender.send(EmailUtils.gerarEmailMimeMessage(mailSender,msg, dtoRetorno.getEmail()));
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(value= "{cpf}/{id}")
	public ResponseEntity<Response<SolicitacaoDTO>> atribuirSolicitacao(@PathVariable("cpf") Long cpf, @PathVariable("id") Long id, BindingResult result ){
		Response<SolicitacaoDTO> response = new Response<SolicitacaoDTO>();
		
		Optional<Cliente> funcionario = funcionarioService.buscarFuncionarioPorCpf(cpf);
		
		if(!funcionario.isPresent()){
			response.getErrors().add("Funcionário não encontrado");
		}
		
		if(response.getErrors().isEmpty()){
			Solicitacao solicitacao = solicitacaoService.atribuirSolicitacao(funcionario.get(), id);
			response.setData(gerarSolicitacaoDTO(solicitacao));
			return ResponseEntity.ok(response);
		} else{
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@PutMapping(value= "{id}/{status}")
	public ResponseEntity<Response<SolicitacaoDTO>> atualizarStatusSolicitacao(@PathVariable("id") Long id, @PathVariable("status") Integer status, BindingResult result){
		Response<SolicitacaoDTO> response = new Response<SolicitacaoDTO>();
		
		Optional<Solicitacao> solicitacao = Optional.ofNullable(solicitacaoService.atualizarStatusSolicitacao(id,status));
		
		if(!solicitacao.isPresent()){
			response.getErrors().add("Solicitação não encontrada para atualização");
			return ResponseEntity.badRequest().body(response);
		} else{
			
			SolicitacaoDTO dtoRetorno = gerarSolicitacaoDTO(solicitacao.get());
						
			String msg = gerarConteudoEmail(dtoRetorno);
						
			mailSender.send(EmailUtils.gerarEmailMimeMessage(mailSender,msg, dtoRetorno.getEmail()));
			
			return ResponseEntity.ok(response);
		}
	}
	
	
		
	private String gerarConteudoEmail(SolicitacaoDTO dto) {
		// TODO Auto-generated method stub
		FaseEnum fase = FaseEnum.valorPorId(dto.getFase());
		String emailMsg = "";
		if(fase.equals(FaseEnum.CONCEPCAO)){
			emailMsg ="Olá " + dto.getNome()+ ".\n" + "Sua solicitação foi registrada em " + 
					DateUtils.format(dto.getDataSolicitacao(), DateUtils.CST_STRING_DD_MM_YYYY_HH_MM_SS);
		} else if(fase.equals(FaseEnum.FINALIZADO)){
			emailMsg = "Olá " + dto.getNome()+ ".\n" + "Sua solicitação foi finalizada em: " + DateUtils.format(dto.getDataFinalização()
					, DateUtils.CST_STRING_DD_MM_YYYY_HH_MM_SS);
		} else{
			emailMsg = "Olá " + dto.getNome()+ ".\n" + "Sua solicitação encontra-se em estado "+ fase.getDescricao() +
					" em: " + DateUtils.format(dto.getDataUltimaAtualização()
					, DateUtils.CST_STRING_DD_MM_YYYY_HH_MM_SS);
		}
		
		return emailMsg;
	}

	private SolicitacaoDTO gerarSolicitacaoDTO(Solicitacao solicitacao){
		
		SolicitacaoDTO solicitacaoDTO = new SolicitacaoDTO();
		solicitacaoDTO.setDescricao(solicitacao.getDescricao());
		solicitacaoDTO.setDataSolicitacao(solicitacao.getDataSolicitacao());
		return solicitacaoDTO;
		
	}
	

}
