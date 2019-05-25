package com.scmitltda.sglfs.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "resultado")
public class Resultado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String numero;
	private String data;
	private List<Aposta> apostas;
	private ResultadoCaixa resultadoCaixa;
	private Double valorTotalAposta;
	private Double valorTotalGanho;
	
	public Resultado() {}
	
	public Resultado(
			String id, 
			String numero, 
			String data,
			List<Aposta> apostas,
			ResultadoCaixa resultadoCaixa,
			Double valorTotalAposta,
			Double valorTotalGanho) {
		super();
		this.id = id;
		this.numero = numero;
		this.data = data;
		this.apostas = apostas;
		this.resultadoCaixa = resultadoCaixa;
		this.valorTotalAposta = valorTotalAposta;
		this.valorTotalGanho = valorTotalGanho;
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
		this.data =  data;
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
		Resultado other = (Resultado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Resultado [id=" + id + ", numero=" + numero + ", data=" + data + ", apostas=" + apostas
				+ ", resultadoCaixa=" + resultadoCaixa + ", valorTotalAposta=" + valorTotalAposta + ", valorTotalGanho="
				+ valorTotalGanho + "]";
	}	
}
