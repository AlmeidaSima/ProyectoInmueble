package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "inmueble")
public class Inmueble {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idInmueble")
	private int idInmueble;
	
	@Column(name = "InmuTitulo")
	private String InmuTitulo;
	
	@Column(name = "InmuPrecio")
	private String InmuPrecio;
	
	@Column(name = "InmuDescrip")
	private String InmuDescrip;
	
	@Column(name = "InmuEstado")
	private String InmuEstado;
	
	

	public Inmueble() {
		
	}

	public int getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(int idInmueble) {
		this.idInmueble = idInmueble;
	}

	public String getInmuTitulo() {
		return InmuTitulo;
	}

	public void setInmuTitulo(String inmuTitulo) {
		InmuTitulo = inmuTitulo;
	}

	public String getInmuPrecio() {
		return InmuPrecio;
	}

	public void setInmuPrecio(String inmuPrecio) {
		InmuPrecio = inmuPrecio;
	}

	public String getInmuDescrip() {
		return InmuDescrip;
	}

	public void setInmuDescrip(String inmuDescrip) {
		InmuDescrip = inmuDescrip;
	}

	public String getInmuEstado() {
		return InmuEstado;
	}

	public void setInmuEstado(String inmuEstado) {
		InmuEstado = inmuEstado;
	}
	
	
	
	
	
}
