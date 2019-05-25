package com.scmitltda.sglfs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scmitltda.sglfs.domain.ValorAposta;

@Repository
public interface ValorApostaRepository extends MongoRepository<ValorAposta, String>{
	@Transactional(readOnly = true)
	public ValorAposta findByQtdAposta(String qtdAposta);
}
