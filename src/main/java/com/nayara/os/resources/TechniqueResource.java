package com.nayara.os.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;

import com.nayara.os.domain.Technique;
import com.nayara.os.dtos.TechniqueDTO;
import com.nayara.os.services.TechniqueService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/technique")
public class TechniqueResource {

	Logger log = LoggerFactory.getLogger(TechniqueService.class);


	@Autowired
	private TechniqueService service;
	
	@ApiOperation(value = "Busca Técnico por ID", notes = "Busca Técnico por ID", response = Technique.class )
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

	@PostMapping	
	public ResponseEntity<TechniqueDTO> create(@Valid @RequestBody TechniqueDTO objDTO) {
		log.info("RESOURCE - CRIANDO NOVO TÉCNICO");
		Technique newObj = service.create(objDTO);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		log.info("RESOURCE - RETORNANDO RESPOSTA PARA REQUISIÇÃO " + newObj.getId());
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TechniqueDTO> update(@PathVariable Integer id, @Valid @RequestBody TechniqueDTO objDTO) {

		TechniqueDTO newObj = new TechniqueDTO(service.update(id, objDTO));

		return ResponseEntity.ok().body(newObj);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		log.info("RESOURCE - DELETANDO TÉCNICO");

		service.delete(id);
		
		log.info("RESOURCE - RETORNANDO RESPOSTA PARA REQUISIÇÃO");
		return ResponseEntity.noContent().build();
	}

}
