package com.example.demo.service;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demo.entity.ContratoAlquiler;
import com.example.demo.entity.Inmueble;

public interface ContratoAlquilerService {

	ContratoAlquiler guardarContratoAlquiler(Integer idInmueble, Date fechaInicio, Date fechaFin, java.math.BigDecimal costo);
	Inmueble findInmuebleById(Integer idAlquiler);
    
    Date findFechaInicioById(Integer idAlquiler);
    
    Date findFechaFinById(Integer idAlquiler);
    
    ContratoAlquiler obtenerContratoAlquilerPorId(Integer id);

}
