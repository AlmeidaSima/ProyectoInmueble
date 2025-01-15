package com.example.demo;

<<<<<<< HEAD
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.service.InmuebleService;
=======
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
>>>>>>> 6143d419c3300bd5b5b292ad0f51fcdfcdb1deec

@SpringBootApplication
public class ProyectoInmuebleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoInmuebleApplication.class, args);
	}

<<<<<<< HEAD
	@Bean
	public CommandLineRunner pruebaConsola(InmuebleService inmuebleservice) {
	    return (args) -> {
	        // Llamamos a la prueba de búsqueda de inmuebles
	        inmuebleservice.pruebaBusquedaInmuebles("Pucall"); // Cambia "Pucall" por cualquier ciudad que quieras probar
	    };
	}

=======
>>>>>>> 6143d419c3300bd5b5b292ad0f51fcdfcdb1deec
}
