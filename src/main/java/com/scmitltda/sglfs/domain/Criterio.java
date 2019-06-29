package com.scmitltda.sglfs.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "criterio")
public class Criterio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private List<List<Integer>> criterio; 
	
	
	public Criterio() {}

	public Criterio(String id, String name, List<List<Integer>> criterio) {
		super();
		this.id = id;
		this.name = name;
		this.criterio = criterio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<List<Integer>> getCriterio() {
		return criterio;
	}

	public void setCriterio(List<List<Integer>> criterio) {
		this.criterio = criterio;
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
		Criterio other = (Criterio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Criterio [id=" + id + ", name=" + name + ", criterio=" + criterio + "]";
	}
}
