package com.nayara.os.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import com.nayara.os.domain.Technique;
import com.nayara.os.dtos.TechniqueDTO;
import com.nayara.os.services.TechniqueService;

@RestController
@RequestMapping(value = "/technique")
public class TechniqueResource {
	@Autowired
	private TechniqueService service;
	
	@ApiOperation(value = "Insere uma Avaliação", notes = "Insere uma Avaliação", response = Technique.class )
	@GetMapping(value="/{id}")
	public ResponseEntity<TechniqueDTO> findById(@PathVariable Integer id) {
		
		Technique obj = service.findById(id);
		
		TechniqueDTO objDTO = new TechniqueDTO(obj);
		
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<Technique>> findAll() {
		List<Technique> obj = service.findAll();
		
		return ResponseEntity.ok().body(obj);
	}
}
