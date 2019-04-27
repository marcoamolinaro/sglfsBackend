package com.scmitltda.sglfs.dto;

import java.io.Serializable;
import java.util.List;

import com.scmitltda.sglfs.domain.Aposta;

public class ApostaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String numero;
	private String data;
	private List<List<Integer>> sorteio;
	
	public ApostaDTO() {}
	
	public String getId() {
		return id;
	}

	public ApostaDTO(Aposta aposta) {
		this.id = aposta.getId();
		this.numero = aposta.getNumero();
		this.data = aposta.getData();
		this.sorteio = aposta.getSorteio();
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

	public List<List<Integer>> getSorteio() {
		return sorteio;
	}

	public void setSorteio(List<List<Integer>> sorteio) {
		this.sorteio = sorteio;
	}

	public void setId(String id) {
		this.id = id;
	}
}
