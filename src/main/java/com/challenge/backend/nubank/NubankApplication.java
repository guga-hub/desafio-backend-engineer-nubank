package com.challenge.backend.nubank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NubankApplication {

	public static void main(String[] args) {
		SpringApplication.run(NubankApplication.class, args);
	}

}
