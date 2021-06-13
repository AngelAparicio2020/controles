package com.co.comfaoriente.controles.infraestructura.dtos;

public class RolDto {
	
	private int idRol;
	private String nombre;
	
	public RolDto(int idRol, String nombre) {
		this.idRol = idRol;
		this.nombre = nombre;
	}
	
	public RolDto() {
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

	@Override
	public String toString() {
		return "RolDto [idRol=" + idRol + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
	

}
