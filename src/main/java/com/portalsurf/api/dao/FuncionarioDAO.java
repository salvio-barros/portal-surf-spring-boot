package com.portalsurf.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.portalsurf.api.entities.Funcionario;

@Transactional(readOnly = true)
public interface FuncionarioDAO extends JpaRepository<Funcionario, Long> {
	
	Funcionario findByCpf(Long cpf);
}
