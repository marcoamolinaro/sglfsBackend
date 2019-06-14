package com.scmitltda.sglfs.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.scmitltda.sglfs.domain.ResultadoCaixa;

public class Util {
			
	private static Integer generateDezena() {
		Random random = new Random();
		return random.nextInt(25)+1;
	}
	
	public static List<Integer> generateAposta(Integer qtde_dezenas) {

		List<Integer> dezenas = new ArrayList<Integer>();
		Integer dezena = 0;
		Integer i = 1;
		
		while (i <= qtde_dezenas) {
			dezena = generateDezena();
			if (!dezenas.contains(dezena)) {
				i++;
				dezenas.add(dezena);
			}			
		}

		return dezenas;
	}
	
	public static Boolean validade13Matches(List<Integer> dezenasGeradas, List<ResultadoCaixa> resultadoCaixas) {
		Boolean valid = true;
		Integer qtde_matches = 0;
		Integer qtde_sorteios_13_pontos = 0;

		for (ResultadoCaixa resultadoCaixa: resultadoCaixas) {
			//System.out.println("Sorteio         " + resultadoCaixa.getSorteio());
			//System.out.println("Dezenas Geradas " + dezenasGeradas);
			for (int k = 0; k < dezenasGeradas.size(); k++) {
				Integer d = dezenasGeradas.get(k);
				if (resultadoCaixa.getSorteio().contains(d)) {
					qtde_matches++;
				}
			}
			if (qtde_matches >= 13) {
				System.out.println("qtde_matches [" + qtde_matches + "]");
				qtde_sorteios_13_pontos++;
			}
			if (qtde_sorteios_13_pontos > 0) {
				valid = false;
				break;
			}
			qtde_matches = 0;
		}
		
		//System.out.println("qtde_sorteios_13_pontos [" + qtde_sorteios_13_pontos + "]");
		//System.out.println("Valido " + valid);

		return valid;
	}
	
	public static Integer verifyBetting(List<Integer> dezenasApostadas, List<Integer> dezenasSorteadas) {			
		Integer acertos = 0;
		
		for (Integer dezenaApostada: dezenasApostadas) {	
			if (dezenasSorteadas.contains(dezenaApostada)) {
				acertos++;
			}
		}
		
		return acertos; 
	}
}
