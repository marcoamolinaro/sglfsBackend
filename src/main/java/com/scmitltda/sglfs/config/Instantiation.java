package com.scmitltda.sglfs.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.scmitltda.sglfs.domain.Resultado;
import com.scmitltda.sglfs.repository.ResultadoRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private ResultadoRepository resultadoRepository;

	@Override
	public void run(String... args) throws Exception {
	
		resultadoRepository.deleteAll();
		
		List<Integer> sorteio = new ArrayList<Integer>();
		
		for (Integer i = 1; i <= 15; i++) {
			sorteio.add(i);
		}
		
		List<Integer> ganhadores = new ArrayList<Integer>();
		
		for (Integer i = 1; i <= 5; i++) {
			ganhadores.add(i);
		}
		
		List<Double> rateio = new ArrayList<Double>();
		
		for (Double i = 1.12; i <= 5.12; i++) {
			rateio.add(i);
		}
		
		List<ArrayList<String>> cidades = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> hm1 = new ArrayList<String>();
		hm1.add("Rio de Janeiro");
		hm1.add("RJ");
		
		ArrayList<String> hm2 = new ArrayList<String>();
		hm2.add("São Paulo");
		hm2.add("SP");
		
		ArrayList<String> hm3 = new ArrayList<String>();
		hm3.add("BRAS\u00cdLIA");
		hm3.add("DF");
		
		ArrayList<String> hm4 = new ArrayList<String>();
		hm4.add("MAXIMILIANO DE ALMEIDA");
		hm4.add("RS");
		
		ArrayList<String> hm5 = new ArrayList<String>();
		hm5.add("ITUPEVA");
		hm5.add("SP");
		
		cidades.add(hm1);
		cidades.add(hm2);
		cidades.add(hm3);
		cidades.add(hm4);
		cidades.add(hm5);
		
		Resultado r1 = new Resultado(null, "1", "10-04-2019", sorteio, ganhadores, rateio, "sim", 1000000.00, cidades, 2000000.00, "12-04-2019");
		Resultado r2 = new Resultado(null, "2", "12-04-2019", sorteio, ganhadores, rateio, "nao", 0.00, cidades, 0.00, "14-04-2019");
		
		resultadoRepository.saveAll(Arrays.asList(r1, r2));
	
	}

}
