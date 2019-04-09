package com.scmitltda.sglfs.resourses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scmitltda.sglfs.domain.Resultado;
import com.scmitltda.sglfs.services.ResultadoService;

@RestController
@RequestMapping(value="/resultados")
public class ResultadoResource {
	
	@Autowired
	private ResultadoService resultadoService;
	
	@GetMapping
	public ResponseEntity<List<Resultado>> findAll() {
		
		List<Resultado> resultados = resultadoService.findAll();
		
		return ResponseEntity.ok().body(resultados);
	}
}
