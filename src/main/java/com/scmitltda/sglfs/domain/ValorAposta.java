package com.scmitltda.sglfs.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "valor_aposta")
public class ValorAposta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String qtdAposta;
	private Double valorAposta;
	
	public ValorAposta() {}

	public ValorAposta(String id, String qtdAposta, Double valorAposta) {
		super();
		this.id = id;
		this.qtdAposta = qtdAposta;
		this.valorAposta = valorAposta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQtdAposta() {
		return qtdAposta;
	}

	public void setQtdAposta(String qtdAposta) {
		this.qtdAposta = qtdAposta;
	}

	public Double getValorAposta() {
		return valorAposta;
	}

	public void setValorAposta(Double valorAposta) {
		this.valorAposta = valorAposta;
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
		ValorAposta other = (ValorAposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ValorAposta [id=" + id + ", qtdAposta=" + qtdAposta + ", valorAposta=" + valorAposta + "]";
	}
}
