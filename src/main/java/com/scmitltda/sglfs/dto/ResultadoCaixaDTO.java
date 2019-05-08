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
	private Double valor_acumulado;
	List<ArrayList<String>> cidades;
	private Double proximo_estimativa;
	private String proximo_data;

	public ResultadoCaixaDTO() {}
	
	public ResultadoCaixaDTO(ResultadoCaixa resultadoCaixa) {
		this.id = resultadoCaixa.getId();
		this.numero = resultadoCaixa.getNumero();
		this.data = resultadoCaixa.getData();
		this.sorteio = resultadoCaixa.getSorteio();
		this.ganhadores = resultadoCaixa.getGanhadores();
		this.rateio = resultadoCaixa.getRateio();
		this.acumulado = resultadoCaixa.getAcumulado();
		this.valor_acumulado = resultadoCaixa.getValor_acumulado();
		this.cidades = resultadoCaixa.getCidades();
		this.proximo_estimativa = resultadoCaixa.getProximo_estimativa();
		this.proximo_data = resultadoCaixa.getProximo_data();
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

	public Double getValor_acumulado() {
		return valor_acumulado;
	}

	public void setValorAcumulado(Double valor_acumulado) {
		this.valor_acumulado = valor_acumulado;
	}

	public List<ArrayList<String>> getCidades() {
		return cidades;
	}

	public void setCidades(List<ArrayList<String>> cidades) {
		this.cidades = cidades;
	}

	public Double getProximo_estimativa() {
		return proximo_estimativa;
	}

	public void setProximoEstimativa(Double proximo_estimativa) {
		this.proximo_estimativa = proximo_estimativa;
	}

	public String getProximo_data() {
		return proximo_data;
	}

	public void setProximo_data(String proximo_data) {
		this.proximo_data = proximo_data;
	}
}
