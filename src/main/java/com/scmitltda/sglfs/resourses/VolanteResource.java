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

import com.scmitltda.sglfs.domain.Volante;
import com.scmitltda.sglfs.dto.VolanteDTO;
import com.scmitltda.sglfs.services.VolanteService;

@RestController
@RequestMapping(value="/volantes")
public class VolanteResource {
	
	@Autowired
	private VolanteService volanteService;
	
	@GetMapping
	public ResponseEntity<List<VolanteDTO>> findAll() {
		
		List<Volante> apostas = volanteService.findAll();
		
		List<VolanteDTO> apostasDto = 
				apostas.stream().map(r -> new VolanteDTO(r)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(apostasDto);
	}
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<VolanteDTO> findById(@PathVariable String id) {
		
		Volante aposta = volanteService.findById(id);
		
		return ResponseEntity.ok().body(new VolanteDTO(aposta));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody VolanteDTO apostaDTO) {
		
		Volante aposta = volanteService.fromDTO(apostaDTO);
		
		aposta = volanteService.insert(aposta);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aposta.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody VolanteDTO apostaDTO, @PathVariable String id) {
		
		Volante aposta = volanteService.fromDTO(apostaDTO);
		
		aposta.setId(id);
		
		aposta = volanteService.update(aposta);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		
		volanteService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{numero}")
	public ResponseEntity<List<VolanteDTO>> findByNumero(@PathVariable String numero) {
		
		List<Volante> apostas = volanteService.findByNumero(numero);
		
		List<VolanteDTO> apostasDto = 
				apostas.stream().map(r -> new VolanteDTO(r)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(apostasDto);
	}
}
