package com.nayara.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nayara.os.domain.Client;
import com.nayara.os.domain.ServiceOrder;
import com.nayara.os.domain.Technique;
import com.nayara.os.domain.enums.Priority;
import com.nayara.os.domain.enums.Status;
import com.nayara.os.dtos.ServiceOrderDTO;
import com.nayara.os.repositories.ServiceOrderRepository;
import com.nayara.os.services.exceptions.ObjectNotFoundException;

@Service
public class ServiceOrderService {
	
	@Autowired
	ServiceOrderRepository service;
	
	@Autowired
	TechniqueService tec;

	@Autowired
	ClientService cli;
	
	public List<ServiceOrder> findAll() {
		List<ServiceOrder> os = service.findAll();
		return os;
	}

	public ServiceOrder findById(Integer id) {
		Optional<ServiceOrder> obj = service.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Ordem de Serviço não localizada pelo id: " + id + "Tipo :" + ServiceOrder.class.getName()));
		
	}

	public ServiceOrder create(@Valid ServiceOrderDTO obj) {
		return fromDTO(obj);
	}
	
	private ServiceOrder fromDTO(ServiceOrderDTO obj) {
	 ServiceOrder newOs = new ServiceOrder();
	 
	 newOs.setId(obj.getId());
	 newOs.setObeservations(obj.getObeservations());
	 newOs.setPriority(Priority.toEnum(obj.getId()));
	 newOs.setStatus(Status.toEnum(obj.getId()));
	 	 
	 Technique tecId = tec.findById(obj.getTechnique());
	 newOs.settechnique(tecId);
	 
	 Client cliId = cli.findById1(obj.getClient());	 
	 newOs.setClient(cliId);

	 service.save(newOs);
	
	 return service.save(newOs);
	
	}

	public ServiceOrder update(@Valid ServiceOrderDTO obj) {
		findById(obj.getId());
				
		return fromDTO(obj);
	}

}
