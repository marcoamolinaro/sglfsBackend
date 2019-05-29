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
import com.scmitltda.sglfs.domain.ApostaAcerto;
import com.scmitltda.sglfs.domain.Resultado;
import com.scmitltda.sglfs.domain.ResultadoCaixa;
import com.scmitltda.sglfs.domain.Volante;
import com.scmitltda.sglfs.dto.ResultadoDTO;
import com.scmitltda.sglfs.services.ApostaAcertoService;
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
	
	@Autowired 
	public ApostaAcertoService apostaAcertoyService;
	
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
		Double valorGanho = 0.0;
		String key = "";
		
		for (Volante volante: volantes) {
			List<Aposta> apostas = volante.getApostas();
			
			for (Aposta aposta: apostas) {
				Integer acertos = Util.verifyBetting(aposta.getDezenas(), resultadoCaixa.getSorteio());
				
				aposta.setQtdDezenasAcerto(acertos);
				
				key = aposta.getDezenas().size()+""+acertos;
				
				if (acertos >= 11) {
					ApostaAcerto apostaAcerto = apostaAcertoyService.findByKey(key);
					
					if (apostaAcerto != null) {
						valorGanho += 
								((	apostaAcerto.getFator().get(0) * resultadoCaixa.getRateio().get(0) ) + 
								 (  apostaAcerto.getFator().get(1) * resultadoCaixa.getRateio().get(1) ) + 
								 (  apostaAcerto.getFator().get(2) * resultadoCaixa.getRateio().get(2) ) + 
								 (  apostaAcerto.getFator().get(3) * resultadoCaixa.getRateio().get(3) ) +
								 (  apostaAcerto.getFator().get(4) * resultadoCaixa.getRateio().get(4) ));	
						
						/*
						System.out.println("Faixa 1 = " + apostaAcerto.getFator().get(0));
						System.out.println("Faixa 2 = " + apostaAcerto.getFator().get(1));
						System.out.println("Faixa 3 = " + apostaAcerto.getFator().get(2));
						System.out.println("Faixa 4 = " + apostaAcerto.getFator().get(3));
						System.out.println("Faixa 5 = " + apostaAcerto.getFator().get(4));
						
						System.out.println("Rateio 15 ptos = " + resultadoCaixa.getRateio().get(0));
						System.out.println("Rateio 14 ptos = " + resultadoCaixa.getRateio().get(1));
						System.out.println("Rateio 13 ptos = " + resultadoCaixa.getRateio().get(2));
						System.out.println("Rateio 12 ptos = " + resultadoCaixa.getRateio().get(3));
						System.out.println("Rateio 11 ptos = " + resultadoCaixa.getRateio().get(4));
						
						System.out.println("Valor Ganho = " + valorGanho);
						*/
					} 
					
					aposta.setValorGanho(valorGanho);
					
					valorGanho = 0.0;
				
					valorTotalGanho += aposta.getValorGanho();
				}
				valorTotalAposta += aposta.getValor();
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
