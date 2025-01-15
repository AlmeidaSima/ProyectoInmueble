package com.example.demo.controller;
import com.example.demo.entity.Inmueble;
import com.example.demo.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.service.InmuebleService;

import org.springframework.ui.Model;


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
	
	@GetMapping("/Agregar")
    public ModelAndView addInmuebleForm() {
        ModelAndView mav = new ModelAndView("Agregar");
        mav.addObject("inmueble", new Inmueble());
        return mav;
    }

    @PostMapping("/Agregar")
    public String addInmueble(@ModelAttribute("inmueble") Inmueble inmueble) {
        inmuebleservice.addInmueble(inmueble);
        return "redirect:/inmueble/listado";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editInmueble(@PathVariable("id") int id) {
        Inmueble inmueble = inmuebleservice.getInmuebleById(id);
        ModelAndView mav = new ModelAndView("editar");
        mav.addObject("inmueble", inmueble);
        return mav;
    }

    @PostMapping("/update")
    public String updateInmueble(@ModelAttribute("inmueble") Inmueble inmueble) {
        inmuebleservice.updateInmueble(inmueble);
        return "redirect:/inmueble/listado";
    }
    @GetMapping("/delete/{id}")
    public String deleteInmueble(@PathVariable("id") int id) {
        inmuebleservice.deleteInmueble(id);
        return "redirect:/inmueble/listado"; // Redirige a la lista después de eliminar
    }

	@GetMapping("/principal")
    public String mostrarPrincipal() {
        return "Principal"; 
    }
	@GetMapping("/login")
    public String mostrarLogin() {
        return "login"; 
    }
	@GetMapping("/contacto")
    public String mostrarContacto() {
        return "contacto"; 
    }
	@GetMapping("/nosotros")
    public String mostrarNosotros() {
        return "nosotros"; 
    }
	@GetMapping("/ver")
    public String mostrarVer() {
        return "inmuebleVer"; 
    }
	@GetMapping("/vistaInmuebles")
	public ModelAndView vistaInmuebles() {
	    ModelAndView mav = new ModelAndView("vistaInmuebles"); 
	    mav.addObject("inmuebles", inmuebleservice.listAllInmuebles());
	    return mav;
	}
	@GetMapping("/buscar")
	public String buscarInmuebles(@RequestParam String searchTerm, Model model) {
	    List<Inmueble> resultados = inmuebleservice.buscarInmuebles(searchTerm);
	    model.addAttribute("inmuebles", resultados);  
	    return "resultados";  
	}
	
	

}
