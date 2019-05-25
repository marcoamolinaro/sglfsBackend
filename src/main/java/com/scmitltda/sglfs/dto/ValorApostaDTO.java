package com.scmitltda.sglfs.dto;

import java.io.Serializable;

import com.scmitltda.sglfs.domain.ValorAposta;

public class ValorApostaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String qtdAposta;
	private Double valorAposta;
	
	public ValorApostaDTO() {}
	
	public ValorApostaDTO(ValorAposta valorAposta) {
		this.id = valorAposta.getId();
		this.qtdAposta = valorAposta.getQtdAposta();
		this.valorAposta = valorAposta.getValorAposta();
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
}
