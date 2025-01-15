package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")  
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "UsuName", unique = true, nullable = false)
    private String usuario;

    @Column(name = "UsuPass", nullable = false)
    private String contrasena;

    @Column(name = "UsuNomb")
    private String nombre;

    @Column(name = "UsuApe")
    private String apellido;

    @Column(name = "UsuCorreo")
    private String correo;

    @Column(name = "UsuCelular")
    private String celular;

    @Column(name = "UsuTipo")
    private String tipo;

    @Column(name = "UsuPunt")
    private double punt;

    @Column(name = "VecesAlquilo")
    private int vecesAlquilo;

    // Constructor, Getters y Setters

    public Usuario() {
        super();
    }

    public Usuario(int idUsuario, String usuario, String contrasena, String nombre, String apellido, String correo,
            String celular, String tipo, double punt, int vecesAlquilo) {
        super();
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.tipo = tipo;
        this.punt = punt;
        this.vecesAlquilo = vecesAlquilo;
    }

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPunt() {
		return punt;
	}

	public void setPunt(double punt) {
		this.punt = punt;
	}

	public int getVecesAlquilo() {
		return vecesAlquilo;
	}

	public void setVecesAlquilo(int vecesAlquilo) {
		this.vecesAlquilo = vecesAlquilo;
	}
    
}
