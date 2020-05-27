package com.hotalAdmin.hta.estadia;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hotalAdmin.hta.hospede.Hospede;

@Entity
@Table(name = "estadia")
public class Estadia {

	public Estadia() {

	}

	public Estadia(Hospede hospede, Calendar dataEntrada, Calendar dataSaida, Boolean adicionalVeiculo) {
		this.hospede = hospede;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.adicionalVeiculo = adicionalVeiculo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = 0L;

	@ManyToOne
	@JoinColumn(name = "fk_hospede")
	@JsonIgnoreProperties("estadias")
	private Hospede hospede;

	@Column
	private Calendar dataEntrada;

	@Column
	private Calendar dataSaida;

	@Column
	private Boolean adicionalVeiculo = false;

	@Column
	private BigDecimal valor = BigDecimal.ZERO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Boolean getAdicionalVeiculo() {
		return adicionalVeiculo;
	}

	public void setAdicionalVeiculo(Boolean adicionalVeiculo) {
		this.adicionalVeiculo = adicionalVeiculo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
