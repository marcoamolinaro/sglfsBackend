package com.scmitltda.sglfs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scmitltda.sglfs.domain.Aposta;
import com.scmitltda.sglfs.dto.ApostaDTO;
import com.scmitltda.sglfs.repository.ApostaRepository;
import com.scmitltda.sglfs.services.exception.ObjectNotFoundException;

@Service
public class ApostaService {
	
	@Autowired
	private ApostaRepository apostaRepository;
	
	public List<Aposta> findAll() {
		return apostaRepository.findAll();
	}
	
	public Aposta findById(String id) {
		Optional<Aposta> obj = apostaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Aposta não encontrado"));
	}
	
	public Aposta insert(Aposta aposta) {
		return apostaRepository.insert(aposta);
	}
	
	public Aposta fromDTO(ApostaDTO apostaDTO) {
		return new Aposta(
				apostaDTO.getId(), 
				apostaDTO.getNumero(), 
				apostaDTO.getData(), 
				apostaDTO.getDezenasApostadas(),
				apostaDTO.getValor());
	}

	public Aposta update(Aposta aposta) {
		Aposta newAposta = this.findById(aposta.getId());
		updateData(newAposta, aposta);
		return apostaRepository.save(newAposta);
	}
	
	private void updateData(Aposta newAposta, Aposta aposta) {
		newAposta.setNumero(aposta.getNumero());
		newAposta.setData(aposta.getData());
		newAposta.setDezenasApostadas(aposta.getDezenasApostadas());
		newAposta.setValor(aposta.getValor());
	}
	
	public void delete(String id) {
		apostaRepository.deleteById(id);;
	}
	
	public List<Aposta> findByNumero(String numero) {
		return apostaRepository.findByNumero(numero);
	}
}
