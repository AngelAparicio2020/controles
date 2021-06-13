package com.co.comfaoriente.controles.unitarias.dataBuilder;

import com.co.comfaoriente.controles.dominio.entidades.RolEntidad;

public class RolBuilder {

	private int idRol;
	private String nombre;

	public RolBuilder() {
		this.idRol = 0;
		this.nombre = "ADMIN";
	}

	public RolBuilder conId(int idRol) {
		this.idRol = idRol;
		return this;
	}

	public RolBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public RolEntidad build() {
		RolEntidad rol = new RolEntidad();
		rol.setIdRol(this.idRol);
		rol.setNombre(this.nombre);
		return rol;
	}

}
