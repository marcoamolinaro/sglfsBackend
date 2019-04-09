package com.scmitltda.sglfs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scmitltda.sglfs.domain.Resultado;
import com.scmitltda.sglfs.repository.ResultadoRepository;

@Service
public class ResultadoService {
	
	@Autowired
	private ResultadoRepository resultadoRepository;
	
	public List<Resultado> findAll() {
		return resultadoRepository.findAll();
	}

}
