package com.co.comfaoriente.controles.dominio.servicios;

import com.co.comfaoriente.controles.dominio.repositorios.IngresoRepositorio;

public class IngresoService {
	
	private IngresoRepositorio ingresoRepositorio;

	public IngresoService(IngresoRepositorio ingresoRepositorio) {
		this.ingresoRepositorio = ingresoRepositorio;
	}

}
