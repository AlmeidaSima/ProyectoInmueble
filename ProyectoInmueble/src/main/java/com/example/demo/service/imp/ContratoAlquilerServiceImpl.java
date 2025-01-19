package com.example.demo.service.imp;

import com.example.demo.service.ContratoAlquilerService;
import com.example.demo.service.InmuebleService;
import com.example.demo.entity.ContratoAlquiler;
import com.example.demo.entity.Inmueble;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.ContratoAlquilerRepository;
import com.example.demo.repository.InmuebleRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;

@Service
public class ContratoAlquilerServiceImpl implements ContratoAlquilerService {

	 @Autowired
	    private ContratoAlquilerRepository contratoAlquilerRepository;

	    @Autowired
	    private InmuebleService inmuebleService;

	    @Override
	    public ContratoAlquiler guardarContratoAlquiler(Integer idInmueble, Date fechaInicio, Date fechaFin, java.math.BigDecimal costo) {
	        // Obtener el inmueble
	        Inmueble inmueble = inmuebleService.getInmuebleById(idInmueble);
	        if (inmueble == null) {
	            throw new IllegalArgumentException("El inmueble no existe.");
	        }

	        // Crear el contrato de alquiler
	        ContratoAlquiler contratoAlquiler = new ContratoAlquiler();
	        contratoAlquiler.setInmueble(inmueble);
	        contratoAlquiler.setAlqFecIni(new java.sql.Date(fechaInicio.getTime()));
	        contratoAlquiler.setAlqFechFin(new java.sql.Date(fechaFin.getTime()));
	        contratoAlquiler.setAlqCosto(costo);

	        // Guardar el contrato en la base de datos
	        return contratoAlquilerRepository.save(contratoAlquiler);
	    }
}
