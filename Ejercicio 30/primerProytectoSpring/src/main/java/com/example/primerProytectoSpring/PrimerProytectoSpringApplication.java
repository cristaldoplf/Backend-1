package com.example.primerProytectoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class PrimerProytectoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimerProytectoSpringApplication.class, args);
	}

	@GetMapping
	public String primerProyecto(){
		return "Primer proyecto en Spring";
	}

}
