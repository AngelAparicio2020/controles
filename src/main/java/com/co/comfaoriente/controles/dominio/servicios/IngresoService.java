package com.co.comfaoriente.controles.dominio.servicios;

import com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.IngresoRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.SeguimientoSaludRepositorio;

public class IngresoService {

	private IngresoRepositorio ingresoRepositorio;
	private SeguimientoSaludRepositorio seguimientoRepositorio;
	private static final String INGRESO_NO_ENCONTRADO = "NO EXISTE UN INGRESO CON ESTE ID";
	private static final String SEGUIMIENTO_NO_ENCONTRADO = "NO EXISTE UN SEGUIMIENTO CON ESTE ID";

	public IngresoService(IngresoRepositorio ingresoRepositorio, SeguimientoSaludRepositorio seguimientoRepositorio) {
		this.ingresoRepositorio = ingresoRepositorio;
		this.seguimientoRepositorio = seguimientoRepositorio;
	}

	public int registrarIngreso(IngresoEntidad ingreso) {
		if (!this.seguimientoRepositorio.existeSeguimiento(ingreso.getIdSeguimiento())) {
			throw new EntityNotFoundException(SEGUIMIENTO_NO_ENCONTRADO);
		}
		return ingresoRepositorio.registrarIngreso(ingreso);
	}

	public boolean eliminarIngreso(int id) {
		if (!this.ingresoRepositorio.existeIngreso(id)) {
			throw new EntityNotFoundException(INGRESO_NO_ENCONTRADO);
		}

		return this.ingresoRepositorio.eliminarIngreso(id);
	}

	public boolean actualizarIngreso(IngresoEntidad ingreso) {
		if (ingreso == null || !this.ingresoRepositorio.existeIngreso(ingreso.getId())) {
			throw new EntityNotFoundException(INGRESO_NO_ENCONTRADO);
		}
		return this.ingresoRepositorio.actualizarIngreso(ingreso);
	}

	public IngresoEntidad consultarIngreso(int id) {
		if (!this.ingresoRepositorio.existeIngreso(id)) {
			throw new EntityNotFoundException(INGRESO_NO_ENCONTRADO);
		}

		return this.ingresoRepositorio.consultarIngreso(id);
	}

	public IngresoEntidad consultarIngresoxSeguimiento(int idSeguimiento) {
		if (!this.seguimientoRepositorio.existeSeguimiento(idSeguimiento)) {
			throw new EntityNotFoundException(SEGUIMIENTO_NO_ENCONTRADO);
		}

		return this.ingresoRepositorio.consultarIngresoxSeguimiento(idSeguimiento);
	}

}
