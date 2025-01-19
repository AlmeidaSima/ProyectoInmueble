package com.example.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Pago;
import com.example.demo.service.PagoService;
@Controller
@RequestMapping("/pagos")
public class PagoController {
	@Autowired
    private PagoService pagoService;

    @GetMapping("/nuevo")
    public String mostrarFormularioPago(@RequestParam Integer idAlquiler,
                                        @RequestParam BigDecimal costo,
                                        @RequestParam String tipoInmueble,
                                        Model model) {
        Pago pago = pagoService.calcularPago(idAlquiler, costo, tipoInmueble);
        model.addAttribute("pago", pago);
        return "pagos";
    }

    @PostMapping("/registrar")
    public String registrarPago(@ModelAttribute Pago pago) {
        pagoService.registrarPago(pago);
        return "redirect:/confirmacion"; // Página de confirmación
    }

}
