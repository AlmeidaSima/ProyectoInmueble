package com.example.demo.service;

import com.example.demo.entity.ContratoAlquiler;
import com.example.demo.entity.Recibo;

public interface ReciboService {
	 Recibo guardarRecibo(Recibo recibo);
	    void crearReciboParaContrato(ContratoAlquiler contrato);


}
