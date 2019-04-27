package com.scmitltda.sglfs.resourses;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scmitltda.sglfs.domain.Aposta;
import com.scmitltda.sglfs.dto.ApostaDTO;
import com.scmitltda.sglfs.services.ApostaService;

@RestController
@RequestMapping(value="/apostas")
public class ApostaResource {
	
	@Autowired
	private ApostaService resultadoService;
	
	@GetMapping
	public ResponseEntity<List<ApostaDTO>> findAll() {
		
		List<Aposta> apostas = resultadoService.findAll();
		
		List<ApostaDTO> apostasDto = 
				apostas.stream().map(r -> new ApostaDTO(r)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(apostasDto);
	}
	
	/*
	@GetMapping(value = "/{id}")
	public ResponseEntity<ApostaDTO> findById(@PathVariable String id) {
		
		Aposta resultado = resultadoService.findById(id);
		
		return ResponseEntity.ok().body(new ApostaDTO(resultado));
	}
	
	@GetMapping(value = "/{numero}")
	public ResponseEntity<ApostaDTO> findByNumero(@PathVariable String numero) {
		
		Aposta resultado = resultadoService.findByNumero(numero);
		
		return ResponseEntity.ok().body(new ApostaDTO(resultado));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ApostaDTO resultadoDTO) {
		
		Aposta resultado = resultadoService.fromDTO(resultadoDTO);
		
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
	public ResponseEntity<Void> update(@RequestBody ApostaDTO resultadoDTO, @PathVariable String id) {
		
		Aposta resultado = resultadoService.fromDTO(resultadoDTO);
		
		resultado.setId(id);
		
		resultado = resultadoService.update(resultado);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/load")
	public ResponseEntity<Void> loadAll() {
		resultadoService.deleteAll();
		
		RestTemplate restTemplate = new RestTemplate();
		
		String loteria = "lotofacil";
		
		String uriUltimo = "https://www.lotodicas.com.br/api/{loteria}";
		
		 Map<String, String> params = new HashMap<String, String>();
		 params.put("loteria", loteria);
		
		ApostaCaixa resultadoCaixa =  restTemplate.getForObject(uriUltimo, ApostaCaixa.class, params);
		
		Integer numero = Integer.parseInt(resultadoCaixa.getNumero());
		
		String uriByNumero = "https://www.lotodicas.com.br/api/{loteria}/{numero}";
		
		for (Integer i = numero; i > 0; i--) {
			params.clear();
			params.put("loteria", loteria);
			params.put("numero", i.toString());
			
			resultadoCaixa =  restTemplate.getForObject(uriByNumero, ApostaCaixa.class, params);
			
			Aposta resultado = new Aposta();
			
			resultado.setNumero(resultadoCaixa.getNumero());
			resultado.setData(resultadoCaixa.getData());
			resultado.setSorteio(resultadoCaixa.getSorteio());
			resultado.setRateio(resultadoCaixa.getRateio());
			
			resultadoService.insert(resultado);
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/load/{numero}")
	public ResponseEntity<Void> loadByNumber(@PathVariable String numero) {	
		
		Aposta resultado = resultadoService.findByNumero(numero);
		
		if (resultado != null) {
			throw new ObjectFoundException("Numero [" + numero + "] já existe na base de dados.");
		}
		
		RestTemplate restTemplate = new RestTemplate();
		
		String loteria = "lotofacil";
		
		String uriByNumero = "https://www.lotodicas.com.br/api/{loteria}/{numero}";
		
		 Map<String, String> params = new HashMap<String, String>();
		 params.put("loteria", loteria);
		 params.put("numero", numero);
		
		ApostaCaixa resultadoCaixa =  restTemplate.getForObject(uriByNumero, ApostaCaixa.class, params);
		
		resultado = new Aposta();
			
		resultado.setNumero(resultadoCaixa.getNumero());
		resultado.setData(resultadoCaixa.getData());
		resultado.setSorteio(resultadoCaixa.getSorteio());
		resultado.setRateio(resultadoCaixa.getRateio());
			
		resultadoService.insert(resultado);
		
		return ResponseEntity.noContent().build();
	}
	*/
}
