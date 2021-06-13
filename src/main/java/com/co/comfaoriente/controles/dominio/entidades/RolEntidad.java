package com.co.comfaoriente.controles.dominio.entidades;

public class RolEntidad {

	private int idRol;
	private String nombre;
	
	public RolEntidad() {
	}

	public RolEntidad(int idRol, String nombre) {
		this.idRol = idRol;
		this.nombre = nombre;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
