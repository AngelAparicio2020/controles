package com.co.comfaoriente.controles.dominio.servicios;

import com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.SeguimientoSaludRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.UsuarioRepositorio;

public class SeguimientoSaludService {

	private SeguimientoSaludRepositorio seguimientoRepositorio;
	private UsuarioRepositorio usuarioRepositorio;
	private static final String USUARIO_NO_ENCONTRADO = "NO EXISTE UN USUARIO CON ESTE DOCUMENTO";
	private static final String NUTRICIONISTA_NO_ENCONTRADO = "NO EXISTE UN NUTRICIONISTA CON ESTE DOCUMENTO";
	private static final String SEGUIMIENTO_NO_ENCONTRADO = "NO EXISTE UN SEGUIMIENTO CON ESTE ID";

	public SeguimientoSaludService(SeguimientoSaludRepositorio seguimientoRepositorio,
			UsuarioRepositorio usuarioRepositorio) {
		this.seguimientoRepositorio = seguimientoRepositorio;
		this.usuarioRepositorio = usuarioRepositorio;
	}

	public boolean registrarSeguimiento(SeguimientoSaludEntidad seguimiento) {
		if (!this.usuarioRepositorio.existeDocumento(seguimiento.getIdUsuario())) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}
		if (!this.usuarioRepositorio.existeDocumento(seguimiento.getIdUsuarioNutricionista())) {
			throw new EntityNotFoundException(NUTRICIONISTA_NO_ENCONTRADO);
		}
		if (this.seguimientoRepositorio.cantidadDeSeguimientosDePersona(seguimiento.getIdUsuario()) > 0) {
			int ultimoControlVigente = this.seguimientoRepositorio.ultimoSeguimientoVigente(seguimiento.getIdUsuario());
			this.seguimientoRepositorio.volverNoVigente(ultimoControlVigente);
		}
		return seguimientoRepositorio.registrarSeguimiento(seguimiento);
	}

	public boolean eliminarSeguimiento(int id) {
		if (!this.seguimientoRepositorio.existeSeguimiento(id)) {
			throw new EntityNotFoundException(SEGUIMIENTO_NO_ENCONTRADO);
		}
		SeguimientoSaludEntidad control = this.seguimientoRepositorio.consultarSeguimiento(id);
		if (this.seguimientoRepositorio.esVigente(id)
				&& this.seguimientoRepositorio.cantidadDeSeguimientosNoVigentesDePersona(control.getIdUsuario()) > 0) {
			int ultimoControlNoVigente = this.seguimientoRepositorio.ultimoSeguimientoNoVigente(control.getIdUsuario());
			this.seguimientoRepositorio.volverVigente(ultimoControlNoVigente);
		}
		return this.seguimientoRepositorio.eliminarSeguimiento(id);
	}

	public boolean actualizarSeguimiento(SeguimientoSaludEntidad seguimiento) {
		if (seguimiento == null || !this.seguimientoRepositorio.existeSeguimiento(seguimiento.getId())) {
			throw new EntityNotFoundException(SEGUIMIENTO_NO_ENCONTRADO);
		}

		if (!this.usuarioRepositorio.existeDocumento(seguimiento.getIdUsuarioNutricionista())) {
			throw new EntityNotFoundException(NUTRICIONISTA_NO_ENCONTRADO);
		}

		return this.seguimientoRepositorio.actualizarSeguimiento(seguimiento);
	}

	public SeguimientoSaludEntidad consultarSeguimiento(int id) {
		if (!this.seguimientoRepositorio.existeSeguimiento(id)) {
			throw new EntityNotFoundException(SEGUIMIENTO_NO_ENCONTRADO);
		}
		return seguimientoRepositorio.consultarSeguimiento(id);
	}

}
