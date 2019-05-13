package com.portalsurf.api.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.portalsurf.api.entities.Empresa;


public interface EmpresaDAO extends JpaRepository<Empresa, Long> {
	
	@Transactional(readOnly = true)
	public Empresa findByCnpj(Long cnpj);

}
