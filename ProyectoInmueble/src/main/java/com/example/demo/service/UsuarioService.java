package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Usuario;

public interface UsuarioService {
	
	public abstract List<Usuario> getAllUsuarios();
	public abstract Usuario getUsuarioById(int id);
	public abstract Usuario saveUsuario(Usuario usuario);
	public abstract Usuario updateUsuario(Usuario usuario);
	public abstract void deleteUsuario(int id);

  
}
