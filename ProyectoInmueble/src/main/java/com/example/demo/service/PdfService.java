package com.example.demo.service;

import com.example.demo.entity.ContratoAlquiler;

public interface PdfService {
    
    byte[] generarPDF(ContratoAlquiler contratoAlquiler) throws Exception;
}