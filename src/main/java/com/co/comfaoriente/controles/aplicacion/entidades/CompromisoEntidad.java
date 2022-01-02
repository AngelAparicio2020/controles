package com.co.comfaoriente.controles.aplicacion.entidades;

import java.util.Date;

public class CompromisoEntidad {

	private int id;

	private int idSeguimientoSalud;

	private Date fechaCompromiso;

	private String nombre;

	private String nuevoCompromiso;

	private Date fechaCumplimiento;

	private String nombreAuxiliarEnfermeria;

	private String tipo;
	
	private Date fechaTentativaCump;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSeguimientoSalud() {
		return idSeguimientoSalud;
	}

	public void setIdSeguimientoSalud(int idSeguimientoSalud) {
		this.idSeguimientoSalud = idSeguimientoSalud;
	}

	public Date getFechaCompromiso() {
		return fechaCompromiso;
	}

	public void setFechaCompromiso(Date fechaCompromiso) {
		this.fechaCompromiso = fechaCompromiso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNuevoCompromiso() {
		return nuevoCompromiso;
	}

	public void setNuevoCompromiso(String nuevoCompromiso) {
		this.nuevoCompromiso = nuevoCompromiso;
	}

	public Date getFechaCumplimiento() {
		return fechaCumplimiento;
	}

	public void setFechaCumplimiento(Date fechaCumplimiento) {
		this.fechaCumplimiento = fechaCumplimiento;
	}

	public String getNombreAuxiliarEnfermeria() {
		return nombreAuxiliarEnfermeria;
	}

	public void setNombreAuxiliarEnfermeria(String nombreAuxiliarEnfermeria) {
		this.nombreAuxiliarEnfermeria = nombreAuxiliarEnfermeria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFechaTentativaCump() {
		return fechaTentativaCump;
	}

	public void setFechaTentativaCump(Date fechaTentativaCump) {
		this.fechaTentativaCump = fechaTentativaCump;
	}
	
	
}
