package com.scmitltda.sglfs.dto;

import java.io.Serializable;
import java.util.List;

import com.scmitltda.sglfs.domain.Aposta;
import com.scmitltda.sglfs.domain.Volante;

public class VolanteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String numero;
	private String data;
	private List<Aposta> apostas;
	
	public VolanteDTO() {}
	
	public String getId() {
		return id;
	}

	public VolanteDTO(Volante volante) {
		this.id = volante.getId();
		this.numero = volante.getNumero();
		this.data = volante.getData();
		this.apostas = volante.getApostas();
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

	public List<Aposta> getApostas() {
		return apostas;
	}

	public void setApostas(List<Aposta> apostas) {
		this.apostas = apostas;
	}

	public void setId(String id) {
		this.id = id;
	}
}
