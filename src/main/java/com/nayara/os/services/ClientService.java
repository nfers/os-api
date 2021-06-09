package com.nayara.os.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.nayara.os.domain.Client;
import com.nayara.os.domain.Person;
import com.nayara.os.domain.Technique;
import com.nayara.os.dtos.ClientDTO;
import com.nayara.os.dtos.TechniqueDTO;
import com.nayara.os.repositories.ClientRepository;
import com.nayara.os.services.exceptions.DataIntegratyViolationException;

public class ClientService {

	@Autowired
	ClientRepository _client;
	
	public List<Client> findAll() {
		List<Client> cli = _client.findAll();
		return cli;
	}

	public Client create(@Valid ClientDTO objDTO) {
		if (findByCPF(objDTO) != null) {
		 	throw new DataIntegratyViolationException("CPF do cliente já cadastrado na base de dados!");
		 }

		Client newcli = new Client(null, objDTO.getName(), objDTO.getCpf(), objDTO.getPhone());

		return _client.save(newcli);
	}

	private Person findByCPF(ClientDTO objDTO) {
			Person obj = _client.findByCPF(objDTO.getCpf());
		 	if (obj != null) {
		 		return obj;
		 	}
		 	return null;
		 }

}
