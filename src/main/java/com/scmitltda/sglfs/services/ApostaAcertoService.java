package com.scmitltda.sglfs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scmitltda.sglfs.domain.ApostaAcerto;
import com.scmitltda.sglfs.dto.ApostaAcertoDTO;
import com.scmitltda.sglfs.repository.ApostaAcertoRepository;
import com.scmitltda.sglfs.services.exception.ObjectNotFoundException;

@Service
public class ApostaAcertoService {
	
	@Autowired
	private ApostaAcertoRepository apostaAcertoRepository;
	
	public List<ApostaAcerto> findAll() {
		return apostaAcertoRepository.findAll();
	}
	
	public ApostaAcerto findById(String id) {
		Optional<ApostaAcerto> obj = apostaAcertoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Aposta x Acerto não encontrado"));
	}
	
	public ApostaAcerto findByKey(String key) {
		return apostaAcertoRepository.findByKey(key);
	}
	
	public ApostaAcerto insert(ApostaAcerto apostaAcerto) {
		return apostaAcertoRepository.insert(apostaAcerto);
	}
	
	public ApostaAcerto fromDTO(ApostaAcertoDTO apostaAcertoDTO) {
		return new ApostaAcerto(
				apostaAcertoDTO.getId(), 
				apostaAcertoDTO.getKey(),
				apostaAcertoDTO.getFator());
	}

	public ApostaAcerto update(ApostaAcerto apostaAcerto) {
		ApostaAcerto newApostaAcerto = this.findById(apostaAcerto.getId());
		updateData(newApostaAcerto, apostaAcerto);
		return apostaAcertoRepository.save(newApostaAcerto);
	}
	
	private void updateData(ApostaAcerto newApostaAcertoAcerto, ApostaAcerto apostaAcerto) {
		newApostaAcertoAcerto.setId(apostaAcerto.getId());
		newApostaAcertoAcerto.setKey(apostaAcerto.getKey());
		newApostaAcertoAcerto.setFator(apostaAcerto.getFator());
	}
	
	public void delete(String id) {
		apostaAcertoRepository.deleteById(id);;
	}
}
