package com.example.demo.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pagos")
public class Pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPago;

	@Column(nullable = false)
	private Integer idAlquiler;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private java.util.Date pagfecPag;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal pagCosto;

	@Column(precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2) DEFAULT 0")
	private BigDecimal pagDsct;

	@Column(precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2) DEFAULT 0")
	private BigDecimal pagCosMan;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal pagTotal;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Cancelado') DEFAULT 'Cancelado'")
	private PagoEstado pagEstado = PagoEstado.CANCELADO;

	public Pago() {
		
	}

	public Pago(Integer idPago, Integer idAlquiler, java.util.Date pagfecPag, BigDecimal pagCosto, BigDecimal pagDsct,
			BigDecimal pagCosMan, BigDecimal pagTotal, PagoEstado pagEstado) {
		super();
		this.idPago = idPago;
		this.idAlquiler = idAlquiler;
		this.pagfecPag = pagfecPag;
		this.pagCosto = pagCosto;
		this.pagDsct = pagDsct;
		this.pagCosMan = pagCosMan;
		this.pagTotal = pagTotal;
		this.pagEstado = pagEstado;
	}

	public Integer getIdPago() {
		return idPago;
	}

	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}

	public Integer getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(Integer idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public java.util.Date getPagfecPag() {
		return pagfecPag;
	}

	public void setPagfecPag(java.util.Date pagfecPag) {
		this.pagfecPag = pagfecPag;
	}

	public BigDecimal getPagCosto() {
		return pagCosto;
	}

	public void setPagCosto(BigDecimal pagCosto) {
		this.pagCosto = pagCosto;
	}

	public BigDecimal getPagDsct() {
		return pagDsct;
	}

	public void setPagDsct(BigDecimal pagDsct) {
		this.pagDsct = pagDsct;
	}

	public BigDecimal getPagCosMan() {
		return pagCosMan;
	}

	public void setPagCosMan(BigDecimal pagCosMan) {
		this.pagCosMan = pagCosMan;
	}

	public BigDecimal getPagTotal() {
		return pagTotal;
	}

	public void setPagTotal(BigDecimal pagTotal) {
		this.pagTotal = pagTotal;
	}

	public PagoEstado getPagEstado() {
		return pagEstado;
	}

	public void setPagEstado(PagoEstado pagEstado) {
		this.pagEstado = pagEstado;
	}
	

	
	
	

}
