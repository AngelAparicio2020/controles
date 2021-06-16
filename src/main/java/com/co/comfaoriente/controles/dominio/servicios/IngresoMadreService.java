package com.co.comfaoriente.controles.dominio.servicios;

import com.co.comfaoriente.controles.dominio.entidades.IngresoMadreEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.IngresoRepositorio;

public class IngresoMadreService {

	private IngresoRepositorio ingresoRepositorio;

	public IngresoMadreService(IngresoRepositorio ingresoRepositorio) {
		this.ingresoRepositorio = ingresoRepositorio;
	}

	public boolean registrarIngresoMadre(IngresoMadreEntidad ingreso) {
		return ingresoRepositorio.registrarIngresoMadre(ingreso);
	}

	public boolean actualizarIngresoMadre(IngresoMadreEntidad ingreso) {
		return this.ingresoRepositorio.actualizarIngresoMadre(ingreso);
	}

	public IngresoMadreEntidad consultarIngresoMadre(int id) {
		return this.ingresoRepositorio.consultarIngresoMadre(id);
	}

}
