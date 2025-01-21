package com.example.demo.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recibo_pago")
public class Recibo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idRecibo;

	@ManyToOne
	@JoinColumn(name = "idAlquiler", referencedColumnName = "idAlquiler", nullable = false)
	private ContratoAlquiler contratoAlquiler;

	@Column(name = "RecFecha", nullable = false)
	private Date recFecha;

	@Column(name = "RecMonto", nullable = false)
	private BigDecimal recMonto;

	@Column(name = "RecDscto", nullable = true, columnDefinition = "DECIMAL(10,2) DEFAULT 0")
	private BigDecimal recDscto;

	@Column(name = "RecMan", nullable = true, columnDefinition = "DECIMAL(10,2) DEFAULT 0")
	private BigDecimal recMan;

	@Column(name = "RecTotal", nullable = false)
	private BigDecimal recTotal;

	public Recibo(Integer idRecibo, ContratoAlquiler contratoAlquiler, Date recFecha, BigDecimal recMonto,
			BigDecimal recDscto, BigDecimal recMan, BigDecimal recTotal) {
		super();
		this.idRecibo = idRecibo;
		this.contratoAlquiler = contratoAlquiler;
		this.recFecha = recFecha;
		this.recMonto = recMonto;
		this.recDscto = recDscto;
		this.recMan = recMan;
		this.recTotal = recTotal;
	}

	public Recibo() {

	}

	public Integer getIdRecibo() {
		return idRecibo;
	}

	public void setIdRecibo(Integer idRecibo) {
		this.idRecibo = idRecibo;
	}

	public ContratoAlquiler getContratoAlquiler() {
		return contratoAlquiler;
	}

	public void setContratoAlquiler(ContratoAlquiler contratoAlquiler) {
		this.contratoAlquiler = contratoAlquiler;
	}

	public Date getRecFecha() {
		return recFecha;
	}

	public void setRecFecha(Date recFecha) {
		this.recFecha = recFecha;
	}

	public BigDecimal getRecMonto() {
		return recMonto;
	}

	public void setRecMonto(BigDecimal recMonto) {
		this.recMonto = recMonto;
	}

	public BigDecimal getRecDscto() {
		return recDscto;
	}

	public void setRecDscto(BigDecimal recDscto) {
		this.recDscto = recDscto;
	}

	public BigDecimal getRecMan() {
		return recMan;
	}

	public void setRecMan(BigDecimal recMan) {
		this.recMan = recMan;
	}

	public BigDecimal getRecTotal() {
		return recTotal;
	}

	public void setRecTotal(BigDecimal recTotal) {
		this.recTotal = recTotal;
	}

}
