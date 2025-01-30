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
    @Column(name = "idUsuario")
    private int idUsuario;

    @Column(name = "usuName", unique = true, nullable = false)
    private String UsuName;

    @Column(name = "usuPass", nullable = false)
    private String UsuPass;

    @Column(name = "usuNomb", nullable = false)
    private String UsuNomb;

    @Column(name = "usuApe", nullable = false)
    private String UsuApe;

    @Column(name = "usuCorreo", unique = true, nullable = false)
    private String UsuCorreo;

    @Column(name = "usuCelular")
    private String UsuCelular;

    @Column(name = "usuTipo", nullable = false)
    private String UsuTipo;

    @Column(name = "vecesAlquilo")
    private int VecesAlquilo = 0;
    
	public Usuario(int idUsuario, String usuName, String usuPass, String usuNomb, String usuApe, String usuCorreo,
			String usuCelular, String usuTipo, int vecesAlquilo) {
		super();
		this.idUsuario = idUsuario;
		UsuName = usuName;
		UsuPass = usuPass;
		UsuNomb = usuNomb;
		UsuApe = usuApe;
		UsuCorreo = usuCorreo;
		UsuCelular = usuCelular;
		UsuTipo = usuTipo;
		VecesAlquilo = vecesAlquilo;
	}

	public Usuario() {
		
	}



	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuName() {
		return UsuName;
	}

	public void setUsuName(String usuName) {
		UsuName = usuName;
	}

	public String getUsuPass() {
		return UsuPass;
	}

	public void setUsuPass(String usuPass) {
		UsuPass = usuPass;
	}

	public String getUsuNomb() {
		return UsuNomb;
	}

	public void setUsuNomb(String usuNomb) {
		UsuNomb = usuNomb;
	}

	public String getUsuApe() {
		return UsuApe;
	}

	public void setUsuApe(String usuApe) {
		UsuApe = usuApe;
	}

	public String getUsuCorreo() {
		return UsuCorreo;
	}

	public void setUsuCorreo(String usuCorreo) {
		UsuCorreo = usuCorreo;
	}

	public String getUsuCelular() {
		return UsuCelular;
	}

	public void setUsuCelular(String usuCelular) {
		UsuCelular = usuCelular;
	}

	public String getUsuTipo() {
		return UsuTipo;
	}

	public void setUsuTipo(String usuTipo) {
		UsuTipo = usuTipo;
	}

	public int getVecesAlquilo() {
		return VecesAlquilo;
	}

	public void setVecesAlquilo(int vecesAlquilo) {
		VecesAlquilo = vecesAlquilo;
	}

	
    
    
}
