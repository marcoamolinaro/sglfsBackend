package com.scmitltda.sglfs.resourses;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/resultados")
public class ResultadoResource {
	
	@GetMapping
	public String listar() {
		return "REST está funcionando";
	}

}
