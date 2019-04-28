package com.scmitltda.sglfs.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scmitltda.sglfs.domain.Aposta;

@Repository
public interface ApostaRepository extends MongoRepository<Aposta, String>{
	@Transactional(readOnly = true)
	public List<Aposta> findByNumero(String numero);
}
