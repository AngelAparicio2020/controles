package com.co.comfaoriente.controles.infraestructura.dtos;

import java.util.List;

public class SesionEntidadRespuesta {

	private String tokenJWT;
	private List<String> privilegios;

	public SesionEntidadRespuesta(String tokenJWT, List<String> privilegios) {
		this.tokenJWT = tokenJWT;
		this.privilegios = privilegios;
	}

	public String getTokenJWT() {
		return tokenJWT;
	}

	public void setTokenJWT(String tokenJWT) {
		this.tokenJWT = tokenJWT;
	}

	public List<String> getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(List<String> privilegios) {
		this.privilegios = privilegios;
	}

}
