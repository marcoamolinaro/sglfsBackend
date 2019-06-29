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

import com.scmitltda.sglfs.domain.Criterio;
import com.scmitltda.sglfs.dto.CriterioDTO;
import com.scmitltda.sglfs.services.CriterioService;
import com.scmitltda.sglfs.services.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value="/criterios")
public class CriterioResource {
	
	@Autowired
	private CriterioService criterioService;
	
	@GetMapping
	public ResponseEntity<List<CriterioDTO>> findAll() {
		
		List<Criterio> criterios = criterioService.findAll();
		
		List<CriterioDTO> criteriosDto = 
				criterios.stream().map(r -> new CriterioDTO(r)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(criteriosDto);
	}
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<CriterioDTO> findById(@PathVariable String id) {
		
		Criterio criterio = criterioService.findById(id);
		
		return ResponseEntity.ok().body(new CriterioDTO(criterio));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody CriterioDTO criterioDTO) {
		
		Criterio criterio = criterioService.fromDTO(criterioDTO);
		
		criterio = criterioService.insert(criterio);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(criterio.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody CriterioDTO criterioDTO, @PathVariable String id) {
		
		Criterio criterio = criterioService.fromDTO(criterioDTO);
		
		criterio.setId(id);
		
		criterio = criterioService.update(criterio);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		
		criterioService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{key}")
	public ResponseEntity<CriterioDTO> findByKey(@PathVariable String name) {
		
		Criterio criterio = criterioService.findByName(name);
		
		if (criterio == null) {
			throw new ObjectNotFoundException("Não existe critério para o nome ["+name+"]");
		}
				
		CriterioDTO criterioDto = new CriterioDTO(criterio);
		
		return ResponseEntity.ok().body(criterioDto);
	}	
}
