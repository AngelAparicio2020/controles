package com.co.comfaoriente.controles.infraestructura.dtos;

import java.util.List;

public class PrivilegioAsociadoDto {

	private RolDto rol;
	private List<PrivilegioDto> privilegios;

	public RolDto getRol() {
		return rol;
	}

	public void setRol(RolDto rol) {
		this.rol = rol;
	}

	public List<PrivilegioDto> getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(List<PrivilegioDto> privilegios) {
		this.privilegios = privilegios;
	}

	@Override
	public String toString() {
		return "PrivilegioAsociadoDto [rol=" + rol + ", privilegios=" + privilegios + "]";
	}

}
