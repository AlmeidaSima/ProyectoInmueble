package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.service.InmuebleService;

@SpringBootApplication
public class ProyectoInmuebleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoInmuebleApplication.class, args);
	}

	@Bean
	public CommandLineRunner pruebaConsola(InmuebleService inmuebleservice) {
	    return (args) -> {
	        inmuebleservice.pruebaBusquedaInmuebles("Tru");
	    };
	}
	

}
