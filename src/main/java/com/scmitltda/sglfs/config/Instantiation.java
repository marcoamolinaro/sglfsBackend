package com.scmitltda.sglfs.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.scmitltda.sglfs.domain.Aposta;
import com.scmitltda.sglfs.repository.ApostaRepository;

//import com.scmitltda.sglfs.repository.ResultadoRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	//@Autowired
	//private ResultadoRepository resultadoRepository;
	
	@Autowired
	private ApostaRepository apostaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		/*
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
	*/
		
		apostaRepository.deleteAll();
		
		List<Integer> dezenaApostada;
		List<List<Integer>> dezenasApostadas = new ArrayList<List<Integer>>();
		
		for (int k = 0; k <= 3; k++) {
			dezenaApostada = new ArrayList<Integer>();
			for (Integer i = 1; i <= 15; i++) {
				dezenaApostada.add(i+k);
			}
			dezenasApostadas.add(dezenaApostada);
		}	
		
		Aposta a1 = new Aposta(null, "1", "10-04-2019", dezenasApostadas);
		Aposta a2 = new Aposta(null, "2", "12-04-2019", dezenasApostadas);
		Aposta a3 = new Aposta(null, "3", "14-04-2019", dezenasApostadas);
		
		apostaRepository.saveAll(Arrays.asList(a1, a2, a3));
	}
}
