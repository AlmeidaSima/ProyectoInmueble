package com.example.demo.service;

import java.math.BigDecimal;

import com.example.demo.entity.Pago;

public interface PagoService {
	Pago calcularPago(Integer idAlquiler, BigDecimal costo, String tipoInmueble);
    Pago registrarPago(Pago pago);
}
