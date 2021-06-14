package com.co.comfaoriente.controles.dominio.servicios;

import com.co.comfaoriente.controles.dominio.repositorios.ControlRepositorio;

public class ControlService {
	
	private ControlRepositorio controlRepositorio;

	public ControlService(ControlRepositorio controlRepositorio) {
		this.controlRepositorio = controlRepositorio;
	}

}
