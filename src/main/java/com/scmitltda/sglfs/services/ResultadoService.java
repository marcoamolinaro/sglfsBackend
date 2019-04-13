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
		Optional<Resultado> newResultado = resultadoRepository.findById(resultado.getId());
		updateData(newResultado, resultado);
		return resultadoRepository.save(newResultado.get());
	}
	
	private void updateData(Optional<Resultado> newResultado, Resultado resultado) {
		newResultado.get().setNumero(resultado.getNumero());
		newResultado.get().setData(resultado.getData());
		newResultado.get().setAcumulado(resultado.getAcumulado());
		newResultado.get().setValorAcumulado(resultado.getValorAcumulado());
		newResultado.get().setProximoEstimativa(resultado.getProximoEstimativa());
		newResultado.get().setProximoData(resultado.getProximoData());
	}

	public Resultado fromDTO(ResultadoDTO resultadoDTO) {
		return new Resultado(
				resultadoDTO.getId(), resultadoDTO.getNumero(), resultadoDTO.getData(), resultadoDTO.getAcumulado(),
				resultadoDTO.getValorAcumulado(), resultadoDTO.getProximoEstimativa(), resultadoDTO.getProximoData());
	}
	

}
