package com.scmitltda.sglfs.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "aposta_acerto")
public class ApostaAcerto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String key;					// Aposta + Acertos
	private List<Integer> fator;
	
	public ApostaAcerto() {}

	public ApostaAcerto(String id, String key, List<Integer> fator) {
		super();
		this.id = id;
		this.key = key;
		this.fator = fator;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<Integer> getFator() {
		return fator;
	}

	public void setFator(List<Integer> fator) {
		this.fator = fator;
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
		ApostaAcerto other = (ApostaAcerto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApostaAcerto [id=" + id + ", key=" + key + ", fator=" + fator + "]";
	}
}
