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
	private Integer qtdDezenasAcerto;
	private Double valorGanho;
	
	public ApostaDTO() {}
	
	public ApostaDTO(Aposta aposta) {
		this.dezenas = aposta.getDezenas();
		this.valor = aposta.getValor();
		this.qtdDezenasAcerto = aposta.getQtdDezenasAcerto();
		this.valorGanho = aposta.getValorGanho();
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
}
