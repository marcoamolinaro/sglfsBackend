package com.scmitltda.sglfs.dto;

import java.io.Serializable;
import java.util.List;

import com.scmitltda.sglfs.domain.Aposta;
import com.scmitltda.sglfs.domain.Resultado;
import com.scmitltda.sglfs.domain.ResultadoCaixa;

public class ResultadoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String numero;
	private String data;
	private List<Aposta> apostas;
	private ResultadoCaixa resultadoCaixa;
	private Double valorTotalAposta;
	private Double valorTotalGanho;
	
	public ResultadoDTO() {}
	
	public ResultadoDTO(Resultado resultado) {
		this.id = resultado.getId();
		this.numero = resultado.getNumero();
		this.data = resultado.getData();
		this.apostas = resultado.getApostas();
		this.resultadoCaixa = resultado.getResultadoCaixa();
		this.valorTotalAposta = resultado.getValorTotalAposta();
		this.valorTotalGanho = resultado.getValorTotalGanho();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public ResultadoCaixa getResultadoCaixa() {
		return resultadoCaixa;
	}

	public void setResultadoCaixa(ResultadoCaixa resultadoCaixa) {
		this.resultadoCaixa = resultadoCaixa;
	}

	public Double getValorTotalAposta() {
		return valorTotalAposta;
	}

	public void setValorTotalAposta(Double valorTotalAposta) {
		this.valorTotalAposta = valorTotalAposta;
	}

	public Double getValorTotalGanho() {
		return valorTotalGanho;
	}

	public void setValorTotalGanho(Double valorTotalGanho) {
		this.valorTotalGanho = valorTotalGanho;
	}
}
