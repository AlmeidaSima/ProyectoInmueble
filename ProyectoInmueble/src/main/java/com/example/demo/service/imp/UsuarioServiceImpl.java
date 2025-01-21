package com.example.demo.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	 	@Autowired
	    private UsuarioRepository usuarioRepository;

	    @Override
	    public List<Usuario> getAllUsuarios() {
	        return usuarioRepository.findAll();
	    }

	    @Override
	    public Usuario getUsuarioById(int id) {
	        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
	        return optionalUsuario.orElse(null);
	    }

	    @Override
	    public Usuario updateUsuario(Usuario usuario) {
	        if (usuario == null || usuario.getIdUsuario() == 0) {
	            throw new IllegalArgumentException("Usuario no válido para actualización");
	        }
	        return usuarioRepository.save(usuario);  // Llama al repositorio para guardar el usuario actualizado
	    }

	   

	    @Override
	    public void deleteUsuario(int id) {
	        if (usuarioRepository.existsById(id)) {
	            usuarioRepository.deleteById(id);
	        } else {
	            throw new RuntimeException("Usuario no encontrado para eliminar");
	        }
	    }

	    @Override
	    public Usuario saveUsuario(Usuario usuario) {
	        return usuarioRepository.save(usuario);
	    }
	    
//	    @Override
//	    public Usuario autenticarUsuario(String usuName, String usuPass) {
//	    	
//	    	Usuario usuario = usuarioRepository.findByUser(usuName)
//	                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
//
//	        // Aquí podrías comparar la contraseña con la almacenada, si es en texto plano
//	        if (!usuario.getUsuPass().equals(usuPass)) {
//	            throw new RuntimeException("Contraseña incorrecta");
//	        }
//
//	        return usuario;
//	    }
	    
	   
}
