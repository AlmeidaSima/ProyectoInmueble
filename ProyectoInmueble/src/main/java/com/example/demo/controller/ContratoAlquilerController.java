package com.example.demo.controller;

import java.math.BigDecimal;
import org.springframework.core.io.ByteArrayResource;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.*;
import com.example.demo.service.*;

@Controller
public class ContratoAlquilerController {

	@Autowired
	private ContratoAlquilerService contratoAlquilerService;

	@Autowired
	private InmuebleService inmuebleService; 

	@GetMapping("/inmueble/alquilar/{id}")
	public String mostrarFormularioAlquiler(@PathVariable("id") Integer idInmueble, Model model) {
		Inmueble inmueble = inmuebleService.getInmuebleById(idInmueble);
		model.addAttribute("inmueble", inmueble); 
		return "alquilar"; 
	}
	@PostMapping("/inmueble/alquilar")
	public String alquilarInmueble(
	    @RequestParam(name = "idInmueble") Integer idInmueble,
	    @RequestParam(name = "fecIni") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) java.time.LocalDate fecIni,
	    @RequestParam(name = "fecFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) java.time.LocalDate fecFin,
	    Model model) {

	    java.sql.Date sqlFecIni = java.sql.Date.valueOf(fecIni);
	    java.sql.Date sqlFecFin = java.sql.Date.valueOf(fecFin);

	    Inmueble inmueble = inmuebleService.getInmuebleById(idInmueble);
	    if (inmueble == null) {
	        return "redirect:/error";
	    }

	    inmueble.setInmuEstado("No disponible");
	    inmuebleService.saveInmueble(inmueble);

	    ContratoAlquiler contrato = contratoAlquilerService.guardarContratoAlquiler(idInmueble, sqlFecIni, sqlFecFin, inmueble.getInmuPrecio());

	    model.addAttribute("inmueble", inmueble.getInmuTitulo());
	    model.addAttribute("tipo", inmueble.getInmuTipo());
	    model.addAttribute("departamento", inmueble.getInmuDepart());
	    model.addAttribute("ciudad", inmueble.getInmuCiudad());
	    model.addAttribute("direccion", inmueble.getInmuDireccion());
	    model.addAttribute("fechaInicio", sqlFecIni);
	    model.addAttribute("fechaFin", sqlFecFin);
	    model.addAttribute("costoTotal", contrato.getAlqCosto());

	    return "boleta";
	}

	
	



}
