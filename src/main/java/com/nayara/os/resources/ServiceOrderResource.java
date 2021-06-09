package com.nayara.os.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nayara.os.domain.Client;
import com.nayara.os.domain.ServiceOrder;
import com.nayara.os.dtos.ServiceOrderDTO;
import com.nayara.os.services.ServiceOrderService;

@RestController
@RequestMapping(value = "/serviceorder")
public class ServiceOrderResource {

	@Autowired
	ServiceOrderService service;
	
	@GetMapping
	public ResponseEntity<List<ServiceOrder>> findAll() {
		List<ServiceOrder> obj = service.findAll();
		
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ServiceOrderDTO> findById(@PathVariable Integer id) {
		ServiceOrderDTO os = new ServiceOrderDTO(service.findById(id));
		
		return ResponseEntity.ok().body(os);
	}
	
}
