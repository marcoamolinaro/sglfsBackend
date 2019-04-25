package com.scmitltda.sglfs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.scmitltda.sglfs.domain.Aposta;

@Repository
public interface ApostaRepository extends MongoRepository<Aposta, String>{	
}
