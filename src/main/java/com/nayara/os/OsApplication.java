package com.nayara.os;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nayara.os.domain.Client;
import com.nayara.os.domain.ServiceOrder;
import com.nayara.os.domain.Technique;
import com.nayara.os.domain.enums.Priority;
import com.nayara.os.domain.enums.Status;
import com.nayara.os.repositories.ClientRepository;
import com.nayara.os.repositories.ServiceOrderRepository;
import com.nayara.os.repositories.TechniqueRepository;

@SpringBootApplication
public class OsApplication implements CommandLineRunner{
	
	@Autowired
	private TechniqueRepository techniqueRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ServiceOrderRepository serviceOrderRepository;


	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Technique tech = new Technique(null, "Nayara Ferreira", "745.465.930-66", "(62)9 8590-2732");
		Client cli = new Client(null, "Meu Cliente", "735.270.700-01", "(62)9 8590-2732");
		ServiceOrder os = new ServiceOrder(null,  Priority.AVERAGE, "Primeira OS", Status.INPROGRESS, tech, cli);
		
		tech.getList().add(os);
		cli.getList().add(os);
		
		techniqueRepository.saveAll(Arrays.asList(tech));
		clientRepository.saveAll(Arrays.asList(cli));
		serviceOrderRepository.saveAll(Arrays.asList(os));
	}

}
