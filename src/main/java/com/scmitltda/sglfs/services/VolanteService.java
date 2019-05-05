package com.scmitltda.sglfs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scmitltda.sglfs.domain.Volante;
import com.scmitltda.sglfs.dto.VolanteDTO;
import com.scmitltda.sglfs.repository.VolanteRepository;
import com.scmitltda.sglfs.services.exception.ObjectNotFoundException;

@Service
public class VolanteService {
	
	@Autowired
	private VolanteRepository volanteRepository;
	
	public List<Volante> findAll() {
		return volanteRepository.findAll();
	}
	
	public Volante findById(String id) {
		Optional<Volante> obj = volanteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Aposta não encontrado"));
	}
	
	public Volante insert(Volante aposta) {
		return volanteRepository.insert(aposta);
	}
	
	public Volante fromDTO(VolanteDTO apostaDTO) {
		return new Volante(
				apostaDTO.getId(), 
				apostaDTO.getNumero(), 
				apostaDTO.getData(), 
				apostaDTO.getDezenasApostadas());
	}

	public Volante update(Volante aposta) {
		Volante newAposta = this.findById(aposta.getId());
		updateData(newAposta, aposta);
		return volanteRepository.save(newAposta);
	}
	
	private void updateData(Volante newAposta, Volante aposta) {
		newAposta.setNumero(aposta.getNumero());
		newAposta.setData(aposta.getData());
		newAposta.setDezenasApostadas(aposta.getDezenasApostadas());
	}
	
	public void delete(String id) {
		volanteRepository.deleteById(id);;
	}
	
	public List<Volante> findByNumero(String numero) {
		return volanteRepository.findByNumero(numero);
	}
}
