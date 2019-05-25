package com.scmitltda.sglfs.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {
		
	private static Integer generateDezena() {
		Random random = new Random();
		return random.nextInt(25);
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
