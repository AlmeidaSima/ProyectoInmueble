package com.example.demo.entity;

<<<<<<< HEAD
import java.math.BigDecimal;

=======
>>>>>>> 6143d419c3300bd5b5b292ad0f51fcdfcdb1deec
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
<<<<<<< HEAD
@Table(name = "inmueble")
=======
@Table(name= "inmueble")
>>>>>>> 6143d419c3300bd5b5b292ad0f51fcdfcdb1deec
public class Inmueble {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idInmueble")
	private int idInmueble;
<<<<<<< HEAD

	@Column(name = "InmTitulo", nullable = false)
	private String inmuTitulo;

	@Column(name = "InmTipo", nullable = false)
	private String inmuTipo;

	@Column(name = "InmPisos", nullable = false)
	private int inmuPisos;

	@Column(name = "InmEstado", nullable = false)
	private String inmuEstado;

	@Column(name = "InmDescrip")
	private String inmuDescrip;
	
	@Column(name = "InmPrecio", nullable = false)
	private BigDecimal inmuPrecio; // Usando BigDecimal para precios

	@Column(name = "InmPunt", columnDefinition = "DECIMAL(3, 2) DEFAULT 0")
	private BigDecimal inmuPunt;

	@Column(name = "InmDepart", nullable = false)
	private String inmuDepart;

	@Column(name = "InmCiudad", nullable = false)
	private String inmuCiudad;

	@Column(name = "InmArea", nullable = false)
	private String inmuArea;

	@Column(name = "InmDireccion", nullable = false)
	private String inmuDireccion;

	@Column(name = "VecesAlquilado", columnDefinition = "INT DEFAULT 0")
	private int vecesAlquilado;

	public Inmueble(int idInmueble, String inmuTitulo, String inmuTipo, int inmuPisos, String inmuEstado,
			String inmuDescrip, BigDecimal inmuPrecio, BigDecimal inmuPunt, String inmuDepart, String inmuCiudad,
			String inmuArea, String inmuDireccion, int vecesAlquilado) {
		super();
		this.idInmueble = idInmueble;
		this.inmuTitulo = inmuTitulo;
		this.inmuTipo = inmuTipo;
		this.inmuPisos = inmuPisos;
		this.inmuEstado = inmuEstado;
		this.inmuDescrip = inmuDescrip;
		this.inmuPrecio = inmuPrecio;
		this.inmuPunt = inmuPunt;
		this.inmuDepart = inmuDepart;
		this.inmuCiudad = inmuCiudad;
		this.inmuArea = inmuArea;
		this.inmuDireccion = inmuDireccion;
		this.vecesAlquilado = vecesAlquilado;
	}
	
=======
	
	@Column(name = "InmuTitulo")
	private String InmuTitulo;
	
	@Column(name = "InmuPrecio")
	private String InmuPrecio;
	
	@Column(name = "InmuDescrip")
	private String InmuDescrip;
	
	@Column(name = "InmuEstado")
	private String InmuEstado;
	
	

>>>>>>> 6143d419c3300bd5b5b292ad0f51fcdfcdb1deec
	public Inmueble() {
		
	}

	public int getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(int idInmueble) {
		this.idInmueble = idInmueble;
	}

	public String getInmuTitulo() {
<<<<<<< HEAD
		return inmuTitulo;
	}

	public void setInmuTitulo(String inmuTitulo) {
		this.inmuTitulo = inmuTitulo;
	}

	public String getInmuTipo() {
		return inmuTipo;
	}

	public void setInmuTipo(String inmuTipo) {
		this.inmuTipo = inmuTipo;
	}

	public int getInmuPisos() {
		return inmuPisos;
	}

	public void setInmuPisos(int inmuPisos) {
		this.inmuPisos = inmuPisos;
	}

	public String getInmuEstado() {
		return inmuEstado;
	}

	public void setInmuEstado(String inmuEstado) {
		this.inmuEstado = inmuEstado;
	}

	public String getInmuDescrip() {
		return inmuDescrip;
	}

	public void setInmuDescrip(String inmuDescrip) {
		this.inmuDescrip = inmuDescrip;
	}

	public BigDecimal getInmuPrecio() {
		return inmuPrecio;
	}

	public void setInmuPrecio(BigDecimal inmuPrecio) {
		this.inmuPrecio = inmuPrecio;
	}

	public BigDecimal getInmuPunt() {
		return inmuPunt;
	}

	public void setInmuPunt(BigDecimal inmuPunt) {
		this.inmuPunt = inmuPunt;
	}

	public String getInmuDepart() {
		return inmuDepart;
	}

	public void setInmuDepart(String inmuDepart) {
		this.inmuDepart = inmuDepart;
	}

	public String getInmuCiudad() {
		return inmuCiudad;
	}

	public void setInmuCiudad(String inmuCiudad) {
		this.inmuCiudad = inmuCiudad;
	}

	public String getInmuArea() {
		return inmuArea;
	}

	public void setInmuArea(String inmuArea) {
		this.inmuArea = inmuArea;
	}

	public String getInmuDireccion() {
		return inmuDireccion;
	}

	public void setInmuDireccion(String inmuDireccion) {
		this.inmuDireccion = inmuDireccion;
	}

	public int getVecesAlquilado() {
		return vecesAlquilado;
	}

	public void setVecesAlquilado(int vecesAlquilado) {
		this.vecesAlquilado = vecesAlquilado;
	}

=======
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
	
	
	
	
	
>>>>>>> 6143d419c3300bd5b5b292ad0f51fcdfcdb1deec
}
