package com.lacomania.api.service;

import java.util.Optional;

import com.lacomania.api.entities.Cliente;

public interface FuncionarioService {

	public Optional<Cliente> buscarFuncionarioPorCpf(Long cpf);
	
	public Cliente salvar(Cliente funcionario);
}
