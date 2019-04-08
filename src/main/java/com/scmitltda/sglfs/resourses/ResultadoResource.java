package com.scmitltda.sglfs.resourses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scmitltda.sglfs.domain.Resultado;

@RestController
@RequestMapping(value="/resultados")
public class ResultadoResource {
	
	@GetMapping
	public ResponseEntity<List<Resultado>> findAll() {
		
		Resultado r1 = new Resultado("1", "1", "08-04-2019",false, 0.0, 1000000.00, "10-04-2019");
		Resultado r2 = new Resultado("1", "2", "10-04-2019",true, 1000000.30, 2000000.30, "12-04-2019");
		Resultado r3 = new Resultado("1", "3", "12-04-2019",false, 0.0, 1000000.00, "14-04-2019");
		
		List<Resultado> resultados = new ArrayList<Resultado>();
		resultados.addAll(Arrays.asList(r1, r2, r3));
		
		return ResponseEntity.ok().body(resultados);
	}
	
	

}
