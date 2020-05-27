package com.hotalAdmin.hta.hospede;

public class HospedeDTO {

	private String nome;
	private String documento;
	private String telefone;

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

	public Hospede toHospede() {
		return new Hospede(nome, documento, telefone);
	}
}
