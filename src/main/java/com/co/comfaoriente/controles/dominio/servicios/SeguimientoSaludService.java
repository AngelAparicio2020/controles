package com.co.comfaoriente.controles.dominio.servicios;

import com.co.comfaoriente.controles.dominio.repositorios.SeguimientoSaludRepositorio;

public class SeguimientoSaludService {

	private SeguimientoSaludRepositorio seguimientoRepositorio;

	public SeguimientoSaludService(SeguimientoSaludRepositorio seguimientoRepositorio) {
		this.seguimientoRepositorio = seguimientoRepositorio;
	}

}
