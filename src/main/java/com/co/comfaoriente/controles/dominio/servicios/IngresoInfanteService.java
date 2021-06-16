package com.co.comfaoriente.controles.dominio.servicios;

import com.co.comfaoriente.controles.dominio.entidades.IngresoInfanteEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.IngresoRepositorio;

public class IngresoInfanteService {

	private IngresoRepositorio ingresoRepositorio;

	public IngresoInfanteService(IngresoRepositorio ingresoRepositorio) {
		this.ingresoRepositorio = ingresoRepositorio;
	}

	public boolean registrarIngresoInfante(IngresoInfanteEntidad ingreso) {
		return ingresoRepositorio.registrarIngresoInfante(ingreso);
	}

	public boolean actualizarIngresoInfante(IngresoInfanteEntidad ingreso) {
		return this.ingresoRepositorio.actualizarIngresoInfante(ingreso);
	}

	public IngresoInfanteEntidad consultarIngresoInfante(int id) {
		return this.ingresoRepositorio.consultarIngresoInfante(id);
	}

}
