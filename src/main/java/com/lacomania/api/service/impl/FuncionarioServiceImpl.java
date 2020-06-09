package com.lacomania.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacomania.api.dao.ClienteDAO;
import com.lacomania.api.entities.Cliente;
import com.lacomania.api.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private ClienteDAO funcionarioDAO;
	
	@Override
	public Optional<Cliente> buscarFuncionarioPorCpf(Long cpf) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(funcionarioDAO.findByCpf(cpf));
	}

	@Override
	public Cliente salvar(Cliente funcionario) {
		// TODO Auto-generated method stub
		return this.funcionarioDAO.save(funcionario);
	}

}
