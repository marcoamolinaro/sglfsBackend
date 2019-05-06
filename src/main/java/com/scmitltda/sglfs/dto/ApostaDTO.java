package com.scmitltda.sglfs.dto;

import java.io.Serializable;
import java.util.List;

import com.scmitltda.sglfs.domain.Aposta;

public class ApostaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Integer> dezenas;
	private Double valor;
	
	public ApostaDTO() {}
	
	public ApostaDTO(Aposta aposta) {
		this.dezenas = aposta.getDezenas();
		this.valor = aposta.getValor();
	}

	public List<Integer> getDezenas() {
		return dezenas;
	}

	public void setDezenas(List<Integer> dezenas) {
		this.dezenas = dezenas;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
