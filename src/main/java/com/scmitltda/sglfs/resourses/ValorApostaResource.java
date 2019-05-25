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

import com.scmitltda.sglfs.domain.ValorAposta;
import com.scmitltda.sglfs.dto.ValorApostaDTO;
import com.scmitltda.sglfs.services.ValorApostaService;
import com.scmitltda.sglfs.services.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value="/valorapostas")
public class ValorApostaResource {
	
	@Autowired
	private ValorApostaService valorApostaService;
	
	@GetMapping
	public ResponseEntity<List<ValorApostaDTO>> findAll() {
		
		List<ValorAposta> valorApostas = valorApostaService.findAll();
		
		List<ValorApostaDTO> valorApostasDto = 
				valorApostas.stream().map(r -> new ValorApostaDTO(r)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(valorApostasDto);
	}
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<ValorApostaDTO> findById(@PathVariable String id) {
		
		ValorAposta valorAposta = valorApostaService.findById(id);
		
		return ResponseEntity.ok().body(new ValorApostaDTO(valorAposta));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ValorApostaDTO valorApostaDTO) {
		
		ValorAposta valorAposta = valorApostaService.fromDTO(valorApostaDTO);
		
		valorAposta = valorApostaService.insert(valorAposta);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(valorAposta.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody ValorApostaDTO valorApostaDTO, @PathVariable String id) {
		
		ValorAposta valorAposta = valorApostaService.fromDTO(valorApostaDTO);
		
		valorAposta.setId(id);
		
		valorAposta = valorApostaService.update(valorAposta);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		
		valorApostaService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{qtdAposta}")
	public ResponseEntity<ValorApostaDTO> findByQtdAposta(@PathVariable String qtdAposta) {
		
		ValorAposta valorAposta = valorApostaService.findByQtdAposta(qtdAposta);
		
		if (valorAposta == null) {
			throw new ObjectNotFoundException("Não existe valor de aposta para a quantidade de apostas =  [" + qtdAposta + "] não.");
		}
				
		ValorApostaDTO valorApostaDto = new ValorApostaDTO(valorAposta);
		
		return ResponseEntity.ok().body(valorApostaDto);
	}	
}
