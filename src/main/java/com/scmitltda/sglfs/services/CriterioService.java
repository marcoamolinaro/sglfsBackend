package com.scmitltda.sglfs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scmitltda.sglfs.domain.Criterio;
import com.scmitltda.sglfs.dto.CriterioDTO;
import com.scmitltda.sglfs.repository.CriterioRepository;
import com.scmitltda.sglfs.services.exception.ObjectNotFoundException;

@Service
public class CriterioService {
	
	@Autowired
	private CriterioRepository criterioRepository;
	
	public List<Criterio> findAll() {
		return criterioRepository.findAll();
	}
	
	public Criterio findById(String id) {
		Optional<Criterio> obj = criterioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Critério não encontrado"));
	}
	
	public Criterio findByName(String name) {
		return criterioRepository.findByName(name);
	}
	
	public Criterio insert(Criterio criterio) {
		return criterioRepository.insert(criterio);
	}
	
	public Criterio fromDTO(CriterioDTO criterioDTO) {
		return new Criterio(
				criterioDTO.getId(), 
				criterioDTO.getName(),
				criterioDTO.getCriterio());
	}

	public Criterio update(Criterio criterio) {
		Criterio newCriterio = this.findById(criterio.getId());
		updateData(newCriterio, criterio);
		return criterioRepository.save(newCriterio);
	}
	
	private void updateData(Criterio newCriterio, Criterio criterio) {
		newCriterio.setId(criterio.getId());
		newCriterio.setName(criterio.getName());
		newCriterio.setCriterio(criterio.getCriterio());
	}
	
	public void delete(String id) {
		criterioRepository.deleteById(id);;
	}
}
