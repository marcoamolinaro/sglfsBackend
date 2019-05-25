package com.scmitltda.sglfs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scmitltda.sglfs.domain.ValorAposta;
import com.scmitltda.sglfs.dto.ValorApostaDTO;
import com.scmitltda.sglfs.repository.ValorApostaRepository;
import com.scmitltda.sglfs.services.exception.ObjectNotFoundException;

@Service
public class ValorApostaService {
	
	@Autowired
	private ValorApostaRepository valorApostaRepository;
	
	public List<ValorAposta> findAll() {
		return valorApostaRepository.findAll();
	}
	
	public ValorAposta findById(String id) {
		Optional<ValorAposta> obj = valorApostaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("ValorAposta não encontrado"));
	}
	
	public ValorAposta findByQtdAposta(String qtdAposta) {
		return valorApostaRepository.findByQtdAposta(qtdAposta);
	}
	
	public ValorAposta insert(ValorAposta valorAposta) {
		return valorApostaRepository.insert(valorAposta);
	}
	
	public ValorAposta fromDTO(ValorApostaDTO valorApostaDTO) {
		return new ValorAposta(
				valorApostaDTO.getId(), 
				valorApostaDTO.getQtdAposta(),
				valorApostaDTO.getValorAposta());
	}

	public ValorAposta update(ValorAposta valorAposta) {
		ValorAposta newAposta = this.findById(valorAposta.getId());
		updateData(newAposta, valorAposta);
		return valorApostaRepository.save(newAposta);
	}
	
	private void updateData(ValorAposta newValorAposta, ValorAposta valorAposta) {
		newValorAposta.setId(valorAposta.getId());
		newValorAposta.setQtdAposta(valorAposta.getQtdAposta());
		newValorAposta.setValorAposta(valorAposta.getValorAposta());
	}
	
	public void delete(String id) {
		valorApostaRepository.deleteById(id);;
	}
}
