package com.hotalAdmin.hta.estadia;

import java.util.Calendar;

import javax.xml.bind.DatatypeConverter;

import com.hotalAdmin.hta.hospede.Hospede;

public class EstadiaDTO {

	private Hospede hospede;
	private String dataEntrada;
	private String dataSaida;
	private Boolean adicionalVeiculo;
	
	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Boolean getAdicionalVeiculo() {
		return adicionalVeiculo;
	}

	public void setAdicionalVeiculo(Boolean adicionalVeiculo) {
		this.adicionalVeiculo = adicionalVeiculo;
	}
	
	public Estadia toEstadia() {
		Calendar parsedDataEntrada = DatatypeConverter.parseDateTime(dataEntrada);
		Calendar parsedDataSaida = DatatypeConverter.parseDateTime(dataSaida);
		return new Estadia (hospede, parsedDataEntrada, parsedDataSaida, adicionalVeiculo);
	}
}
