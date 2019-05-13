package com.portalsurf.api.dao;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.portalsurf.api.entities.Solicitacao;

@Transactional(readOnly = true)

@NamedQueries({
	@NamedQuery(name= "SolicitacaoDAO.findSolicitacaoByFuncionarioId",
		query = "SELECT solic FROM Solicitacao solic WHERE solic.funcionario.idFuncionario = :idFuncionario")
		})
public interface SolicitacaoDAO extends JpaRepository<Solicitacao, Long>{

	@Query("SELECT solic FROM Solicitacao solic WHERE solic.funcionario.idFuncionario = :idFuncionario")
	List<Solicitacao> findSolicitacaoByFuncionarioId(@Param("idFuncionario") Long idFuncionario);
	
	@Query("SELECT solic FROM Solicitacao solic WHERE solic.funcionario.idFuncionario = :idFuncionario")
	List<Solicitacao> findSolicitacaoByFuncionarioId(@Param("idFuncionario") Long idFuncionario, Pageable pageable);
	
}
