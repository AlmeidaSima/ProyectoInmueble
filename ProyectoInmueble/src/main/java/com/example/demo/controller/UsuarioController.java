package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
        System.out.println("Usuarios recuperados: " + usuarios);  // Añadido para verificar los usuarios
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
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "editar-usuario";  // Pagina del formulario de edición
        } else {
            model.addAttribute("errorMessage", "Usuario no encontrado");
            return "error";  // Redireccionar a una vista de error en caso de no encontrar al usuario
        }
    }



    @PostMapping("/user/update/{id}")
    public String actualizarUsuario(@PathVariable("id") int id, Usuario usuario) {
        usuario.setIdUsuario(id);  // Se asume que el id viene desde la URL
        
        // Aquí puedes añadir cualquier validación adicional si es necesario

        Usuario updatedUsuario = usuarioService.updateUsuario(usuario);  // Llama al método de servicio para actualizar
        if (updatedUsuario != null) {
            return "redirect:/inmueble/listadoUsu";  // Redirecciona al listado si todo salió bien
        } else {
            return "error";  // Redirecciona a la página de error si no se pudo actualizar
        }
    }

    

    @GetMapping("/user/eliminar/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        usuarioService.deleteUsuario(id);
        return "redirect:/inmueble/listadoUsu";
    }

}
