package com.portalsurf.api.service;

import java.util.Optional;

import com.portalsurf.api.entities.Funcionario;

public interface FuncionarioService {

	public Optional<Funcionario> buscarFuncionarioPorCpf(Long cpf);
	
	public Funcionario salvar(Funcionario funcionario);
}
