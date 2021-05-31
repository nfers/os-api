package com.nayara.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nayara.os.domain.Technique;

@Repository
public interface TechniqueRepository extends JpaRepository<Technique, Integer>{
	
    
	@Query("SELECT obj FROM technique obj WHERE obj.cpf =:cpf")
	Technique findByCPF(@Param("cpf") String cpf);
}
