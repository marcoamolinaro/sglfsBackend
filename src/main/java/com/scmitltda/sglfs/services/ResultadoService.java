package com.scmitltda.sglfs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scmitltda.sglfs.domain.Resultado;
import com.scmitltda.sglfs.repository.ResultadoRepository;
import com.scmitltda.sglfs.services.exception.ObjectNotFoundException;

@Service
public class ResultadoService {
	
	@Autowired
	private ResultadoRepository resultadoRepository;
	
	public List<Resultado> findAll() {
		return resultadoRepository.findAll();
	}
	
	public Resultado findById(String id) {
		Optional<Resultado> obj = resultadoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Resultado não encontrado"));
	}

}
