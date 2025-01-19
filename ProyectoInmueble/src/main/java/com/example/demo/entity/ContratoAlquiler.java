package com.example.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name = "contrato_alquiler")
public class ContratoAlquiler {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idAlquiler;

	    @ManyToOne
	    @JoinColumn(name = "idInmueble", nullable = false)
	    private Inmueble inmueble;

	    @Temporal(TemporalType.DATE)
	    private Date alqFecIni;

	    @Temporal(TemporalType.DATE)
	    private Date alqFechFin;

	    @Column(nullable = false)
	    private BigDecimal alqCosto;
	    
	    
		public ContratoAlquiler(Integer idAlquiler, Inmueble inmueble, Date alqFecIni, Date alqFechFin,
				BigDecimal alqCosto) {
			super();
			this.idAlquiler = idAlquiler;
			this.inmueble = inmueble;
			this.alqFecIni = alqFecIni;
			this.alqFechFin = alqFechFin;
			this.alqCosto = alqCosto;
		}
		

		public ContratoAlquiler() {
		}


		public Integer getIdAlquiler() {
			return idAlquiler;
		}

		public void setIdAlquiler(Integer idAlquiler) {
			this.idAlquiler = idAlquiler;
		}

		public Inmueble getInmueble() {
			return inmueble;
		}

		public void setInmueble(Inmueble inmueble) {
			this.inmueble = inmueble;
		}

		public Date getAlqFecIni() {
			return alqFecIni;
		}

		public void setAlqFecIni(Date alqFecIni) {
			this.alqFecIni = alqFecIni;
		}

		public Date getAlqFechFin() {
			return alqFechFin;
		}

		public void setAlqFechFin(Date alqFechFin) {
			this.alqFechFin = alqFechFin;
		}

		public BigDecimal getAlqCosto() {
			return alqCosto;
		}

		public void setAlqCosto(BigDecimal alqCosto) {
			this.alqCosto = alqCosto;
		}
	    
	    
}
