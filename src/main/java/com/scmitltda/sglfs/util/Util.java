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
	
	public static Double getValorAposta(Integer qtde_dezenas) {
		double valor = 0;
		switch (qtde_dezenas) {
		case 15:
			valor = 2;
			break;
		case 16:
			valor = 32;
			break;
		case 17:
			valor = 272;
			break;
		case 18:
			valor = 1632;
			break;
		}
		return valor;
	}

}
