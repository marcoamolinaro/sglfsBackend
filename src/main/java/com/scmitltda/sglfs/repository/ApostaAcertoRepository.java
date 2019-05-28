package com.scmitltda.sglfs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scmitltda.sglfs.domain.ApostaAcerto;

@Repository
public interface ApostaAcertoRepository extends MongoRepository<ApostaAcerto, String>{
	@Transactional(readOnly = true)
	public ApostaAcerto findByKey(String key);
}
