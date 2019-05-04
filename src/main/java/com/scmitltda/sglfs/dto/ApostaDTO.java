package com.scmitltda.sglfs.dto;

import java.io.Serializable;
import java.util.Map;

import com.scmitltda.sglfs.domain.Aposta;

public class ApostaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String numero;
	private String data;
	private Map<String,Double> dezenasApostadas;
	
	public ApostaDTO() {}
	
	public String getId() {
		return id;
	}

	public ApostaDTO(Aposta aposta) {
		this.id = aposta.getId();
		this.numero = aposta.getNumero();
		this.data = aposta.getData();
		this.dezenasApostadas = aposta.getDezenasApostadas();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Map<String,Double> getDezenasApostadas() {
		return dezenasApostadas;
	}

	public void setDezenasApostadas(Map<String,Double> dezenasApostadas) {
		this.dezenasApostadas = dezenasApostadas;
	}

	public void setId(String id) {
		this.id = id;
	}
}
