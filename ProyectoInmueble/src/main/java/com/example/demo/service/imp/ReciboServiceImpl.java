package com.example.demo.service.imp;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Recibo;
import com.example.demo.repository.ReciboRepository;
import com.example.demo.service.ReciboService;
import com.example.demo.service.imp.*;
import com.example.demo.entity.ContratoAlquiler;
import com.example.demo.entity.Inmueble;
import com.example.demo.repository.ContratoAlquilerRepository;
import com.example.demo.service.ContratoAlquilerService;

@Service
public class ReciboServiceImpl implements ReciboService{
	 @Autowired
	    private ReciboRepository reciboRepository;

	    @Override
	    public Recibo guardarRecibo(Recibo recibo) {
	        return reciboRepository.save(recibo);
	    }

	    @Override
	    public void crearReciboParaContrato(ContratoAlquiler contrato) {
	        Recibo recibo = new Recibo();
	        recibo.setContratoAlquiler(contrato);
	        recibo.setRecFecha(new Date(System.currentTimeMillis()));
	        recibo.setRecMonto(contrato.getAlqCosto());

	        // Calcular descuento y mantenimiento
	        BigDecimal descuento = calcularDescuento(contrato.getInmueble().getInmuTipo(), contrato.getAlqCosto());
	        BigDecimal mantenimiento = calcularMantenimiento(contrato.getInmueble().getInmuTipo());

	        recibo.setRecDscto(descuento);
	        recibo.setRecMan(mantenimiento);
	        recibo.setRecTotal(contrato.getAlqCosto().subtract(descuento).add(mantenimiento));

	        // Guardar el recibo
	        guardarRecibo(recibo);
	    }

	    private BigDecimal calcularDescuento(String tipo, BigDecimal monto) {
	        switch (tipo.toLowerCase()) {
	            case "casa":
	                return monto.multiply(new BigDecimal("0.05"));
	            case "departamento":
	                return monto.multiply(new BigDecimal("0.04"));
	            case "local":
	                return monto.multiply(new BigDecimal("0.03"));
	            default:
	                return BigDecimal.ZERO;
	        }
	    }

	    private BigDecimal calcularMantenimiento(String tipo) {
	        switch (tipo.toLowerCase()) {
	            case "casa":
	                return new BigDecimal("30");
	            case "departamento":
	                return new BigDecimal("40");
	            case "local":
	                return new BigDecimal("50");
	            default:
	                return BigDecimal.ZERO;
	        }
	    }

		
}
