package com.scmitltda.sglfs.dto;

import java.io.Serializable;
import java.util.List;

import com.scmitltda.sglfs.domain.Criterio;

public class CriterioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private List<List<Integer>> criterio;
	
	public CriterioDTO() {}
	
	public CriterioDTO(Criterio criterio) {
		this.id = criterio.getId();
		this.name = criterio.getName();
		this.criterio = criterio.getCriterio();
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


}
