package com.hotalAdmin.hta.hospede;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotalAdmin.hta.estadia.Estadia;

@Service
public class HospedeService {

	@Autowired
	private HospedeRepository hospedeRepository;

	public List<Hospede> getHospedes() {
		List<Hospede> hospedes = hospedeRepository.findAll();
		hospedes.parallelStream().forEach(hospede -> {
			hospede = getValoresEstadias(hospede);
		});

		return hospedes;
	}

	public Hospede getHospedeById(Long hospedeId) {
		Hospede hospede = hospedeRepository.findById(hospedeId).get();
		hospede = getValoresEstadias(hospede);

		return hospede;
	}

	public List<Hospede> getHospedeByNome(String nome) {
		List<Hospede> hospedes = hospedeRepository.findByNomeContainingIgnoreCase(nome);
		hospedes.parallelStream().forEach(hospede -> {
			hospede = getValoresEstadias(hospede);
		});

		return hospedes;
	}

	public List<Hospede> getHospedeByDocumento(String documento) {
		List<Hospede> hospedes = hospedeRepository.findByDocumentoContaining(documento);
		hospedes.parallelStream().forEach(hospede -> {
			hospede = getValoresEstadias(hospede);
		});

		return hospedes;
	}

	public List<Hospede> getHospedeByTelefone(String telefone) {
		List<Hospede> hospedes = hospedeRepository.findByTelefoneContaining(telefone);
		hospedes.parallelStream().forEach(hospede -> {
			hospede = getValoresEstadias(hospede);
		});

		return hospedes;
	}

	public List<Hospede> getHospedesAtivos() {
		List<Hospede> hospedes = hospedeRepository.findHospedesAtivos();
		hospedes.parallelStream().forEach(hospede -> {
			hospede = getValoresEstadias(hospede);
		});

		return hospedes;
	}

	public List<Hospede> getHospedesAnteriores() {
		List<Hospede> hospedes = hospedeRepository.findHospedesAnteriores();
		hospedes.parallelStream().forEach(hospede -> {
			hospede = getValoresEstadias(hospede);
		});

		return hospedes;
	}

	public Hospede createHospede(HospedeDTO dto) {
		Hospede hospede = dto.toHospede();
		hospede = hospedeRepository.save(hospede);

		return hospede;
	}

	public Hospede createHospede(String nome, String documento, String telefone) {
		Hospede hospede = new Hospede(nome, documento, telefone);
		hospede = hospedeRepository.save(hospede);

		return hospede;
	}

	public Hospede updateHospede(Long hospedeId, HospedeDTO dto) throws Exception {
		Hospede updatedHospede = dto.toHospede();
		Hospede hospede = hospedeRepository.findById(hospedeId).map(foundHospede -> {
			foundHospede.setNome(updatedHospede.getNome());
			foundHospede.setDocumento(updatedHospede.getDocumento());
			foundHospede.setTelefone(updatedHospede.getTelefone());
			foundHospede = hospedeRepository.save(foundHospede);
			return foundHospede;
		}).orElseThrow(() -> new Exception("NOT FOUND"));
		// TODO: Tratar erro melhor

		return hospede;
	}

	public Hospede updateHospede(Long hospedeId, String nome, String documento, String telefone) throws Exception {
		Hospede hospede = hospedeRepository.findById(hospedeId).map(foundHospede -> {
			foundHospede.setNome(nome);
			foundHospede.setDocumento(documento);
			foundHospede.setTelefone(telefone);
			foundHospede = hospedeRepository.save(foundHospede);
			return foundHospede;
		}).orElseThrow(() -> new Exception("NOT FOUND"));
		// TODO: Tratar erro melhor

		return hospede;
	}

	public Boolean deleteHospede(Hospede hospede) {
		hospedeRepository.delete(hospede);

		return true;
	}

	public Boolean deleteHospedeById(Long hospedeId) {
		hospedeRepository.deleteById(hospedeId);

		return true;
	}

	public Hospede getValoresEstadias(Hospede hospede) {
		BigDecimal valorTotalEstadias = BigDecimal.ZERO;
		BigDecimal valorUltimaEstadia = BigDecimal.ZERO;
		List<Estadia> estadias = hospede.getEstadias();

		if (estadias.size() > 0) {
			Collections.sort(estadias, (a, b) -> a.getDataSaida().before(b.getDataSaida()) ? 1 : -1);
			valorUltimaEstadia = estadias.get(estadias.size() - 1).getValor();
			valorTotalEstadias = estadias.stream().map(Estadia::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
		}
		
		hospede.setValorTotalEstadias(valorTotalEstadias);
		hospede.setValorUltimaEstadia(valorUltimaEstadia);

		return hospede;
	}

}
