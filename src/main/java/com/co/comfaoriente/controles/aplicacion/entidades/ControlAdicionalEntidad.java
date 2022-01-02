package com.co.comfaoriente.controles.aplicacion.entidades;

import java.io.Serializable;

public class ControlAdicionalEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int idUsuario;
	private String nombreProceso;
	private String descripcion;
	private String nombreProfesional;
	private int tipoControl;

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

	public String getNombreProceso() {
		return nombreProceso;
	}

	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreProfesional() {
		return nombreProfesional;
	}

	public void setNombreProfesional(String nombreProfesional) {
		this.nombreProfesional = nombreProfesional;
	}

	public int getTipoControl() {
		return tipoControl;
	}

	public void setTipoControl(int tipoControl) {
		this.tipoControl = tipoControl;
	}

	@Override
	public String toString() {
		return "ControlesAdicionalesEntidad [id=" + id + ", idUsuario=" + idUsuario + ", nombreProceso=" + nombreProceso
				+ ", descripcion=" + descripcion + ", nombreProfesional=" + nombreProfesional + ", tipoControl="
				+ tipoControl + "]";
	}

}
