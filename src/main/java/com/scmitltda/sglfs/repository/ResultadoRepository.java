package com.scmitltda.sglfs.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.scmitltda.sglfs.domain.Resultado;

@Repository
public interface ResultadoRepository extends MongoRepository<Resultado, String>{
	
	public List<Resultado> findByNumero(String numero);
	
}
