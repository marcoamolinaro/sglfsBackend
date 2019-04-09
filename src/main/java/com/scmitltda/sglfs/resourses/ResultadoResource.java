package com.scmitltda.sglfs.resourses;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scmitltda.sglfs.domain.Resultado;
import com.scmitltda.sglfs.dto.ResultadoDTO;
import com.scmitltda.sglfs.services.ResultadoService;

@RestController
@RequestMapping(value="/resultados")
public class ResultadoResource {
	
	@Autowired
	private ResultadoService resultadoService;
	
	@GetMapping
	public ResponseEntity<List<ResultadoDTO>> findAll() {
		
		List<Resultado> resultados = resultadoService.findAll();
		
		List<ResultadoDTO> resultadosDto = 
				resultados.stream().map(r -> new ResultadoDTO(r)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(resultadosDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResultadoDTO> findById(@PathVariable String id) {
		
		Resultado resultado = resultadoService.findById(id);
		
		return ResponseEntity.ok().body(new ResultadoDTO(resultado));
	}

}
