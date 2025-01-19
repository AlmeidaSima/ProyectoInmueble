package com.example.demo.service.imp;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

public class PagoServiceImpl implements PagoService{
	@Autowired
    private PagoRepository pagoRepository;

    @Override
    public Pago calcularPago(Integer idAlquiler, BigDecimal costo, String tipoInmueble) {
        Pago pago = new Pago();
        pago.setIdAlquiler(idAlquiler);
        pago.setPagfecPag(new java.sql.Date(new Date().getTime()));
        pago.setPagCosto(costo);

        BigDecimal descuento = BigDecimal.ZERO;
        BigDecimal costoMantenimiento = BigDecimal.ZERO;

        switch (tipoInmueble) {
            case "Casa":
                descuento = costo.multiply(BigDecimal.valueOf(0.10));
                costoMantenimiento = BigDecimal.valueOf(25);
                break;
            case "Departamento":
                descuento = costo.multiply(BigDecimal.valueOf(0.05));
                costoMantenimiento = BigDecimal.valueOf(30);
                break;
            case "Local":
                descuento = costo.multiply(BigDecimal.valueOf(0.03));
                costoMantenimiento = BigDecimal.valueOf(40);
                break;
        }

        pago.setPagDsct(descuento);
        pago.setPagCosMan(costoMantenimiento);
        pago.setPagTotal(costo.subtract(descuento).add(costoMantenimiento));
        return pago;
    }

    @Override
    public Pago registrarPago(Pago pago) {
        return pagoRepository.save(pago);
    }
}
