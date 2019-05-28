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

import com.scmitltda.sglfs.domain.ApostaAcerto;
import com.scmitltda.sglfs.dto.ApostaAcertoDTO;
import com.scmitltda.sglfs.services.ApostaAcertoService;
import com.scmitltda.sglfs.services.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value="/apostaacertos")
public class ApostaAcertoResource {
	
	@Autowired
	private ApostaAcertoService apostaAcertoService;
	
	@GetMapping
	public ResponseEntity<List<ApostaAcertoDTO>> findAll() {
		
		List<ApostaAcerto> apostaAcertos = apostaAcertoService.findAll();
		
		List<ApostaAcertoDTO> apostaAcertosDto = 
				apostaAcertos.stream().map(r -> new ApostaAcertoDTO(r)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(apostaAcertosDto);
	}
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<ApostaAcertoDTO> findById(@PathVariable String id) {
		
		ApostaAcerto apostaAcerto = apostaAcertoService.findById(id);
		
		return ResponseEntity.ok().body(new ApostaAcertoDTO(apostaAcerto));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ApostaAcertoDTO apostaAcertoDTO) {
		
		ApostaAcerto apostaAcerto = apostaAcertoService.fromDTO(apostaAcertoDTO);
		
		apostaAcerto = apostaAcertoService.insert(apostaAcerto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(apostaAcerto.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody ApostaAcertoDTO apostaAcertoDTO, @PathVariable String id) {
		
		ApostaAcerto apostaAcerto = apostaAcertoService.fromDTO(apostaAcertoDTO);
		
		apostaAcerto.setId(id);
		
		apostaAcerto = apostaAcertoService.update(apostaAcerto);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		
		apostaAcertoService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{key}")
	public ResponseEntity<ApostaAcertoDTO> findByKey(@PathVariable String key) {
		
		ApostaAcerto apostaAcerto = apostaAcertoService.findByKey(key);
		
		if (apostaAcerto == null) {
			throw new ObjectNotFoundException("Não existe fator para a key ["+key+"]");
		}
				
		ApostaAcertoDTO apostaAcertoDto = new ApostaAcertoDTO(apostaAcerto);
		
		return ResponseEntity.ok().body(apostaAcertoDto);
	}	
}
