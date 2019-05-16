package com.portalsurf.api.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portalsurf.api.dtos.EmpresaDTO;
import com.portalsurf.api.entities.Empresa;
import com.portalsurf.api.response.Response;
import com.portalsurf.api.service.EmpresaService;

/**
 * Controller de Empresa pra testar uso do Model Mapper
 * 
 * @author salvio.freire
 *
 */
@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private Validator validator;
	
	
	@PostMapping
	public ResponseEntity<Response<EmpresaDTO>> salvar(@RequestBody EmpresaDTO empresaDTO, BindingResult result) throws NoSuchAlgorithmException{
		Response<EmpresaDTO> response = new Response<EmpresaDTO>();
	
		Set<ConstraintViolation<EmpresaDTO>> constraintViolations = validator.validate(empresaDTO);
		
		if(!constraintViolations.isEmpty()){
			for (ConstraintViolation<EmpresaDTO> constraintViolation : constraintViolations) {
				response.getErrors().add(constraintViolation.getMessage());
			}
		}					
		ModelMapper modelMapper = new ModelMapper();
			
		Optional<Empresa> empresa = empresaService.buscarEmpresaPorCnpj(empresaDTO.getCnpj());
//				
		if(empresa.isPresent()){
			response.getErrors().add("Empresa existente");
		}


		if(response.getErrors().isEmpty()){
			Empresa empresaAPersistir = modelMapper.map(empresaDTO, Empresa.class);
			EmpresaDTO dtoRetorno = modelMapper.map(empresaService.salvar(empresaAPersistir), EmpresaDTO.class);
			response.setData(dtoRetorno);
			return ResponseEntity.ok(response);	
		} else{
			return ResponseEntity.badRequest().body(response);
		}

				
	}
}
