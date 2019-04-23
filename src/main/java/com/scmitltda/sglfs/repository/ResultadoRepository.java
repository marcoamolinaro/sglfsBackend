package com.scmitltda.sglfs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scmitltda.sglfs.domain.Resultado;

@Repository
public interface ResultadoRepository extends MongoRepository<Resultado, String>{
	
	@Transactional(readOnly = true)
	public Resultado findByNumero(String numero);
	
}
