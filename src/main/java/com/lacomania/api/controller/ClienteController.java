package com.lacomania.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lacomania.api.dtos.ClienteDTO;
import com.lacomania.api.entities.Cliente;
import com.lacomania.api.response.Response;
import com.lacomania.api.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
public class ClienteController {

	
	@Autowired
	private FuncionarioService funcionarioService;

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Response<ClienteDTO>> salvar(@Valid @RequestBody ClienteDTO funcionarioDTO, BindingResult result ){
		Response<ClienteDTO> response = new Response<ClienteDTO>();
				
		Cliente funcionario = gerarEntidadeFuncionario(funcionarioDTO);
				
		ClienteDTO dtoRetorno = gerarDTOFuncionario(funcionarioService.salvar(funcionario));
		response.setData(dtoRetorno);
		
		if(response.getErrors().isEmpty()){
			return ResponseEntity.ok(response);	
		} else{
			return ResponseEntity.badRequest().body(response);
		}
				
	}
	
	private Cliente gerarEntidadeFuncionario(ClienteDTO funcionarioDTO){
		
		Cliente funcionario = new Cliente();
		funcionario.setNome(funcionarioDTO.getNome());
		funcionario.setSolicitacoes(funcionarioDTO.getSolicitacoes());
		return funcionario;
	}


	private ClienteDTO gerarDTOFuncionario(Cliente cliente){
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setSolicitacoes(cliente.getSolicitacoes());
		return clienteDTO;
	}
}
