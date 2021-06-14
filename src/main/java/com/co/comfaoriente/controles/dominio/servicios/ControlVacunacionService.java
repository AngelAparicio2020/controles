package com.co.comfaoriente.controles.dominio.servicios;

import com.co.comfaoriente.controles.dominio.repositorios.ControlVacunacionRepositorio;

public class ControlVacunacionService {

	private ControlVacunacionRepositorio controlRepositorio;

	public ControlVacunacionService(ControlVacunacionRepositorio controlRepositorio) {
		this.controlRepositorio = controlRepositorio;
	}

}
