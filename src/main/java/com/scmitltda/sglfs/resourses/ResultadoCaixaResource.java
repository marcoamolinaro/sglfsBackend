package com.scmitltda.sglfs.resourses;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.scmitltda.sglfs.domain.ResultadoCaixa;
import com.scmitltda.sglfs.dto.ResultadoCaixaDTO;
import com.scmitltda.sglfs.services.ResultadoCaixaService;
import com.scmitltda.sglfs.services.exception.ObjectFoundException;

@RestController
@RequestMapping(value="/resultadoCaixas")
public class ResultadoCaixaResource {
	
	@Autowired
	private ResultadoCaixaService resultadoCaixaService;
	
	@GetMapping
	public ResponseEntity<List<ResultadoCaixaDTO>> findAll() {
		
		List<ResultadoCaixa> resultadoCaixas = resultadoCaixaService.findAll();
		
		List<ResultadoCaixaDTO> resultadoCaixasDto = 
				resultadoCaixas.stream().map(r -> new ResultadoCaixaDTO(r)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(resultadoCaixasDto);
	}
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<ResultadoCaixaDTO> findById(@PathVariable String id) {
		
		ResultadoCaixa resultadoCaixa = resultadoCaixaService.findById(id);
		
		return ResponseEntity.ok().body(new ResultadoCaixaDTO(resultadoCaixa));
	}
	
	@GetMapping(value = "/{numero}")
	public ResponseEntity<ResultadoCaixaDTO> findByNumero(@PathVariable String numero) {
		
		ResultadoCaixa resultadoCaixa = resultadoCaixaService.findByNumero(numero);
		
		return ResponseEntity.ok().body(new ResultadoCaixaDTO(resultadoCaixa));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ResultadoCaixaDTO resultadoCaixaDTO) {
		
		ResultadoCaixa resultadoCaixa = resultadoCaixaService.fromDTO(resultadoCaixaDTO);
		
		resultadoCaixa = resultadoCaixaService.insert(resultadoCaixa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resultadoCaixa.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
		
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		
		resultadoCaixaService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody ResultadoCaixaDTO resultadoCaixaDTO, @PathVariable String id) {
		
		ResultadoCaixa resultadoCaixa = resultadoCaixaService.fromDTO(resultadoCaixaDTO);
		
		resultadoCaixa.setId(id);
		
		resultadoCaixa = resultadoCaixaService.update(resultadoCaixa);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/load")
	public ResponseEntity<Void> loadAll() {
		resultadoCaixaService.deleteAll();
		
		RestTemplate restTemplate = new RestTemplate();
		
		String loteria = "lotofacil";
		
		String uriUltimo = "https://www.lotodicas.com.br/api/{loteria}";
		
		 Map<String, String> params = new HashMap<String, String>();
		 params.put("loteria", loteria);
		
		ResultadoCaixa resultadoCaixa =  restTemplate.getForObject(uriUltimo, ResultadoCaixa.class, params);
		
		Integer numero = Integer.parseInt(resultadoCaixa.getNumero());
		
		String uriByNumero = "https://www.lotodicas.com.br/api/{loteria}/{numero}";
		
		for (Integer i = numero; i > 0; i--) {
			params.clear();
			params.put("loteria", loteria);
			params.put("numero", i.toString());
			
			resultadoCaixa =  restTemplate.getForObject(uriByNumero, ResultadoCaixa.class, params);
			
			resultadoCaixaService.insert(resultadoCaixa);
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/load/{numero}")
	public ResponseEntity<Void> loadByNumber(@PathVariable String numero) {	
		
		ResultadoCaixa resultadoCaixa = resultadoCaixaService.findByNumero(numero);
		
		if (resultadoCaixa != null) {
			throw new ObjectFoundException("Numero [" + numero + "] já existe na base de dados.");
		}
		
		RestTemplate restTemplate = new RestTemplate();
		
		String loteria = "lotofacil";
		
		String uriByNumero = "https://www.lotodicas.com.br/api/{loteria}/{numero}";
		
		 Map<String, String> params = new HashMap<String, String>();
		 params.put("loteria", loteria);
		 params.put("numero", numero);
		
		resultadoCaixa =  restTemplate.getForObject(uriByNumero, ResultadoCaixa.class, params);
			
		resultadoCaixaService.insert(resultadoCaixa);
		
		return ResponseEntity.noContent().build();
	}
}
