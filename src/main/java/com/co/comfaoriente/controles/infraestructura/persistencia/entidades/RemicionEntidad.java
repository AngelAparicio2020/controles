package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "remisionsgsss", schema = "controles")
public class RemicionEntidad implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_remision_sgsss", nullable = false)
	private int id;
	
	@Column(name = "id_segui_gest_salud", nullable = false)
	private int idSeguimiento;
	
	@Column(name = "fecha_remision", nullable = false)
	private Date fechaRemision;
	
	@Column(name = "entidad_remit", nullable = false)
	private String entidadRemitida;
	
	@Column(name = "fue_atendido", nullable = false)
	private boolean atendido;
	
	@Column(name = "fecha_atenc", nullable = false)
	private Date fechaAtencion;
	
	@Column(name = "motiv_remis", nullable = false)
	private String motivo;
	
	@Column(name = "hospitaliz", nullable = false)
	private boolean hospitalizado;
	
	@Column(name = "fecha_ingr_hosp", nullable = true)
	private Date fechaIngreso;
	
	@Column(name = "fecha_egre_hosp", nullable = true)
	private Date fechaSalida;
	
	@Column(name = "fallecio_atenc_salud", nullable = true)
	private boolean fallecido;
	
	@Column(name = "razon_fallec", nullable = true)
	private String razonFallecimiento;
	
	@Column(name = "segui_atenc_salud", nullable = false)
	private String seguimiento;
	
	@Column(name = "nombre_aux_enf", nullable = false)
	private String nombreAuxEnfermero;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSeguimiento() {
		return idSeguimiento;
	}

	public void setIdSeguimiento(int idSeguimiento) {
		this.idSeguimiento = idSeguimiento;
	}

	public Date getFechaRemision() {
		return fechaRemision;
	}

	public void setFechaRemision(Date fechaRemision) {
		this.fechaRemision = fechaRemision;
	}

	public String getEntidadRemitida() {
		return entidadRemitida;
	}

	public void setEntidadRemitida(String entidadRemitida) {
		this.entidadRemitida = entidadRemitida;
	}

	public boolean isAtendido() {
		return atendido;
	}

	public void setAtendido(boolean atendido) {
		this.atendido = atendido;
	}

	public Date getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public boolean isHospitalizado() {
		return hospitalizado;
	}

	public void setHospitalizado(boolean hospitalizado) {
		this.hospitalizado = hospitalizado;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public boolean isFallecido() {
		return fallecido;
	}

	public void setFallecido(boolean fallecido) {
		this.fallecido = fallecido;
	}

	public String getRazonFallecimiento() {
		return razonFallecimiento;
	}

	public void setRazonFallecimiento(String razonFallecimiento) {
		this.razonFallecimiento = razonFallecimiento;
	}

	public String getSeguimiento() {
		return seguimiento;
	}

	public void setSeguimiento(String seguimiento) {
		this.seguimiento = seguimiento;
	}

	public String getNombreAuxEnfermero() {
		return nombreAuxEnfermero;
	}

	public void setNombreAuxEnfermero(String nombreAuxEnfermero) {
		this.nombreAuxEnfermero = nombreAuxEnfermero;
	}
	
	
	
	
	

}
