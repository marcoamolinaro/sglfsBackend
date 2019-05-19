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
		return obj.orElseThrow(() -> new ObjectNotFoundException("Volante não encontrado"));
	}
	
	public Volante insert(Volante volante) {
		return volanteRepository.insert(volante);
	}
	
	public Volante fromDTO(VolanteDTO volanteDTO) {
		return new Volante(
				volanteDTO.getId(), 
				volanteDTO.getNumero(), 
				volanteDTO.getData(), 
				volanteDTO.getApostas());
	}

	public Volante update(Volante volante) {
		Volante newAposta = this.findById(volante.getId());
		updateData(newAposta, volante);
		return volanteRepository.save(newAposta);
	}
	
	private void updateData(Volante newAposta, Volante volante) {
		newAposta.setNumero(volante.getNumero());
		newAposta.setData(volante.getData());
		newAposta.setApostas(volante.getApostas());
	}
	
	public void delete(String id) {
		volanteRepository.deleteById(id);;
	}
	
	public List<Volante> findByNumero(String numero) {
		return volanteRepository.findByNumero(numero);
	}
}
