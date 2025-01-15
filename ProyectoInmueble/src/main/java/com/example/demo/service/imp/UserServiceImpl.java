package com.example.demo.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;

@Service("usuarioservice")
public class UserServiceImpl implements UsuarioService {

	@Autowired
	@Qualifier("usuariorepository")
	private UsuarioRepository usuariorepository;
	

	@Override
	public List<Usuario> listAllUsers() { 
		return usuariorepository.findAll();
	}

	@Override
	public Usuario addUser(Usuario usuario) {
	    return usuariorepository.save(usuario);  
	}

	@Override
	public Usuario getUserById(int id) {
	    return usuariorepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
	}


	@Override
	public void updateUser(Usuario usuario) {
	    if (usuariorepository.existsById(usuario.getIdUsuario())) {  
	        usuariorepository.save(usuario);  
	    } else {
	        throw new RuntimeException("Usuario no encontrado para actualizar");
	    }
	}


  
    @Override
    public void deleteUser(int id) {
        usuariorepository.deleteById(id);
    }
	
	
}
