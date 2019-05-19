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
	private Integer qtdDezenasAcerto;
	private Double valorGanho;
	
	public Aposta() {}

	public Aposta(List<Integer> dezenas, Double valor, Integer qtdDezenasAcerto, Double valorGanho) {
		super();
		this.dezenas = dezenas;
		this.valor = valor;
		this.qtdDezenasAcerto = qtdDezenasAcerto;
		this.valorGanho = valorGanho;
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

	
	public Integer getQtdDezenasAcerto() {
		return qtdDezenasAcerto;
	}

	public void setQtdDezenasAcerto(Integer qtdDezenasAcerto) {
		this.qtdDezenasAcerto = qtdDezenasAcerto;
	}

	public Double getValorGanho() {
		return valorGanho;
	}

	public void setValorGanho(Double valorGanho) {
		this.valorGanho = valorGanho;
	}

	@Override
	public String toString() {
		return "Aposta [dezenas=" + dezenas + ", valor=" + valor + ", qtdDezenasAcerto=" + qtdDezenasAcerto
				+ ", valorGanho=" + valorGanho + "]";
	}
}
