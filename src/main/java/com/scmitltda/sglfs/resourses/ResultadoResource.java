package com.scmitltda.sglfs.resourses;

import java.net.URI;
import java.util.ArrayList;
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
import com.scmitltda.sglfs.domain.Resultado;
import com.scmitltda.sglfs.domain.ResultadoCaixa;
import com.scmitltda.sglfs.domain.Volante;
import com.scmitltda.sglfs.dto.ResultadoDTO;
import com.scmitltda.sglfs.services.ResultadoCaixaService;
import com.scmitltda.sglfs.services.ResultadoService;
import com.scmitltda.sglfs.services.VolanteService;
import com.scmitltda.sglfs.services.exception.ObjectFoundException;
import com.scmitltda.sglfs.util.Util;

@RestController
@RequestMapping(value="/resultados")
public class ResultadoResource {
	
	@Autowired
	private ResultadoService resultadoService;
	
	@Autowired
	private ResultadoCaixaService resultadoCaixaService;
	
	@Autowired
	private VolanteService volanteService;
	
	@GetMapping
	public ResponseEntity<List<ResultadoDTO>> findAll() {
		
		List<Resultado> resultados = resultadoService.findAll();
		
		List<ResultadoDTO> resultadosDto = 
				resultados.stream().map(r -> new ResultadoDTO(r)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(resultadosDto);
	}
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<ResultadoDTO> findById(@PathVariable String id) {
		
		Resultado resultado = resultadoService.findById(id);
		
		return ResponseEntity.ok().body(new ResultadoDTO(resultado));
	}
	
	@GetMapping(value = "/{numero}")
	public ResponseEntity<ResultadoDTO> findByNumero(@PathVariable String numero) {
		
		Resultado resultado = resultadoService.findByNumero(numero);
		
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
	
	@GetMapping(value = "/verify/{numero}")
	public ResponseEntity<List<ResultadoDTO>> verify(@PathVariable String numero) {
		
		List<ResultadoDTO> resultadosDtos = new ArrayList<ResultadoDTO>();
		
		ResultadoCaixa resultadoCaixa = resultadoCaixaService.findByNumero(numero);
		
		if (resultadoCaixa == null) {
			throw new ObjectFoundException("Numero [" + numero + "] não existe em Resultado da CEF.");
		}
		
		List<Volante> volantes = volanteService.findByNumero(numero);
		
		if (volantes.isEmpty()) {
			throw new ObjectFoundException("Não existe Volantes para o número [" + numero + "].");
		}
		
		Double valorTotalAposta = 0.0;
		Double valorTotalGanho = 0.0;
		
		for (Volante volante: volantes) {
			List<Aposta> apostas = volante.getApostas();
			
			for (Aposta aposta: apostas) {
				Integer acertos = Util.verifyBetting(aposta.getDezenas(), resultadoCaixa.getSorteio());
				
				aposta.setQtdDezenasAcerto(acertos);
				
				switch (acertos) {
				case 15:
					aposta.setValorGanho(resultadoCaixa.getRateio().get(0));
					break;
				case 14:
					aposta.setValorGanho(resultadoCaixa.getRateio().get(1));
					break;
				case 13:
					aposta.setValorGanho(resultadoCaixa.getRateio().get(2));
					break;
				case 12:
					aposta.setValorGanho(resultadoCaixa.getRateio().get(3));
					break;
				case 11:
					aposta.setValorGanho(resultadoCaixa.getRateio().get(4));
					break;
				}
				
				valorTotalAposta += aposta.getValor();
				valorTotalGanho += aposta.getValorGanho();
			}
				
			ResultadoDTO resultadoDto = new ResultadoDTO();
			
			resultadoDto.setNumero(numero);
			resultadoDto.setData(resultadoCaixa.getData());
			resultadoDto.setApostas(apostas);
			resultadoDto.setResultadoCaixa(resultadoCaixa);
			resultadoDto.setValorTotalAposta(valorTotalAposta);
			resultadoDto.setValorTotalGanho(valorTotalGanho);
						
			Resultado resultado = resultadoService.fromDTO(resultadoDto);
			
			resultado = resultadoService.insert(resultado);
			
			resultadoDto.setId(resultado.getId());
			
			resultadosDtos.add(resultadoDto);
		}
		
		return ResponseEntity.ok().body(resultadosDtos);
	}
	
}
