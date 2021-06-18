package com.co.comfaoriente.controles.dominio.servicios;

import com.co.comfaoriente.controles.dominio.entidades.CompromisoEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.CompromisoRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.SeguimientoSaludRepositorio;

public class CompromisoService {

	private CompromisoRepositorio compromisoRepositorio;
	private SeguimientoSaludRepositorio seguimientoRepositorio;
	private static final String COMPROMISO_NO_ENCONTRADO = "NO EXISTE UN COMPROMISO CON ESTE ID";
	private static final String SEGUIMIENTO_NO_ENCONTRADO = "NO EXISTE UN SEGUIMIENTO CON ESTE ID";

	public CompromisoService(CompromisoRepositorio compromisoRepositorio,
			SeguimientoSaludRepositorio seguimientoRepositorio) {
		this.compromisoRepositorio = compromisoRepositorio;
		this.seguimientoRepositorio = seguimientoRepositorio;
	}

	public boolean registrarCompromiso(CompromisoEntidad compromiso) {
		if (!this.seguimientoRepositorio.existeSeguimiento(compromiso.getIdSeguimientoSalud())) {
			throw new EntityNotFoundException(SEGUIMIENTO_NO_ENCONTRADO);
		}
		return compromisoRepositorio.registrarCompromiso(compromiso);
	}

	public boolean eliminarCompromiso(int id) {
		if (!this.compromisoRepositorio.existeCompromiso(id)) {
			throw new EntityNotFoundException(COMPROMISO_NO_ENCONTRADO);
		}

		return this.compromisoRepositorio.eliminarCompromiso(id);
	}

	public boolean actualizarCompromiso(CompromisoEntidad compromiso) {
		if (compromiso == null || !this.compromisoRepositorio.existeCompromiso(compromiso.getId())) {
			throw new EntityNotFoundException(COMPROMISO_NO_ENCONTRADO);
		}
		return this.compromisoRepositorio.actualizarCompromiso(compromiso);
	}

	public CompromisoEntidad consultarCompromiso(int id) {
		if (!this.compromisoRepositorio.existeCompromiso(id)) {
			throw new EntityNotFoundException(COMPROMISO_NO_ENCONTRADO);
		}

		return this.compromisoRepositorio.consultarCompromiso(id);
	}
}
