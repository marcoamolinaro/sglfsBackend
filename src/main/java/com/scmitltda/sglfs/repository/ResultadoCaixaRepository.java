package com.scmitltda.sglfs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scmitltda.sglfs.domain.ResultadoCaixa;

@Repository
public interface ResultadoCaixaRepository extends MongoRepository<ResultadoCaixa, String>{
	
	@Transactional(readOnly = true)
	public ResultadoCaixa findByNumero(String numero);
	
}
