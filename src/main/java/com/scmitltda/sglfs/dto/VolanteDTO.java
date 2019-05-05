package com.scmitltda.sglfs.dto;

import java.io.Serializable;
import java.util.Map;

import com.scmitltda.sglfs.domain.Volante;

public class VolanteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String numero;
	private String data;
	private Map<String,Double> dezenasApostadas;
	
	public VolanteDTO() {}
	
	public String getId() {
		return id;
	}

	public VolanteDTO(Volante volante) {
		this.id = volante.getId();
		this.numero = volante.getNumero();
		this.data = volante.getData();
		this.dezenasApostadas = volante.getDezenasApostadas();
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
