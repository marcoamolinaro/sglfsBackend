package com.scmitltda.sglfs.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.scmitltda.sglfs.domain.Volante;
import com.scmitltda.sglfs.domain.Resultado;
import com.scmitltda.sglfs.repository.VolanteRepository;
import com.scmitltda.sglfs.repository.ResultadoRepository;

//import com.scmitltda.sglfs.repository.ResultadoRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private ResultadoRepository resultadoRepository;
	
	//@Autowired
	//private ResultadoCaixaRepository resultadoCaixaRepository;
	
	@Autowired
	private VolanteRepository volanteRepository;

	@Override
	public void run(String... args) throws Exception {
		
		// preparar classe Resultado
		resultadoRepository.deleteAll();
		
		List<Integer> sorteio = new ArrayList<Integer>();
		
		for (Integer i = 1; i <= 15; i++) {
			sorteio.add(i);
		}
		
		List<Double> rateio = new ArrayList<Double>();
		
		for (Double i = 0.01; i <= 5; i++) {
			rateio.add(i);
		}
		
		Resultado r1 = new Resultado(null, "1", "10-04-2019", sorteio, rateio);
		Resultado r2 = new Resultado(null, "2", "12-04-2019", sorteio, rateio);
		
		resultadoRepository.saveAll(Arrays.asList(r1, r2));
		
		// Preparar classe ResultadoCaixa
		//resultadoCaixaRepository.deleteAll();
		
		// Preparar classe Aposta
		volanteRepository.deleteAll();
		
		Map<String,Double> dezenasApostadas = new HashMap<String,Double>();
		
		dezenasApostadas.put("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", 2.0);
		dezenasApostadas.put("2,3,4,5,6,7,8,9,10,11,12,13,14,15", 2.0);
		dezenasApostadas.put("1,2,3,4,5,6,7,8,9,10,11,14,16,18,20", 2.0);
		
		
		Volante v1 = new Volante(null, "1", "10-04-2019", dezenasApostadas);
		//Aposta a2 = new Aposta(null, "2", "12-04-2019", dezenasApostadas);
		//Aposta a3 = new Aposta(null, "3", "14-04-2019", dezenasApostadas);
		
		volanteRepository.saveAll(Arrays.asList(v1));
	}
}
