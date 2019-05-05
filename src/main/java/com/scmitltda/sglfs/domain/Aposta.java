package com.scmitltda.sglfs.domain;

import java.io.Serializable;
import java.util.List;

public class Aposta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Integer> dezenas;
	private Double valor;
	
	public Aposta() {
		super();
	}

	public Aposta(List<Integer> dezenas, Double valor) {
		super();
		this.dezenas = dezenas;
		this.valor = valor;
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

	@Override
	public String toString() {
		return "Aposta [dezenas=" + dezenas + ", valor=" + valor + "]";
	}
}
