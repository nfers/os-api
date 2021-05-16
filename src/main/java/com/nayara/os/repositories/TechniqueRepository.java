package com.nayara.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nayara.os.domain.Technique;

@Repository
public interface TechniqueRepository extends JpaRepository<Technique, Integer>{
	
}
