package com.scmitltda.sglfs.domain;

import java.io.Serializable;

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
	private Boolean acumulado;
	private Double valorAcumulado;
	private Double proximoEstimativa;
	private String proximoData;
	
	public Resultado() {}
	
	public Resultado(String id, String numero, String data, Boolean acumulado, Double valorAcumulado, Double proximoEstimativa,
			String proximoData) {
		super();
		this.id = id;
		this.numero = numero;
		this.data = data;
		this.acumulado = acumulado;
		this.valorAcumulado = valorAcumulado;
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
}
