package com.example.demo.controller;
import com.example.demo.entity.Inmueble;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.InmuebleService;

@Controller
@RequestMapping("/inmueble")
public class InmuebleController {

	
	@Autowired
	@Qualifier("inmuebleservice")
	private InmuebleService inmuebleservice;
	
	@GetMapping("/")
	public String redirecToInmuebleList() {
		return "redirect:/inmueble/listado";
	}
	
	@GetMapping("/listado")
	public ModelAndView listAllInmuebles() {
		ModelAndView mav = new ModelAndView("listado");
		mav.addObject("inmuebles", inmuebleservice.listAllInmuebles());
		mav.addObject("inmueble", new Inmueble());
		return mav;

	}
	@GetMapping("/principal")
    public String mostrarPrincipal() {
        return "Principal"; 
    }
	@GetMapping("/login")
    public String mostrarLogin() {
        return "login"; 
    }
	
}
