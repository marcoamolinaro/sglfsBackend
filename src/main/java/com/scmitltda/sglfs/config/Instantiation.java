package com.scmitltda.sglfs.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.scmitltda.sglfs.domain.Criterio;
import com.scmitltda.sglfs.repository.CriterioRepository;

//import com.scmitltda.sglfs.repository.ResultadoRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	//@Autowired
	//private ResultadoRepository resultadoRepository;
	
	//@Autowired
	//private VolanteRepository volanteRepository;
	
	//@Autowired
	//private ApostaAcertoRepository apostaAcertoRepository;
	
	//@Autowired
	//private ValorApostaRepository valorApostaRepository;
	
	@Autowired
	private CriterioRepository criterioRepository;

	@Override
	public void run(String... args) throws Exception {
		// Preparando classe Criterio
		criterioRepository.deleteAll();
		
		List<List<Integer>> criterios = new ArrayList<List<Integer>>();
		
		String name = "Fechamento";
		
		List<Integer> v1 = new ArrayList<Integer>();
		
		v1.add(15); // Quantidade de dezenas apostadas
		v1.add(11); // Quantidade de dezenas fechamento
		v1.add(10); // Quantidade mínima de acertos
		
		criterios.add(v1);
		
		List<Integer> v2 = new ArrayList<Integer>();

		v2.add(15); // Quantidade de dezenas apostadas
		v2.add(12); // Quantidade de dezenas fechamento
		v2.add(8); // Quantidade mínima de acertos
		
		criterios.add(v2);
		
		List<Integer> v3 = new ArrayList<Integer>();
		
		v3.add(16); // Quantidade de dezenas apostadas
		v3.add(12); // Quantidade de dezenas fechamento
		v3.add(15); // Quantidade mínima de acertos

		criterios.add(v3);

		List<Integer> v4 = new ArrayList<Integer>();
		
		v4.add(17); // Quantidade de dezenas apostadas
		v4.add(12); // Quantidade de dezenas fechamento
		v4.add(17); // Quantidade mínima de acertos

		criterios.add(v4);

		Criterio criterio = new Criterio();
		
		criterio.setName(name);
		criterio.setCriterio(criterios);
		
		criterioRepository.save(criterio);
		
		// Preparar classe Aposta
		/*
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
		
		Aposta a3 = new Aposta();
		
		List<Integer> d3 = new ArrayList<Integer>();
		d3.add(1);
		d3.add(3);
		d3.add(4);
		d3.add(6);
		d3.add(7);
		d3.add(9);
		d3.add(12);
		d3.add(13);
		d3.add(14);
		d3.add(16);
		d3.add(19);
		d3.add(21);
		d3.add(22);
		d3.add(24);
		d3.add(25);
		d3.add(18);
		d3.add(20);
		
		a3.setDezenas(d3);
		a3.setValor(272.0);
		a3.setQtdDezenasAcerto(0);
		a3.setValorGanho(0.00);
		
		apostas.add(a3);

		
		Volante v1 = new Volante(null, "1810", "06-05-2019", apostas);
		
		volanteRepository.saveAll(Arrays.asList(v1));
		
		// preparar classe Resultado
		resultadoRepository.deleteAll();
		
		// Preparar classe ApostaAcerto
		/*
		apostaAcertoRepository.deleteAll();
		
		ApostaAcerto aa1 = new ApostaAcerto();
		List<Integer> fatorList1 = new ArrayList<Integer>();
		
		aa1.setKey("1515");
		fatorList1.add(1);  		// Fator para a faixa 1
		fatorList1.add(0);			// Fator para a faixa 2
		fatorList1.add(0);			// Fator para a faixa 3
		fatorList1.add(0);			// Fator para a faixa 4
		fatorList1.add(0);			// Fator para a faixa 5
		aa1.setFator(fatorList1);
		
		ApostaAcerto aa2 = new ApostaAcerto();
		List<Integer> fatorList2 = new ArrayList<Integer>();
		
		aa2.setKey("1615");
		fatorList2.add(1);  		// Fator para a faixa 1
		fatorList2.add(15);			// Fator para a faixa 2
		fatorList2.add(0);			// Fator para a faixa 3
		fatorList2.add(0);			// Fator para a faixa 4
		fatorList2.add(0);			// Fator para a faixa 5
		aa2.setFator(fatorList2);

		ApostaAcerto aa3 = new ApostaAcerto();
		List<Integer> fatorList3 = new ArrayList<Integer>();
		
		aa3.setKey("1715");
		fatorList3.add(1);  		// Fator para a faixa 1
		fatorList3.add(30);			// Fator para a faixa 2
		fatorList3.add(105);		// Fator para a faixa 3
		fatorList3.add(0);			// Fator para a faixa 4
		fatorList3.add(0);			// Fator para a faixa 5
		aa3.setFator(fatorList3);

		ApostaAcerto aa4 = new ApostaAcerto();
		List<Integer> fatorList4 = new ArrayList<Integer>();
		
		aa4.setKey("1815");
		fatorList4.add(1);  		// Fator para a faixa 1
		fatorList4.add(45);			// Fator para a faixa 2
		fatorList4.add(315);		// Fator para a faixa 3
		fatorList4.add(455);		// Fator para a faixa 4
		fatorList4.add(0);			// Fator para a faixa 5
		aa4.setFator(fatorList4);
		
		ApostaAcerto aa5 = new ApostaAcerto();
		List<Integer> fatorList5 = new ArrayList<Integer>();
		
		aa5.setKey("1514");
		fatorList5.add(0);  		// Fator para a faixa 1
		fatorList5.add(1);			// Fator para a faixa 2
		fatorList5.add(0);			// Fator para a faixa 3
		fatorList5.add(0);			// Fator para a faixa 4
		fatorList5.add(0);			// Fator para a faixa 5
		aa5.setFator(fatorList5);
		
		ApostaAcerto aa6 = new ApostaAcerto();
		List<Integer> fatorList6 = new ArrayList<Integer>();
		
		aa6.setKey("1614");
		fatorList6.add(0);  		// Fator para a faixa 1
		fatorList6.add(2);			// Fator para a faixa 2
		fatorList6.add(14);			// Fator para a faixa 3
		fatorList6.add(0);			// Fator para a faixa 4
		fatorList6.add(0);			// Fator para a faixa 5
		aa6.setFator(fatorList6);
		
		ApostaAcerto aa7 = new ApostaAcerto();
		List<Integer> fatorList7 = new ArrayList<Integer>();
		
		aa7.setKey("1714");
		fatorList7.add(0);  		// Fator para a faixa 1
		fatorList7.add(3);			// Fator para a faixa 2
		fatorList7.add(42);			// Fator para a faixa 3
		fatorList7.add(91);			// Fator para a faixa 4
		fatorList7.add(0);			// Fator para a faixa 5
		aa7.setFator(fatorList7);

		ApostaAcerto aa8 = new ApostaAcerto();
		List<Integer> fatorList8 = new ArrayList<Integer>();
		
		aa8.setKey("1814");
		fatorList8.add(0);  		// Fator para a faixa 1
		fatorList8.add(4);			// Fator para a faixa 2
		fatorList8.add(84);			// Fator para a faixa 3
		fatorList8.add(364);		// Fator para a faixa 4
		fatorList8.add(364);		// Fator para a faixa 5
		aa8.setFator(fatorList8);
		
		ApostaAcerto aa9 = new ApostaAcerto();
		List<Integer> fatorList9 = new ArrayList<Integer>();
		
		aa9.setKey("1513");
		fatorList9.add(0);  		// Fator para a faixa 1
		fatorList9.add(0);			// Fator para a faixa 2
		fatorList9.add(1);			// Fator para a faixa 3
		fatorList9.add(0);			// Fator para a faixa 4
		fatorList9.add(0);			// Fator para a faixa 5
		aa9.setFator(fatorList9);
		
		ApostaAcerto aa10 = new ApostaAcerto();
		List<Integer> fatorList10 = new ArrayList<Integer>();
		
		aa10.setKey("1613");
		fatorList10.add(0);  		// Fator para a faixa 1
		fatorList10.add(0);			// Fator para a faixa 2
		fatorList10.add(3);			// Fator para a faixa 3
		fatorList10.add(13);		// Fator para a faixa 4
		fatorList10.add(0);			// Fator para a faixa 5
		aa10.setFator(fatorList10);
		
		ApostaAcerto aa11 = new ApostaAcerto();
		List<Integer> fatorList11 = new ArrayList<Integer>();
		
		aa11.setKey("1713");
		fatorList11.add(0);  		// Fator para a faixa 1
		fatorList11.add(0);			// Fator para a faixa 2
		fatorList11.add(6);			// Fator para a faixa 3
		fatorList11.add(52);		// Fator para a faixa 4
		fatorList11.add(78);		// Fator para a faixa 5
		aa11.setFator(fatorList11);
		
		ApostaAcerto aa12 = new ApostaAcerto();
		List<Integer> fatorList12 = new ArrayList<Integer>();
		
		aa12.setKey("1813");
		fatorList12.add(0);  		// Fator para a faixa 1
		fatorList12.add(0);			// Fator para a faixa 2
		fatorList12.add(10);		// Fator para a faixa 3
		fatorList12.add(130);		// Fator para a faixa 4
		fatorList12.add(390);		// Fator para a faixa 5
		aa12.setFator(fatorList12);
		
		ApostaAcerto aa13 = new ApostaAcerto();
		List<Integer> fatorList13 = new ArrayList<Integer>();
		
		aa13.setKey("1512");
		fatorList13.add(0);  		// Fator para a faixa 1
		fatorList13.add(0);			// Fator para a faixa 2
		fatorList13.add(0);			// Fator para a faixa 3
		fatorList13.add(1);			// Fator para a faixa 4
		fatorList13.add(0);			// Fator para a faixa 5
		aa13.setFator(fatorList13);
		
		ApostaAcerto aa14 = new ApostaAcerto();
		List<Integer> fatorList14 = new ArrayList<Integer>();
		
		aa14.setKey("1612");
		fatorList14.add(0);  		// Fator para a faixa 1
		fatorList14.add(0);			// Fator para a faixa 2
		fatorList14.add(0);			// Fator para a faixa 3
		fatorList14.add(4);			// Fator para a faixa 4
		fatorList14.add(12);		// Fator para a faixa 5
		aa14.setFator(fatorList14);
		
		ApostaAcerto aa15 = new ApostaAcerto();
		List<Integer> fatorList15 = new ArrayList<Integer>();
		
		aa15.setKey("1712");
		fatorList15.add(0);  		// Fator para a faixa 1
		fatorList15.add(0);			// Fator para a faixa 2
		fatorList15.add(0);			// Fator para a faixa 3
		fatorList15.add(10);		// Fator para a faixa 4
		fatorList15.add(60);		// Fator para a faixa 5
		aa15.setFator(fatorList15);
		
		ApostaAcerto aa16 = new ApostaAcerto();
		List<Integer> fatorList16 = new ArrayList<Integer>();
		
		aa16.setKey("1812");
		fatorList16.add(0);  		// Fator para a faixa 1
		fatorList16.add(0);			// Fator para a faixa 2
		fatorList16.add(0);			// Fator para a faixa 3
		fatorList16.add(30);		// Fator para a faixa 4
		fatorList16.add(180);		// Fator para a faixa 5
		aa16.setFator(fatorList16);
		
		ApostaAcerto aa17 = new ApostaAcerto();
		List<Integer> fatorList17 = new ArrayList<Integer>();
		
		aa17.setKey("1511");
		fatorList17.add(0);  		// Fator para a faixa 1
		fatorList17.add(0);			// Fator para a faixa 2
		fatorList17.add(0);			// Fator para a faixa 3
		fatorList17.add(0);			// Fator para a faixa 4
		fatorList17.add(1);			// Fator para a faixa 5
		aa17.setFator(fatorList17);
	
		ApostaAcerto aa18 = new ApostaAcerto();
		List<Integer> fatorList18 = new ArrayList<Integer>();
		
		aa18.setKey("1611");
		fatorList18.add(0);  		// Fator para a faixa 1
		fatorList18.add(0);			// Fator para a faixa 2
		fatorList18.add(0);			// Fator para a faixa 3
		fatorList18.add(0);			// Fator para a faixa 4
		fatorList18.add(5);			// Fator para a faixa 5
		aa18.setFator(fatorList18);
		
		ApostaAcerto aa19 = new ApostaAcerto();
		List<Integer> fatorList19 = new ArrayList<Integer>();
		
		aa19.setKey("1711");
		fatorList19.add(0);  		// Fator para a faixa 1
		fatorList19.add(0);			// Fator para a faixa 2
		fatorList19.add(0);			// Fator para a faixa 3
		fatorList19.add(0);			// Fator para a faixa 4
		fatorList19.add(15);		// Fator para a faixa 5
		aa19.setFator(fatorList19);
		
		ApostaAcerto aa20 = new ApostaAcerto();
		List<Integer> fatorList20 = new ArrayList<Integer>();
		
		aa20.setKey("1811");
		fatorList20.add(0);  		// Fator para a faixa 1
		fatorList20.add(0);			// Fator para a faixa 2
		fatorList20.add(0);			// Fator para a faixa 3
		fatorList20.add(0);			// Fator para a faixa 4
		fatorList20.add(35);		// Fator para a faixa 5
		aa20.setFator(fatorList20);
		
		apostaAcertoRepository.saveAll(Arrays.asList(aa1, aa2, aa3, aa4, aa5, aa6, aa7, 
				aa8, aa9, aa10, aa11, aa12, aa13, aa14, aa15, aa16, aa17, aa18, aa19, aa20));
		
		// preparar Classe ValorAposta
		
		valorApostaRepository.deleteAll();
		
		ValorAposta valorAposta = new ValorAposta(null, "15", 2.0);
		
		valorApostaRepository.insert(valorAposta);
		
		valorAposta = new ValorAposta(null, "16", 32.0);
		
		valorApostaRepository.insert(valorAposta);
		
		valorAposta = new ValorAposta(null, "17", 272.0);
		
		valorApostaRepository.insert(valorAposta);
		
		valorAposta = new ValorAposta(null, "18", 1632.0);
		
		valorApostaRepository.insert(valorAposta);
		*/
	}
}
