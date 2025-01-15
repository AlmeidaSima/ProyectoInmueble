package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Usuario;

public interface UsuarioService {
	
	public abstract List<Usuario> listAllUsers();
    public abstract Usuario addUser(Usuario usuario);
    public abstract Usuario getUserById(int id);
    public abstract void updateUser(Usuario usuario);
    public abstract void deleteUser(int id); 
}
