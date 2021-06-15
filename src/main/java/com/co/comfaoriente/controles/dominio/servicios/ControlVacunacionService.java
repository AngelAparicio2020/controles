package com.co.comfaoriente.controles.dominio.servicios;

import com.co.comfaoriente.controles.dominio.entidades.ControlVacunacionEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.ControlVacunacionRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.UsuarioRepositorio;

public class ControlVacunacionService {

	private ControlVacunacionRepositorio controlRepositorio;
	private UsuarioRepositorio usuarioRepositorio;
	private static final String USUARIO_NO_ENCONTRADO = "NO EXISTE UN USUARIO CON ESTE DOCUMENTO";
	private static final String CONTROL_NO_ENCONTRADO = "NO EXISTE UN CONTROL CON ESTE ID";

	public ControlVacunacionService(ControlVacunacionRepositorio controlRepositorio,
			UsuarioRepositorio usuarioRepositorio) {
		this.controlRepositorio = controlRepositorio;
		this.usuarioRepositorio = usuarioRepositorio;
	}

	public boolean registrarControl(ControlVacunacionEntidad control) {
		if (!this.usuarioRepositorio.existeDocumento(control.getIdUsuario())) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}

		if (this.controlRepositorio.cantidadDeControlesDePersona(control.getIdUsuario()) > 0) {
			int ultimoControlVigente = this.controlRepositorio.ultimoControlVigente(control.getIdUsuario());
			this.controlRepositorio.volverNoVigente(ultimoControlVigente);
		}
		return controlRepositorio.registrarControl(control);
	}

	public boolean eliminarControl(int id) {
		if (!this.controlRepositorio.existeControl(id)) {
			throw new EntityNotFoundException(CONTROL_NO_ENCONTRADO);
		}
		ControlVacunacionEntidad control = this.controlRepositorio.consultarControl(id);
		if (this.controlRepositorio.esVigente(id)
				&& this.controlRepositorio.cantidadDeControlesNoVigentesDePersona(control.getIdUsuario()) > 0) {
			int ultimoControlNoVigente = this.controlRepositorio.ultimoControlNoVigente(control.getIdUsuario());
			this.controlRepositorio.volverVigente(ultimoControlNoVigente);
		}
		return this.controlRepositorio.eliminarControl(id);
	}

	public boolean actualizarControl(ControlVacunacionEntidad control) {
		if (control == null || !this.controlRepositorio.existeControl(control.getId())) {
			throw new EntityNotFoundException(CONTROL_NO_ENCONTRADO);
		}

		return this.controlRepositorio.actualizarControl(control);
	}

	public ControlVacunacionEntidad consultarControl(int id) {
		if (!this.controlRepositorio.existeControl(id)) {
			throw new EntityNotFoundException(CONTROL_NO_ENCONTRADO);
		}
		return controlRepositorio.consultarControl(id);
	}

}
