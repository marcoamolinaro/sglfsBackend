package com.scmitltda.sglfs.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "aposta")
public class Aposta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String numero;
	private String data;
	private List<List<Integer>> dezenasApostadas;
	private Double valor;
	
	public Aposta() {}
	
	public Aposta(
			String id, 
			String numero, 
			String data,
			List<List<Integer>> dezenasApostadas) {
		super();
		this.id = id;
		this.numero = numero;
		this.data = data;
		this.dezenasApostadas = dezenasApostadas;
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

	public List<List<Integer>> getDezenasApostadas() {
		return dezenasApostadas;
	}

	public void setDezenasApostadas(List<List<Integer>> dezenasApostadas) {
		this.dezenasApostadas = dezenasApostadas;
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
		Aposta other = (Aposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aposta [id=" + id + ", numero=" + numero + ", data=" + data + ", dezenasApostadas=" + dezenasApostadas + "]";
	}
}
