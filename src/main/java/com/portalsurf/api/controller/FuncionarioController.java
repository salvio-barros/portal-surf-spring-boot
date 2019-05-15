package com.portalsurf.api.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portalsurf.api.constants.Constants;
import com.portalsurf.api.dtos.FuncionarioDTO;
import com.portalsurf.api.entities.Empresa;
import com.portalsurf.api.entities.Funcionario;
import com.portalsurf.api.response.Response;
import com.portalsurf.api.service.EmpresaService;
import com.portalsurf.api.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {


	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private FuncionarioService funcionarioService;

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Response<FuncionarioDTO>> salvar(@Valid @RequestBody FuncionarioDTO funcionarioDTO, BindingResult result ){
		Response<FuncionarioDTO> response = new Response<FuncionarioDTO>();
		
		Optional<Empresa> empresa = empresaService.buscarEmpresaPorCnpj(Constants.CNPJ_PORTAL_SURF);
			
		if(!empresa.isPresent()){
			response.getErrors().add("Empresa não existente");
		}
		
		Funcionario funcionario = gerarEntidadeFuncionario(funcionarioDTO);
		funcionario.setEmpresa(empresa.get());
		
		FuncionarioDTO dtoRetorno = gerarDTOFuncionario(funcionarioService.salvar(funcionario));
		response.setData(dtoRetorno);
		
		if(response.getErrors().isEmpty()){
			return ResponseEntity.ok(response);	
		} else{
			return ResponseEntity.badRequest().body(response);
		}
				
	}
	
	private Funcionario gerarEntidadeFuncionario(FuncionarioDTO funcionarioDTO){
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf(funcionarioDTO.getCpf());
		funcionario.setNomeFuncionario(funcionarioDTO.getNomeFuncionario());
		funcionario.setPerfil(funcionarioDTO.getPerfil());
		funcionario.setSolicitacoes(funcionarioDTO.getSolicitacoes());
		return funcionario;
	}


	private FuncionarioDTO gerarDTOFuncionario(Funcionario funcionario){
		
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		funcionarioDTO.setCpf(funcionario.getCpf());
		funcionarioDTO.setNomeFuncionario(funcionario.getNomeFuncionario());
		funcionarioDTO.setPerfil(funcionario.getPerfil());
		funcionarioDTO.setSolicitacoes(funcionario.getSolicitacoes());
		return funcionarioDTO;
	}
}
