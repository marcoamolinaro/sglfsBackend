package com.scmitltda.sglfs.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.scmitltda.sglfs.domain.Aposta;
import com.scmitltda.sglfs.domain.Resultado;
import com.scmitltda.sglfs.domain.ResultadoCaixa;
import com.scmitltda.sglfs.domain.Volante;
import com.scmitltda.sglfs.repository.ResultadoRepository;
import com.scmitltda.sglfs.repository.VolanteRepository;

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
		
		Resultado r1 = new Resultado(null, "1", "10-04-2019", new Aposta(), new ResultadoCaixa());
		Resultado r2 = new Resultado(null, "2", "12-04-2019", new Aposta(), new ResultadoCaixa());
		
		resultadoRepository.saveAll(Arrays.asList(r1, r2));
		
		// Preparar classe ResultadoCaixa
		//resultadoCaixaRepository.deleteAll();
		
		// Preparar classe Aposta
		volanteRepository.deleteAll();
		
		List<Aposta> apostas = new ArrayList<Aposta>();
		
		int j = 0;
		
		for (int i=0; i<=4; i++) {
			List<Integer> dezenas = new ArrayList<Integer>();
			for (int k=j; k<=15; k++) {
				dezenas.add(k);
			}
			Aposta aposta = new Aposta(dezenas, 32.0, 0, 0.00);
			apostas.add(aposta);
		}
		
		
		Volante v1 = new Volante(null, "1", "10-04-2019", apostas);
		
		volanteRepository.saveAll(Arrays.asList(v1));
	}
}
