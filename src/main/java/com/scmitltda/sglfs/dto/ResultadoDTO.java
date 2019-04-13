package com.scmitltda.sglfs.dto;

import java.io.Serializable;
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
	List<Integer> sorteio;
	private Boolean acumulado;
	private Double valorAcumulado;
	private Double proximoEstimativa;
	private String proximoData;
	
	public ResultadoDTO() {}
	
	public ResultadoDTO(Resultado resultado) {
		this.id = resultado.getId();
		this.numero = resultado.getNumero();
		this.data = resultado.getData();
		this.sorteio = resultado.getSorteio();
		this.acumulado = resultado.getAcumulado();
		this.valorAcumulado = resultado.getValorAcumulado();
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

	public void setSorteio(List<Integer> sorteio) {
		this.sorteio = sorteio;
	}

	public Boolean getAcumulado() {
		return acumulado;
	}

	public void setAcumulado(Boolean acumulado) {
		this.acumulado = acumulado;
	}

	public Double getValorAcumulado() {
		return valorAcumulado;
	}

	public void setValorAcumulado(Double valorAcumulado) {
		this.valorAcumulado = valorAcumulado;
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
	
	
}
