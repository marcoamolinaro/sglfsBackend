package com.scmitltda.sglfs.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scmitltda.sglfs.domain.Volante;

@Repository
public interface VolanteRepository extends MongoRepository<Volante, String>{
	@Transactional(readOnly = true)
	public List<Volante> findByNumero(String numero);
}
