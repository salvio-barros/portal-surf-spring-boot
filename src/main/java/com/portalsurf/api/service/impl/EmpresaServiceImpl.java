package com.portalsurf.api.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalsurf.api.dao.EmpresaDAO;
import com.portalsurf.api.entities.Empresa;
import com.portalsurf.api.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{

	@Autowired
	private EmpresaDAO empresaDao;
	
	@Override
	public Optional<Empresa> buscarEmpresaPorCnpj(Long cnpj) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(empresaDao.findByCnpj(cnpj));
	}

	@Override
	public Empresa salvar(Empresa emp) {
		// TODO Auto-generated method stub
		emp.setDataCriacao(new Date());
		return empresaDao.save(emp);
	}

}
