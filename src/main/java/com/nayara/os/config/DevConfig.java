package com.nayara.os.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nayara.os.services.DbService;


@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DbService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;
	
	@Bean
	public void createInstanceDB() {
		
		if(ddl.equals("create")) {
			this.dbService.dbInstance();
		}
	}
}
