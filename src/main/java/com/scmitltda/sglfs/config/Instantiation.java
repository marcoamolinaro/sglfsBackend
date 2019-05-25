package com.scmitltda.sglfs.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.scmitltda.sglfs.domain.Aposta;
import com.scmitltda.sglfs.domain.ValorAposta;
import com.scmitltda.sglfs.domain.Volante;
import com.scmitltda.sglfs.repository.ResultadoRepository;
import com.scmitltda.sglfs.repository.ValorApostaRepository;
import com.scmitltda.sglfs.repository.VolanteRepository;

//import com.scmitltda.sglfs.repository.ResultadoRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private ResultadoRepository resultadoRepository;
	
	@Autowired
	private VolanteRepository volanteRepository;
	
	@Autowired
	private ValorApostaRepository valorApostaRepository;

	@Override
	public void run(String... args) throws Exception {
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
		
		Aposta a1 = new Aposta();
		
		List<Integer> d1 = new ArrayList<Integer>();
		d1.add(18);
		d1.add(20);
		d1.add(25);
		d1.add(23);
		d1.add(10);
		d1.add(11);
		d1.add(24);
		d1.add(14);
		d1.add(6);
		d1.add(2);
		d1.add(13);
		d1.add(9);
		d1.add(5);
		d1.add(16);
		d1.add(3);
		
		a1.setDezenas(d1);
		a1.setValor(4.0);
		a1.setQtdDezenasAcerto(0);
		a1.setValorGanho(0.00);
		
		apostas.add(a1);
		
		Aposta a2 = new Aposta();
		
		List<Integer> d2 = new ArrayList<Integer>();
		d2.add(18);
		d2.add(20);
		d2.add(25);
		d2.add(23);
		d2.add(10);
		d2.add(11);
		d2.add(24);
		d2.add(14);
		d2.add(6);
		d2.add(2);
		d2.add(13);
		d2.add(9);
		d2.add(5);
		d2.add(16);
		d2.add(1);
		
		a2.setDezenas(d2);
		a2.setValor(4.0);
		a2.setQtdDezenasAcerto(0);
		a2.setValorGanho(0.00);
		
		apostas.add(a2);
		
		Volante v1 = new Volante(null, "1", "10-04-2019", apostas);
		
		volanteRepository.saveAll(Arrays.asList(v1));

		// preparar classe Resultado
		resultadoRepository.deleteAll();
		
		// preparar Classe ValorAposta
		ValorAposta valorAposta = new ValorAposta(null, "15", 2.0);
		
		valorApostaRepository.insert(valorAposta);
		
		valorAposta = new ValorAposta(null, "16", 32.0);
		
		valorApostaRepository.insert(valorAposta);
		
		valorAposta = new ValorAposta(null, "17", 272.0);
		
		valorApostaRepository.insert(valorAposta);
		
		valorAposta = new ValorAposta(null, "18", 1632.0);
		
		valorApostaRepository.insert(valorAposta);
	}
}
