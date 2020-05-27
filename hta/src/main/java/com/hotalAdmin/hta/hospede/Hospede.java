package com.hotalAdmin.hta.hospede;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hotalAdmin.hta.estadia.Estadia;

@Entity
@Table(name = "hospede")
public class Hospede {

	public Hospede() {

	}

	public Hospede(String nome, String documento, String telefone) {
		this.nome = nome;
		this.documento = documento;
		this.telefone = telefone;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = 0L;

	@Column
	private String nome;

	@Column
	private String documento;

	@Column
	private String telefone;

	@OneToMany(mappedBy = "hospede")
	@JsonIgnoreProperties("hospede")
	private List<Estadia> estadias = new ArrayList<>();
	
	@Transient private BigDecimal valorUltimaEstadia = BigDecimal.ZERO;
	@Transient private BigDecimal valorTotalEstadias = BigDecimal.ZERO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Estadia> getEstadias() {
		return estadias;
	}

	public void setEstadias(List<Estadia> estadias) {
		this.estadias = estadias;
	}
	
	public BigDecimal getValorUltimaEstadia() {
		return valorUltimaEstadia;
	}

	public void setValorUltimaEstadia(BigDecimal valorUltimaEstadia) {
		this.valorUltimaEstadia = valorUltimaEstadia;
	}

	public BigDecimal getValorTotalEstadias() {
		return valorTotalEstadias;
	}

	public void setValorTotalEstadias(BigDecimal valorTotalEstadias) {
		this.valorTotalEstadias = valorTotalEstadias;
	}

}