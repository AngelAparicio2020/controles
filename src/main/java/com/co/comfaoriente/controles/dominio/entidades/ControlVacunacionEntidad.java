package com.co.comfaoriente.controles.dominio.entidades;

import java.util.Date;

public class ControlVacunacionEntidad {

	private int id;
	private int idUsuario;
	private Date fechaAplicacion;
	private int dosis;
	private int edadGestacional;
	private boolean vigente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFechaAplicacion() {
		return fechaAplicacion;
	}

	public void setFechaAplicacion(Date fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}

	public int getDosis() {
		return dosis;
	}

	public void setDosis(int dosis) {
		this.dosis = dosis;
	}

	public int getEdadGestacional() {
		return edadGestacional;
	}

	public void setEdadGestacional(int edadGestacional) {
		this.edadGestacional = edadGestacional;
	}

	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}

}
