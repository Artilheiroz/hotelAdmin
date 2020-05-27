package com.hotalAdmin.hta.hospede;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/hotelAdmin/hospede")
public class HospedeController {

	@Autowired
	private HospedeService hospedeService;

	@GetMapping("/getHospedes")
	public ResponseEntity<?> getHospedes() {

		ResponseEntity<List<Hospede>> response = null;
		try {
			List<Hospede> hospedes = hospedeService.getHospedes();
			response = ResponseEntity.ok(hospedes);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			response = ResponseEntity.status(500).build();
		}

		return response;
	}

	@GetMapping("/getHospedesPageable")
	public ResponseEntity<?> getHospedesPageable(Pageable pageable) {

		ResponseEntity<Page<Hospede>> response = null;
		try {
			Page<Hospede> hospedesPageable = hospedeService.getHospedesPageable(pageable);
			response = ResponseEntity.ok(hospedesPageable);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			response = ResponseEntity.status(500).build();
		}

		return response;
	}

	@GetMapping("/getHospedeById/{hospedeId}")
	public ResponseEntity<?> getHospedeById(@PathVariable Long hospedeId) {

		ResponseEntity<Hospede> response = null;
		try {
			Hospede hospede = hospedeService.getHospedeById(hospedeId);
			response = ResponseEntity.ok(hospede);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			response = ResponseEntity.status(500).build();
		}

		return response;
	}
	
	@GetMapping("/getHospedesByNome/{nome}")
	public ResponseEntity<?> getHospedesByNome(@PathVariable String nome) {

		ResponseEntity<List<Hospede>> response = null;
		try {
			List<Hospede> hospedes = hospedeService.getHospedeByNome(nome);
			response = ResponseEntity.ok(hospedes);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			response = ResponseEntity.status(500).build();
		}

		return response;
	}
	
	@GetMapping("/getHospedesByDocumento/{documento}")
	public ResponseEntity<?> getHospedesByDocumento(@PathVariable String documento) {

		ResponseEntity<List<Hospede>> response = null;
		try {
			List<Hospede> hospedes = hospedeService.getHospedeByDocumento(documento);
			response = ResponseEntity.ok(hospedes);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			response = ResponseEntity.status(500).build();
		}

		return response;
	}
	
	@GetMapping("/getHospedesByTelefone/{telefone}")
	public ResponseEntity<?> getHospedesByTelefone(@PathVariable String telefone) {

		ResponseEntity<List<Hospede>> response = null;
		try {
			List<Hospede> hospedes = hospedeService.getHospedeByTelefone(telefone);
			response = ResponseEntity.ok(hospedes);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			response = ResponseEntity.status(500).build();
		}

		return response;
	}
	
	@GetMapping("/getHospedesAtivos")
	public ResponseEntity<?> getHospedesAtivos() {

		ResponseEntity<List<Hospede>> response = null;
		try {
			List<Hospede> hospedes = hospedeService.getHospedesAtivos();
			response = ResponseEntity.ok(hospedes);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			response = ResponseEntity.status(500).build();
		}

		return response;
	}

	@GetMapping("/getHospedesAnteriores")
	public ResponseEntity<?> getHospedesAnteriores() {

		ResponseEntity<List<Hospede>> response = null;
		try {
			List<Hospede> hospedes = hospedeService.getHospedesAnteriores();
			response = ResponseEntity.ok(hospedes);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			response = ResponseEntity.status(500).build();
		}

		return response;
	}
	
	@PostMapping("/createHospede")
	public ResponseEntity<?> createHospede(@RequestBody HospedeDTO dto) {

		ResponseEntity<Hospede> response = null;
		try {
			Hospede newHospede = hospedeService.createHospede(dto);
			response = ResponseEntity.ok(newHospede);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			response = ResponseEntity.status(500).build();
		}

		return response;
	}

	@PutMapping("/updadeHospede/{hospedeId}")
	public ResponseEntity<?> updadeHospede(@PathVariable Long hospedeId, @RequestBody HospedeDTO dto) {

		ResponseEntity<Hospede> response = null;
		try {
			Hospede newHospede = hospedeService.updateHospede(hospedeId, dto);
			response = ResponseEntity.ok(newHospede);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			response = ResponseEntity.status(500).build();
		}

		return response;
	}

	@DeleteMapping("/deleteHospede/{hospedeId}")
	public ResponseEntity<?> deleteHospede(@PathVariable Long hospedeId) {

		ResponseEntity<Boolean> response = null;
		try {
			Boolean dealeted = hospedeService.deleteHospedeById(hospedeId);
			response = ResponseEntity.ok(dealeted);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			response = ResponseEntity.status(500).build();
		}

		return response;
	}

}
