package com.scmitltda.sglfs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "resultado")
public class ResultadoCaixa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String numero;
	private String data;
	private List<Integer> sorteio;
	private List<Integer> ganhadores;
	private List<Double> rateio;
	private String acumulado;
	private Double valorAcumulado;
	List<ArrayList<String>> cidades;
	private Double proximoEstimativa;
	private String proximoData;
	
	public ResultadoCaixa() {}
	
	public ResultadoCaixa(
			String id, 
			String numero, 
			String data,
			List<Integer> sorteio,
			List<Integer> ganhadores,
			List<Double> rateio,
			String acumulado, 
			Double valorAcumulado,
			List<ArrayList<String>> cidades,
			Double proximoEstimativa,
			String proximoData) {
		super();
		this.id = id;
		this.numero = numero;
		this.data = data;
		this.sorteio = sorteio;
		this.ganhadores = ganhadores;
		this.rateio = rateio;
		this.acumulado = acumulado;
		this.valorAcumulado = valorAcumulado;
		this.cidades = cidades;
		this.proximoEstimativa = proximoEstimativa;
		this.proximoData = proximoData;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultadoCaixa other = (ResultadoCaixa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Resultado [id=" + id + ", numero=" + numero + ", data=" + data + ", sorteio=" + sorteio
				+ ", ganhadores=" + ganhadores + ", rateio=" + rateio + ", acumulado=" + acumulado + ", valorAcumulado="
				+ valorAcumulado + ", cidades=" + cidades + ", proximoEstimativa=" + proximoEstimativa
				+ ", proximoData=" + proximoData + "]";
	}	
}
