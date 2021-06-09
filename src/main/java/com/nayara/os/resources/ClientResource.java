package com.nayara.os.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nayara.os.domain.Client;
import com.nayara.os.domain.Technique;
import com.nayara.os.dtos.ClientDTO;
import com.nayara.os.dtos.TechniqueDTO;
import com.nayara.os.services.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {
	
	@Autowired
	ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> obj = service.findAll();
		
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping	
	public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO objDTO) {
		Client newObj = service.create(objDTO);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		
		return ResponseEntity.created(uri).build();
	}


}
