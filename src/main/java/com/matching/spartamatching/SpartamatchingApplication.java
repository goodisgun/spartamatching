package com.matching.spartamatching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpartamatchingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpartamatchingApplication.class, args);
	}

}
