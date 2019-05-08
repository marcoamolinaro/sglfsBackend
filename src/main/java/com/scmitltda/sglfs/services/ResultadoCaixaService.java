package com.scmitltda.sglfs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scmitltda.sglfs.domain.ResultadoCaixa;
import com.scmitltda.sglfs.dto.ResultadoCaixaDTO;
import com.scmitltda.sglfs.repository.ResultadoCaixaRepository;
import com.scmitltda.sglfs.services.exception.ObjectNotFoundException;

@Service
public class ResultadoCaixaService {
	
	@Autowired
	private ResultadoCaixaRepository resultadoCaixaRepository;
	
	public List<ResultadoCaixa> findAll() {
		return resultadoCaixaRepository.findAll();
	}
	
	public ResultadoCaixa findByNumero(String numero) {
		return resultadoCaixaRepository.findByNumero(numero);
	}

	public void deleteAll() {
		resultadoCaixaRepository.deleteAll();
	}
	
	public ResultadoCaixa findById(String id) {
		Optional<ResultadoCaixa> obj = resultadoCaixaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("ResultadoCaixa não encontrado"));
	}
	
	public ResultadoCaixa insert(ResultadoCaixa resultadoCaixa) {
		return resultadoCaixaRepository.insert(resultadoCaixa);
	}
	
	public void delete(String id) {
		resultadoCaixaRepository.deleteById(id);;
	}
	
	public ResultadoCaixa update(ResultadoCaixa resultadoCaixa) {
		ResultadoCaixa newResultadoCaixa = this.findById(resultadoCaixa.getId());
		updateData(newResultadoCaixa, resultadoCaixa);
		return resultadoCaixaRepository.save(newResultadoCaixa);
	}
	
	private void updateData(ResultadoCaixa newResultadoCaixa, ResultadoCaixa resultadoCaixa) {
		newResultadoCaixa.setNumero(resultadoCaixa.getNumero());
		newResultadoCaixa.setData(resultadoCaixa.getData());
		newResultadoCaixa.setSorteio(resultadoCaixa.getSorteio());
		newResultadoCaixa.setGanhadores(resultadoCaixa.getGanhadores());
		newResultadoCaixa.setRateio(resultadoCaixa.getRateio());
		newResultadoCaixa.setAcumulado(resultadoCaixa.getAcumulado());
		newResultadoCaixa.setValorAcumulado(resultadoCaixa.getValorAcumulado());
		newResultadoCaixa.setCidades(resultadoCaixa.getCidades());
		newResultadoCaixa.setProximoEstimativa(resultadoCaixa.getProximoEstimativa());
		newResultadoCaixa.setProximoData(resultadoCaixa.getProximoData());
	}

	public ResultadoCaixa fromDTO(ResultadoCaixaDTO resultadoCaixaDTO) {
		return new ResultadoCaixa(
				resultadoCaixaDTO.getId(), 
				resultadoCaixaDTO.getNumero(), 
				resultadoCaixaDTO.getData(), 
				resultadoCaixaDTO.getSorteio(),
				resultadoCaixaDTO.getGanhadores(),
				resultadoCaixaDTO.getRateio(),
				resultadoCaixaDTO.getAcumulado(),
				resultadoCaixaDTO.getValorAcumulado(),
				resultadoCaixaDTO.getCidades(),
				resultadoCaixaDTO.getProximoEstimativa(),
				resultadoCaixaDTO.getProximoData());
	}
}
