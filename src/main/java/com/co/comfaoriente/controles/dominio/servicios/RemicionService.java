package com.co.comfaoriente.controles.dominio.servicios;

import com.co.comfaoriente.controles.dominio.entidades.RemicionEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.RemicionRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.SeguimientoSaludRepositorio;

public class RemicionService {

	private RemicionRepositorio remicionRepositorio;
	private SeguimientoSaludRepositorio seguimientoRepositorio;
	private static final String REMICION_NO_ENCONTRADA = "NO EXISTE UNA REMICION CON ESTE ID";
	private static final String SEGUIMIENTO_NO_ENCONTRADO = "NO EXISTE UN SEGUIMIENTO CON ESTE ID";

	public RemicionService(RemicionRepositorio remicionRepositorio,
			SeguimientoSaludRepositorio seguimientoRepositorio) {
		this.remicionRepositorio = remicionRepositorio;
		this.seguimientoRepositorio = seguimientoRepositorio;
	}

	public boolean registrarRemicion(RemicionEntidad remicion) {
		if (!this.seguimientoRepositorio.existeSeguimiento(remicion.getIdSeguimiento())) {
			throw new EntityNotFoundException(SEGUIMIENTO_NO_ENCONTRADO);
		}
		return remicionRepositorio.registrarRemicion(remicion);
	}

	public boolean eliminarRemicion(int id) {
		if (!this.remicionRepositorio.existeRemicion(id)) {
			throw new EntityNotFoundException(REMICION_NO_ENCONTRADA);
		}
		return this.remicionRepositorio.eliminarRemicion(id);
	}

	public boolean actualizarRemicion(RemicionEntidad remicion) {
		if (remicion == null || !this.remicionRepositorio.existeRemicion(remicion.getId())) {
			throw new EntityNotFoundException(REMICION_NO_ENCONTRADA);
		}
		return this.remicionRepositorio.actualizarRemicion(remicion);
	}

	public RemicionEntidad consultarRemicion(int id) {
		if (!this.remicionRepositorio.existeRemicion(id)) {
			throw new EntityNotFoundException(REMICION_NO_ENCONTRADA);
		}

		return this.remicionRepositorio.consultarRemicion(id);
	}
}
