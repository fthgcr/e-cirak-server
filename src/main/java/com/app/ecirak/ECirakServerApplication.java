package com.app.ecirak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.app.ecirak.entity")
@EnableJpaRepositories(basePackages = "com.app.ecirak.repository")
public class ECirakServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECirakServerApplication.class, args);
	}

	
}
