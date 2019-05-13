package com.portalsurf.api.service;

import java.util.Optional;

import com.portalsurf.api.entities.Empresa;

public interface EmpresaService {

	public Optional<Empresa> buscarEmpresaPorCnpj(Long cnpj);
	
	public Empresa salvar(Empresa emp);
}
