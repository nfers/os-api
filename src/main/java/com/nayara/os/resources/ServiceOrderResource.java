package com.nayara.os.resources;

import java.util.List;
import java.net.URI;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nayara.os.dtos.ServiceOrderDTO;
import com.nayara.os.services.ServiceOrderService;

@RestController
@RequestMapping(value = "/serviceorder")
public class ServiceOrderResource {

	@Autowired
	ServiceOrderService service;
	
	@GetMapping
	public ResponseEntity<List<ServiceOrderDTO>> findAll() {
		List<ServiceOrderDTO> list = service.findAll()
				.stream()
				.map(obj -> new ServiceOrderDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ServiceOrderDTO> findById(@PathVariable Integer id) {
		ServiceOrderDTO os = new ServiceOrderDTO(service.findById(id));
		
		return ResponseEntity.ok().body(os);
	}

	
	@PostMapping
	public ResponseEntity<ServiceOrderDTO> createServiceOrder(@Valid @RequestBody ServiceOrderDTO obj) {
		obj = new ServiceOrderDTO(service.create(obj));
		
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<ServiceOrderDTO> update(@Valid @RequestBody ServiceOrderDTO obj) {
		obj = new ServiceOrderDTO(service.update(obj));
		
		return ResponseEntity.ok().body(obj);
	}
	
}
