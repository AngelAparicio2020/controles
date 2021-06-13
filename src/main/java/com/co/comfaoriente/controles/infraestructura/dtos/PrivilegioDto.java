package com.co.comfaoriente.controles.infraestructura.dtos;

public class PrivilegioDto {

	private int id;
	private String nombre;

	public PrivilegioDto() {
	}

	public PrivilegioDto(int id, String nombre) {
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
