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
	
		Resultado r1 = new Resultado(null, "1", "10-04-2019", sorteio);
		Resultado r2 = new Resultado(null, "2", "12-04-2019", sorteio);
		
		resultadoRepository.saveAll(Arrays.asList(r1, r2));
	
	}

}
