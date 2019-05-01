package com.scmitltda.sglfs.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.scmitltda.sglfs.domain.ResultadoCaixa;

/**
 * @author marco
 *
 */
public class ResultadoCaixaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String numero;
	private String data;
	private List<Integer> sorteio;
	private List<Integer> ganhadores;
	private List<Double> rateio;
	private String acumulado;
	private Double valorAcumulado;
	List<ArrayList<String>> cidades;
	private Double proximoEstimativa;
	private String proximoData;

	public ResultadoCaixaDTO() {}
	
	public ResultadoCaixaDTO(ResultadoCaixa resultadoCaixa) {
		this.id = resultadoCaixa.getId();
		this.numero = resultadoCaixa.getNumero();
		this.data = resultadoCaixa.getData();
		this.sorteio = resultadoCaixa.getSorteio();
		this.ganhadores = resultadoCaixa.getGanhadores();
		this.rateio = resultadoCaixa.getRateio();
		this.acumulado = resultadoCaixa.getAcumulado();
		this.valorAcumulado = resultadoCaixa.getValorAcumulado();
		this.valorAcumulado = resultadoCaixa.getValorAcumulado();
		this.cidades = resultadoCaixa.getCidades();
		this.proximoEstimativa = resultadoCaixa.getProximoEstimativa();
		this.proximoData = resultadoCaixa.getProximoData();
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

	public List<Integer> getSorteio() {
		return sorteio;
	}

	public void setSorteio(List<Integer> sorteio) {
		this.sorteio = sorteio;
	}

	public List<Integer> getGanhadores() {
		return ganhadores;
	}

	public void setGanhadores(List<Integer> ganhadores) {
		this.ganhadores = ganhadores;
	}

	public List<Double> getRateio() {
		return rateio;
	}

	public void setRateio(List<Double> rateio) {
		this.rateio = rateio;
	}

	public String getAcumulado() {
		return acumulado;
	}

	public void setAcumulado(String acumulado) {
		this.acumulado = acumulado;
	}

	public Double getValorAcumulado() {
		return valorAcumulado;
	}

	public void setValorAcumulado(Double valorAcumulado) {
		this.valorAcumulado = valorAcumulado;
	}

	public List<ArrayList<String>> getCidades() {
		return cidades;
	}

	public void setCidades(List<ArrayList<String>> cidades) {
		this.cidades = cidades;
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
}
