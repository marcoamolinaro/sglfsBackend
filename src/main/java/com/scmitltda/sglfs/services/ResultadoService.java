package com.scmitltda.sglfs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scmitltda.sglfs.domain.Resultado;
import com.scmitltda.sglfs.dto.ResultadoDTO;
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
	
	public Resultado insert(Resultado resultado) {
		return resultadoRepository.insert(resultado);
	}
	
	public void delete(String id) {
		resultadoRepository.deleteById(id);;
	}
	
	public Resultado update(Resultado resultado) {
		Resultado newResultado = this.findById(resultado.getId());
		updateData(newResultado, resultado);
		return resultadoRepository.save(newResultado);
	}
	
	private void updateData(Resultado newResultado, Resultado resultado) {
		newResultado.setNumero(resultado.getNumero());
		newResultado.setData(resultado.getData());
		newResultado.setSorteio(resultado.getSorteio());
		newResultado.setRateio(resultado.getRateio());
	}

	public Resultado fromDTO(ResultadoDTO resultadoDTO) {
		return new Resultado(
				resultadoDTO.getId(), 
				resultadoDTO.getNumero(), 
				resultadoDTO.getData(), 
				resultadoDTO.getSorteio(),
				resultadoDTO.getRateio());
	}
}
