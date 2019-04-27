package com.scmitltda.sglfs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scmitltda.sglfs.domain.Aposta;
import com.scmitltda.sglfs.repository.ApostaRepository;

@Service
public class ApostaService {
	
	@Autowired
	private ApostaRepository apostaRepository;
	
	public List<Aposta> findAll() {
		return apostaRepository.findAll();
	}
	
	/*
	public Aposta findByNumero(String numero) {
		return apostaRepository.findByNumero(numero);
	}

	public void deleteAll() {
		apostaRepository.deleteAll();
	}
	
	public Aposta findById(String id) {
		Optional<Aposta> obj = apostaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Aposta não encontrado"));
	}
	
	public Aposta insert(Aposta resultado) {
		return apostaRepository.insert(resultado);
	}
	
	public void delete(String id) {
		apostaRepository.deleteById(id);;
	}
	
	public Aposta update(Aposta resultado) {
		Aposta newAposta = this.findById(resultado.getId());
		updateData(newAposta, resultado);
		return apostaRepository.save(newAposta);
	}
	
	private void updateData(Aposta newAposta, Aposta resultado) {
		newAposta.setNumero(resultado.getNumero());
		newAposta.setData(resultado.getData());
		newAposta.setSorteio(resultado.getSorteio());
		newAposta.setRateio(resultado.getRateio());
	}

	public Aposta fromDTO(ApostaDTO resultadoDTO) {
		return new Aposta(
				resultadoDTO.getId(), 
				resultadoDTO.getNumero(), 
				resultadoDTO.getData(), 
				resultadoDTO.getSorteio(),
				resultadoDTO.getRateio());
	}
	*/
}
