package com.lacomania.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.lacomania.api.entities.Cliente;

@Transactional(readOnly = true)
public interface ClienteDAO extends JpaRepository<Cliente, Long> {
	
	Cliente findByCpf(Long cpf);
}
