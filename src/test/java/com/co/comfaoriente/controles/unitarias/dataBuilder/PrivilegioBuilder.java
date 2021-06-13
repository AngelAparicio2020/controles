package com.co.comfaoriente.controles.unitarias.dataBuilder;

import com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad;

public class PrivilegioBuilder {

	private int id;
	private String nombre;

	public PrivilegioBuilder() {
		this.id = 0;
		this.nombre = "ADMIN";
	}

	public PrivilegioBuilder conId(int idRol) {
		this.id = idRol;
		return this;
	}

	public PrivilegioBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public PrivilegioEntidad build() {
		PrivilegioEntidad rol = new PrivilegioEntidad();
		rol.setId(this.id);
		rol.setNombre(this.nombre);
		return rol;
	}

}
