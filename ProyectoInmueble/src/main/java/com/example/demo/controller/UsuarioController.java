package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/inmueble/listadoUsu")
    public String listarUsuarios(ModelMap model) {
        List<Usuario> usuarios = usuarioService.getAllUsuarios(); 
        System.out.println("Usuarios recuperados: " + usuarios);  
        model.addAttribute("usuarios", usuarios); 
        return "listado-usuarios"; 
    }

    

    @GetMapping("/user/agregar")
    public String mostrarFormularioAgregar() {
        return "agregar-usuario"; 
    }

    @PostMapping("/user")
    public String guardarUsuario(Usuario usuario) {
        usuarioService.saveUsuario(usuario);
        return "redirect:/inmueble/listadoUsu"; 
    }
    @GetMapping("/user/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int id, ModelMap model) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        model.addAttribute("usuario", usuario);
        return "editar-usuario"; 
    }
    
    @PostMapping("/user/update/{id}")
    public String actualizarUsuario(@PathVariable("id") int id, @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "editar-usuario"; 
        }
        usuarioService.updateUsuario(usuario);
        return "redirect:/inmueble/listadoUsu"; 
    }

    @DeleteMapping("/user/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") int id) {
        usuarioService.deleteUsuario(id);
        return "redirect:/inmueble/listadoUsu"; 
    }


    

}
