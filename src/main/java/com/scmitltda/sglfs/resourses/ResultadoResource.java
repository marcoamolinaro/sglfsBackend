package com.scmitltda.sglfs.resourses;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ResultadoDTO resultadoDTO) {
		
		Resultado resultado = resultadoService.fromDTO(resultadoDTO);
		
		resultado = resultadoService.insert(resultado);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resultado.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		
		resultadoService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody ResultadoDTO resultadoDTO, @PathVariable String id) {
		
		Resultado resultado = resultadoService.fromDTO(resultadoDTO);
		
		resultado.setId(id);
		
		resultado = resultadoService.update(resultado);
		
		return ResponseEntity.noContent().build();
	}

}
