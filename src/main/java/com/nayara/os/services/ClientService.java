package com.nayara.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nayara.os.domain.Client;
import com.nayara.os.domain.Person;
import com.nayara.os.domain.Technique;
import com.nayara.os.dtos.ClientDTO;
import com.nayara.os.repositories.ClientRepository;
import com.nayara.os.services.exceptions.DataIntegratyViolationException;
import com.nayara.os.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	ClientRepository _client;

	public List<Client> findAll() {
		List<Client> cli = _client.findAll();
		return cli;
	}

	public Optional<Client> findById(Integer id) {
		return _client.findById(id);
	}

	public Client create(@Valid ClientDTO objDTO) {
		if (findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF do cliente já cadastrado na base de dados!");
		}

		Client newcli = new Client(null, objDTO.getName(), objDTO.getCpf(), objDTO.getPhone());

		return _client.save(newcli);
	}

	public void delete(Integer id) {
		Optional<Client> obj = findById(id);

		if (obj.isEmpty()) {
			throw new DataIntegratyViolationException("Pessoa possui Ordens de Serviço, não pode ser deletado!");
		}

		_client.deleteById(id);
	}

	private Person findByCPF(ClientDTO objDTO) {
		Person obj = _client.findByCPF(objDTO.getCpf());
		if (obj != null) {
			return obj;
		}
		return null;
	}

	public Client findById1(Integer id) {
		Optional<Client> obj = _client.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontado! Id: " + id + ", Tipo: " + Technique.class.getName()));
	}

	public Client update(Integer id, @Valid ClientDTO objDTO) {
		Client oldObj = findById1(id);

		if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}

		oldObj.setName(objDTO.getName());
		oldObj.setPhone(objDTO.getPhone());
		oldObj.setCpf(objDTO.getCpf());

		return _client.save(oldObj);
	}

}
