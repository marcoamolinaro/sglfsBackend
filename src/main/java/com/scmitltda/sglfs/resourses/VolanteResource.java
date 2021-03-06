package com.scmitltda.sglfs.resourses;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
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
import com.scmitltda.sglfs.domain.ResultadoCaixa;
import com.scmitltda.sglfs.domain.ValorAposta;
import com.scmitltda.sglfs.domain.Volante;
import com.scmitltda.sglfs.dto.VolanteDTO;
import com.scmitltda.sglfs.services.ResultadoCaixaService;
import com.scmitltda.sglfs.services.ValorApostaService;
import com.scmitltda.sglfs.services.VolanteService;
import com.scmitltda.sglfs.services.exception.InvalidArgumentNumberException;
import com.scmitltda.sglfs.services.exception.ObjectNotFoundException;
import com.scmitltda.sglfs.util.Util;

@RestController
@RequestMapping(value="/volantes")
public class VolanteResource {
	
	@Autowired
	private VolanteService volanteService;
	
	@Autowired
	private ValorApostaService valorApostaService;
	
	@Autowired
	private ResultadoCaixaService resultadoCaixaService;
	
	@GetMapping
	public ResponseEntity<List<VolanteDTO>> findAll() {
		
		List<Volante> volantes = volanteService.findAll();
		
		List<VolanteDTO> volantesDto = 
				volantes.stream().map(r -> new VolanteDTO(r)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(volantesDto);
	}
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<VolanteDTO> findById(@PathVariable String id) {
		
		Volante volante = volanteService.findById(id);
		
		return ResponseEntity.ok().body(new VolanteDTO(volante));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody VolanteDTO volanteDTO) {
		
		Volante volante = volanteService.fromDTO(volanteDTO);
		
		volante = volanteService.insert(volante);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(volante.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody VolanteDTO volanteDTO, @PathVariable String id) {
		
		Volante volante = volanteService.fromDTO(volanteDTO);
		
		volante.setId(id);
		
		volante = volanteService.update(volante);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		
		volanteService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{numero}")
	public ResponseEntity<List<VolanteDTO>> findByNumero(@PathVariable String numero) {
		
		List<Volante> volantes = volanteService.findByNumero(numero);
		
		if (volantes.isEmpty()) {
			throw new ObjectNotFoundException("Número [" + numero + "] não existe.");
		}
				
		List<VolanteDTO> volantesDto = 
				volantes.stream().map(r -> new VolanteDTO(r)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(volantesDto);
	}
	
	@GetMapping(value = "/generate/{params}")
	public ResponseEntity<VolanteDTO> generate(@PathVariable String params) {
		
		System.out.println("Paramentros [" + params + "]");
		
		String[] tempArray = params.split("&",4);
		
		System.out.println("Número de paramentros [" + tempArray.length + "]");
		
		if (tempArray.length != 4) {
			throw new InvalidArgumentNumberException(
					"São obrigatórios os parâmetros: Número do concurso, Data, quantidade de apostas e de dezenas.");
		}
		
		String numero = tempArray[0];
		String data = tempArray[1];
		Integer qtde_apostas = Integer.parseInt(tempArray[2]);
		Integer qtde_dezenas = Integer.parseInt(tempArray[3]);
		
		if ((qtde_dezenas < 15) && (qtde_dezenas > 18)) {
			throw new InvalidArgumentNumberException(
					"Quantidade de apostas deve ser: 15, 16, 17 ou 18");			
		}
		
		ValorAposta valorAposta = valorApostaService.findByQtdAposta(qtde_dezenas.toString());
		
		if (valorAposta == null) {
			throw new InvalidArgumentNumberException(
					"Não existe valor de aposta para essa quantidade de dezenas ["+qtde_dezenas+"]");						
		}
		
		List<Integer> dezenas_geradas = new ArrayList<Integer>();
		List<List<Integer>> dezenas_apostadas = new ArrayList<List<Integer>>();
		
		List<Aposta> apostas = new ArrayList<Aposta>();
		
		List<ResultadoCaixa> resultadoCaixas = resultadoCaixaService.findAll();
		
		int i = 0;
		
		while(i < qtde_apostas) {
			Aposta aposta = new Aposta();
			dezenas_geradas = Util.generateAposta(qtde_dezenas);
			Collections.sort(dezenas_geradas);
			System.out.println("Dezenas geradas depois do sort... " + dezenas_geradas);
			System.out.println("Dezenas apostadas................ " + dezenas_apostadas);			
			if (!dezenas_apostadas.contains(dezenas_geradas)) {
				dezenas_apostadas.add(dezenas_geradas);
				if (Util.validade13Matches(dezenas_geradas, resultadoCaixas)) {
					i++;
					System.out.println("Dezenas válidas.................. " + dezenas_geradas + "");
					System.out.println("Qtde geradas válidas............. " + i);
					aposta.setDezenas(dezenas_geradas);
					aposta.setValor(valorAposta.getValorAposta());
					aposta.setQtdDezenasAcerto(0);
					aposta.setValorGanho(0.00);
					apostas.add(aposta);
				} else {
					System.out.println("Dezenas descartadas matches 13... " + dezenas_geradas );
				}
			} else {
				System.out.println("Dezenas descartadas já geradas... " + dezenas_geradas );
			}
		}
		
		VolanteDTO volanteDto = new VolanteDTO();
		
		volanteDto.setApostas(apostas);
		volanteDto.setData(data);
		volanteDto.setNumero(numero);
		
		Volante volante = volanteService.fromDTO(volanteDto);
		
		volante = volanteService.insert(volante);
				
		volanteDto.setId(volante.getId());
		
		return ResponseEntity.ok().body(volanteDto);
	}
}
