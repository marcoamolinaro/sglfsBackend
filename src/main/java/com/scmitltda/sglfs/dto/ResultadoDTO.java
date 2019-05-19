package com.scmitltda.sglfs.dto;

import java.io.Serializable;

import com.scmitltda.sglfs.domain.Aposta;
import com.scmitltda.sglfs.domain.Resultado;
import com.scmitltda.sglfs.domain.ResultadoCaixa;

public class ResultadoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String numero;
	private String data;
	private Aposta aposta;
	private ResultadoCaixa resultadoCaixa;
	
	public ResultadoDTO() {}
	
	public ResultadoDTO(Resultado resultado) {
		this.id = resultado.getId();
		this.numero = resultado.getNumero();
		this.data = resultado.getData();
		this.aposta = resultado.getAposta();
		this.resultadoCaixa = resultado.getResultadoCaixa();
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

	public Aposta getAposta() {
		return aposta;
	}

	public void setAposta(Aposta aposta) {
		this.aposta = aposta;
	}

	public ResultadoCaixa getResultadoCaixa() {
		return resultadoCaixa;
	}

	public void setResultadoCaixa(ResultadoCaixa resultadoCaixa) {
		this.resultadoCaixa = resultadoCaixa;
	}
}
