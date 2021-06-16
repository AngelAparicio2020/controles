package com.co.comfaoriente.controles.dominio.entidades;

import java.util.Date;

public class RemicionEntidad {

	private int id;

	private int idSeguimiento;

	private Date fechaRemision;

	private String entidadRemitida;

	private boolean atendido;

	private Date fechaAtencion;

	private String motivo;

	private boolean hospitalizado;

	private Date fechaIngreso;

	private Date fechaSalida;

	private boolean fallecido;

	private String razonFallecimiento;

	private String seguimiento;

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
