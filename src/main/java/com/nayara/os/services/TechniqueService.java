package com.nayara.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nayara.os.domain.Technique;
import com.nayara.os.dtos.TechniqueDTO;
import com.nayara.os.repositories.TechniqueRepository;
import com.nayara.os.services.exceptions.DataIntegratyViolationException;
import com.nayara.os.services.exceptions.ObjectNotFoundException;

@Service
public class TechniqueService {
	
	@Autowired
	private TechniqueRepository repository;
	
	public Technique findById(Integer id) {
		Optional<Technique> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontado! Id: " + id + ", Tipo: " + Technique.class.getName()));
	}
	
	public List<Technique> findAll() {
		List<Technique> tech = repository.findAll();
		return tech;
	}

	public Technique create(@Valid TechniqueDTO objDTO) {
		//log.info("SERVICE - CRIANDO NOVO TÉCNICO");
		 if (findByCPF(objDTO) != null) {
		 	throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		 }

		Technique newTec = new Technique(null, objDTO.getName(), objDTO.getCpf(), objDTO.getPhone());

		return repository.save(newTec);
	}

	public Technique update(Integer id, @Valid TechniqueDTO objDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	
	private Technique findByCPF(TechniqueDTO objDTO) {
     //log.info("SERVICE - ANALIZANDO SE O CPF ESTÁ CADASTRADO NO BANCO");
		Technique obj = repository.findByCPF(objDTO.getCpf());
	 	if (obj != null) {
	 		return obj;
	 	}
	 	return null;
	 }
}
