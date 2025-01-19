package com.example.demo.service;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demo.entity.ContratoAlquiler;

public interface ContratoAlquilerService {

	ContratoAlquiler guardarContratoAlquiler(Integer idInmueble, Date fechaInicio, Date fechaFin, java.math.BigDecimal costo);

}
