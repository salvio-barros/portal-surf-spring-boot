package com.portalsurf.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalsurf.api.dao.FuncionarioDAO;
import com.portalsurf.api.entities.Funcionario;
import com.portalsurf.api.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioDAO funcionarioDAO;
	
	@Override
	public Optional<Funcionario> buscarFuncionarioPorCpf(Long cpf) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(funcionarioDAO.findByCpf(cpf));
	}

	@Override
	public Funcionario salvar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		return this.funcionarioDAO.save(funcionario);
	}

}
