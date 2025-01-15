package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;

@Controller
@RequestMapping("/user")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioservice")
	private UsuarioService usuarioservice;

	@GetMapping("/")
	public String redirectToList() {
		return "redirect:/user/list";
	}

	@GetMapping("/list")
	public ModelAndView listAllUsers() {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("usuarios", usuarioservice.listAllUsers());
		mav.addObject("usuario", new Usuario()); 
		return mav;
	}

	@GetMapping("/Agregar")
	public ModelAndView addUserForm() {
		ModelAndView mav = new ModelAndView("Agregar");
		mav.addObject("usuario", new Usuario()); 
		return mav;
	}

	@PostMapping("/Agregar")
	public String addUser(@ModelAttribute("usuario") Usuario usuario) {
		usuarioservice.addUser(usuario); 
		return "redirect:/user/list"; 
	}

	@GetMapping("/edit/{id}")
	public ModelAndView editUser(@PathVariable("id") int id) {
		Usuario usuario = usuarioservice.getUserById(id);
		ModelAndView mav = new ModelAndView("edit");
		mav.addObject("user", usuario);
		return mav;
	}

	@PostMapping("/update")
	public String updateUser(@ModelAttribute("user") Usuario usuario) {
		usuarioservice.updateUser(usuario);
		return "redirect:/user/list";
	}

	@GetMapping("/delete/{id}") 
	public String deleteUser(@PathVariable("id") int id) {
		usuarioservice.deleteUser(id);
		return "redirect:/user/list";
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
