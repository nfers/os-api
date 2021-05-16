package com.nayara.os.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nayara.os.domain.Technique;
import com.nayara.os.services.TechniqueService;

@RestController
@RequestMapping(value = "/technique")
public class TechniqueResource {
	@Autowired
	private TechniqueService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Technique> findById(@PathVariable Integer id) {
		
		Technique obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Technique>> findAll() {
		List<Technique> obj = service.findAll();
		
		return ResponseEntity.ok().body(obj);
	}
}
