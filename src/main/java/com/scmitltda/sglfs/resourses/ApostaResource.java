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

import com.scmitltda.sglfs.domain.Aposta;
import com.scmitltda.sglfs.dto.ApostaDTO;
import com.scmitltda.sglfs.services.ApostaService;

@RestController
@RequestMapping(value="/apostas")
public class ApostaResource {
	
	@Autowired
	private ApostaService apostaService;
	
	@GetMapping
	public ResponseEntity<List<ApostaDTO>> findAll() {
		
		List<Aposta> apostas = apostaService.findAll();
		
		List<ApostaDTO> apostasDto = 
				apostas.stream().map(r -> new ApostaDTO(r)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(apostasDto);
	}
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<ApostaDTO> findById(@PathVariable String id) {
		
		Aposta aposta = apostaService.findById(id);
		
		return ResponseEntity.ok().body(new ApostaDTO(aposta));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ApostaDTO apostaDTO) {
		
		Aposta aposta = apostaService.fromDTO(apostaDTO);
		
		aposta = apostaService.insert(aposta);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aposta.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody ApostaDTO apostaDTO, @PathVariable String id) {
		
		Aposta aposta = apostaService.fromDTO(apostaDTO);
		
		aposta.setId(id);
		
		aposta = apostaService.update(aposta);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		
		apostaService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{numero}")
	public ResponseEntity<List<ApostaDTO>> findByNumero(@PathVariable String numero) {
		
		List<Aposta> apostas = apostaService.findByNumero(numero);
		
		List<ApostaDTO> apostasDto = 
				apostas.stream().map(r -> new ApostaDTO(r)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(apostasDto);
	}
}
