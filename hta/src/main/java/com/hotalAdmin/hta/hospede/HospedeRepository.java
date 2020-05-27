package com.hotalAdmin.hta.hospede;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {

	List<Hospede> findByNomeContainingIgnoreCase(String nome);

	List<Hospede> findByDocumentoContaining(String nome);

	List<Hospede> findByTelefoneContaining(String nome);

	@Query(value = "select distinct h.* from hospede h join estadia e on h.id = e.fk_hospede where data_entrada < now()\\:\\:timestamp and data_saida > now()\\:\\:timestamp order by nome", nativeQuery = true)
	List<Hospede> findHospedesAtivos();
	
	@Query(value = "select distinct h.* from hospede h join estadia e on h.id = e.fk_hospede where data_saida < now()\\:\\:timestamp  order by nome", nativeQuery = true)
	List<Hospede> findHospedesAnteriores();

}
