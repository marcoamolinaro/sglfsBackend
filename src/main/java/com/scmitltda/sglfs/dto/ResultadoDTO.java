package com.scmitltda.sglfs.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.scmitltda.sglfs.domain.Resultado;

public class ResultadoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String numero;
	private String data;
	private List<Integer> sorteio;
	private List<Integer> ganhadores;
	private List<Double> rateio;
	private String acumulado;
	private Double valorAcumulado;
	private List<ArrayList<String>> cidades;
	private Double proximoEstimativa;
	private String proximoData;
	
	public ResultadoDTO() {}
	
	public ResultadoDTO(Resultado resultado) {
		this.id = resultado.getId();
		this.numero = resultado.getNumero();
		this.data = resultado.getData();
		this.sorteio = resultado.getSorteio();
		this.rateio = resultado.getRateio();
		this.ganhadores = resultado.getGanhadores();
		this.acumulado = resultado.getAcumulado();
		this.valorAcumulado = resultado.getValorAcumulado();
		this.cidades = resultado.getCidades();
		this.proximoEstimativa = resultado.getProximoEstimativa();
		this.proximoData = resultado.getProximoData();
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

	public List<Integer> getSorteio() {
		return sorteio;
	}
	
	public List<Integer> getGanhadores() {
		return ganhadores;
	}

	public void setGanhadores(List<Integer> ganhadores) {
		this.ganhadores = ganhadores;
	}
	
	public List<Double> getRateio() {
		return rateio;
	}

	public void setRateio(List<Double> rateio) {
		this.rateio = rateio;
	}

	public void setSorteio(List<Integer> sorteio) {
		this.sorteio = sorteio;
	}

	public String getAcumulado() {
		return acumulado;
	}

	public void setAcumulado(String acumulado) {
		this.acumulado = acumulado;
	}

	public Double getValorAcumulado() {
		return valorAcumulado;
	}

	public void setValorAcumulado(Double valorAcumulado) {
		this.valorAcumulado = valorAcumulado;
	}

	public List<ArrayList<String>> getCidades() {
		return cidades;
	}

	public void setCidades(List<ArrayList<String>> cidades) {
		this.cidades = cidades;
	}

	public Double getProximoEstimativa() {
		return proximoEstimativa;
	}

	public void setProximoEstimativa(Double proximoEstimativa) {
		this.proximoEstimativa = proximoEstimativa;
	}

	public String getProximoData() {
		return proximoData;
	}

	public void setProximoData(String proximoData) {
		this.proximoData = proximoData;
	}

	@Override
	public String toString() {
		return "ResultadoDTO [id=" + id + ", numero=" + numero + ", data=" + data + ", sorteio=" + sorteio
				+ ", ganhadores=" + ganhadores + ", rateio=" + rateio + ", acumulado=" + acumulado + ", valorAcumulado="
				+ valorAcumulado + ", cidades=" + cidades + ", proximoEstimativa=" + proximoEstimativa
				+ ", proximoData=" + proximoData + "]";
	}
	
	
}
