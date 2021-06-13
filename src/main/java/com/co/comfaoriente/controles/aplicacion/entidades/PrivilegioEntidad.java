package com.co.comfaoriente.controles.aplicacion.entidades;

public class PrivilegioEntidad {

	private int id;
	private String nombre;

	public PrivilegioEntidad() {
	}

	public PrivilegioEntidad(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "PrivilegioDto [id=" + id + ", nombre=" + nombre + "]";
	}

}
