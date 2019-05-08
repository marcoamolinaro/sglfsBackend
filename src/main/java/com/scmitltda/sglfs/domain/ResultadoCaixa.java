package com.scmitltda.sglfs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "resultado_caixa")
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
	private Double valor_acumulado;
	List<ArrayList<String>> cidades;
	private Double proximo_estimativa;
	private String proximo_data;
	
	public ResultadoCaixa() {}
	
	public ResultadoCaixa(
			String id, 
			String numero, 
			String data,
			List<Integer> sorteio,
			List<Integer> ganhadores,
			List<Double> rateio,
			String acumulado, 
			Double valor_acumulado,
			List<ArrayList<String>> cidades,
			Double proximo_estimativa,
			String proximo_data) {
		super();
		this.id = id;
		this.numero = numero;
		this.data = data;
		this.sorteio = sorteio;
		this.ganhadores = ganhadores;
		this.rateio = rateio;
		this.acumulado = acumulado;
		this.valor_acumulado = valor_acumulado;
		this.cidades = cidades;
		this.proximo_estimativa = proximo_estimativa;
		this.proximo_data = proximo_data;
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

	public Double getValor_acumulado() {
		return valor_acumulado;
	}

	public void setValor_acumulado(Double valor_acumulado) {
		this.valor_acumulado = valor_acumulado;
	}
	
	public List<ArrayList<String>> getCidades() {
		return cidades;
	}

	public void setCidades(List<ArrayList<String>> cidades) {
		this.cidades = cidades;
	}

	public Double getProximo_estimativa() {
		return proximo_estimativa;
	}

	public void setProximo_estimativa(Double proximo_estimativa) {
		this.proximo_estimativa = proximo_estimativa;
	}

	public String getProximo_data() {
		return proximo_data;
	}

	public void setProximo_data(String proximo_data) {
		this.proximo_data = proximo_data;
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
		return "ResultadoCaixa [id=" + id + ", numero=" + numero + ", data=" + data + ", sorteio=" + sorteio
				+ ", ganhadores=" + ganhadores + ", rateio=" + rateio + ", acumulado=" + acumulado
				+ ", valor_acumulado=" + valor_acumulado + ", cidades=" + cidades + ", proximo_estimativa="
				+ proximo_estimativa + ", proximo_data=" + proximo_data + "]";
	}
}
