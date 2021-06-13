package com.co.comfaoriente.controles.aplicacion.entidades;

import java.util.List;

public class PrivilegioAsociadoEntidad {

	private RolEntidad rol;
	private List<PrivilegioEntidad> privilegios;

	public RolEntidad getRol() {
		return rol;
	}

	public void setRol(RolEntidad rol) {
		this.rol = rol;
	}

	public List<PrivilegioEntidad> getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(List<PrivilegioEntidad> privilegios) {
		this.privilegios = privilegios;
	}

	@Override
	public String toString() {
		return "PrivilegioAsociadoDto [rol=" + rol + ", privilegios=" + privilegios + "]";
	}

}
