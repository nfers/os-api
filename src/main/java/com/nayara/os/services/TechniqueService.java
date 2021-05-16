package com.nayara.os.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nayara.os.domain.Technique;
import com.nayara.os.repositories.TechniqueRepository;

@Service
public class TechniqueService {
	
	@Autowired
	private TechniqueRepository repository;
	
	public Technique findById(Integer id) {
		Optional<Technique> obj = repository.findById(id);
		
		return obj.orElse(null);
	}
	
	public List<Technique> findAll() {
		List<Technique> tech = repository.findAll();
		return tech;
	}
}
