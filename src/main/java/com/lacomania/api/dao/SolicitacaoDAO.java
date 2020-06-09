package com.lacomania.api.dao;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lacomania.api.entities.Solicitacao;

@Transactional(readOnly = true)

@NamedQueries({
	@NamedQuery(name= "SolicitacaoDAO.findSolicitacaoByclienteId",
		query = "SELECT solic FROM Solicitacao solic WHERE solic.cliente.idCliente = :idCliente")
		})
public interface SolicitacaoDAO extends JpaRepository<Solicitacao, Long>{

	@Query("SELECT solic FROM Solicitacao solic WHERE solic.cliente.idCliente = :idCliente")
	List<Solicitacao> findSolicitacaoByclienteId(@Param("idCliente") Long idCliente);
	
	@Query("SELECT solic FROM Solicitacao solic WHERE solic.cliente.idCliente = :idCliente")
	List<Solicitacao> findSolicitacaoByclienteId(@Param("idCliente") Long idCliente, Pageable pageable);
	
}
