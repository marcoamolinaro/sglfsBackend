package com.scmitltda.sglfs.dto;

import java.io.Serializable;
import java.util.List;

import com.scmitltda.sglfs.domain.ApostaAcerto;

public class ApostaAcertoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String key;
	private List<Integer> fator;
	
	public ApostaAcertoDTO() {}
	
	public ApostaAcertoDTO(ApostaAcerto apostaAcerto) {
		this.id = apostaAcerto.getId();
		this.key = apostaAcerto.getKey();
		this.fator = apostaAcerto.getFator();
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
}
