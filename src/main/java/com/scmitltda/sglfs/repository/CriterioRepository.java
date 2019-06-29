package com.scmitltda.sglfs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scmitltda.sglfs.domain.Criterio;

@Repository
public interface CriterioRepository extends MongoRepository<Criterio, String>{
	@Transactional(readOnly = true)
	public Criterio findByName(String name);
}
