package com.nayara.os.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nayara.os.domain.ServiceOrder;
import com.nayara.os.repositories.ServiceOrderRepository;
import com.nayara.os.services.exceptions.ObjectNotFoundException;

@Service
public class ServiceOrderService {
	
	@Autowired
	ServiceOrderRepository service;

	public List<ServiceOrder> findAll() {
		List<ServiceOrder> os = service.findAll();
		return os;
	}

	public ServiceOrder findById(Integer id) {
		Optional<ServiceOrder> obj = service.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Ordem de Serviço não localizada pelo id: " + id + "Tipo :" + ServiceOrder.class.getName()));
		
	}

}
