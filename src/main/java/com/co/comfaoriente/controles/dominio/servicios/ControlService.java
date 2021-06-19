package com.co.comfaoriente.controles.dominio.servicios;

import java.util.List;

import com.co.comfaoriente.controles.dominio.entidades.ControlEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.ControlRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.UsuarioRepositorio;

public class ControlService {

	private ControlRepositorio controlRepositorio;
	private UsuarioRepositorio usuarioRepositorio;
	private static final String USUARIO_NO_ENCONTRADO = "NO EXISTE UN USUARIO CON ESTE DOCUMENTO";
	private static final String NUTRICIONISTA_NO_ENCONTRADO = "NO EXISTE UN NUTRICIONISTA CON ESTE DOCUMENTO";
	private static final String CONTROL_NO_ENCONTRADO = "NO EXISTE UN CONTROL CON ESTE ID";

	public ControlService(ControlRepositorio controlRepositorio, UsuarioRepositorio usuarioRepositorio) {
		this.controlRepositorio = controlRepositorio;
		this.usuarioRepositorio = usuarioRepositorio;
	}

	public boolean registrarControl(ControlEntidad control) {
		if (!this.usuarioRepositorio.existeDocumento(control.getIdUsuario())) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}
		if (!this.usuarioRepositorio.existeDocumento(control.getIdUsuarioNutricionista())) {
			throw new EntityNotFoundException(NUTRICIONISTA_NO_ENCONTRADO);
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
		ControlEntidad control = this.controlRepositorio.consultarControl(id);
		if (this.controlRepositorio.esVigente(id)
				&& this.controlRepositorio.cantidadDeControlesNoVigentesDePersona(control.getIdUsuario()) > 0) {
			int ultimoControlNoVigente = this.controlRepositorio.ultimoControlNoVigente(control.getIdUsuario());
			this.controlRepositorio.volverVigente(ultimoControlNoVigente);
		}
		return this.controlRepositorio.eliminarControl(id);
	}

	public boolean actualizarControl(ControlEntidad control) {
		if (control == null || !this.controlRepositorio.existeControl(control.getId())) {
			throw new EntityNotFoundException(CONTROL_NO_ENCONTRADO);
		}

		if (!this.usuarioRepositorio.existeDocumento(control.getIdUsuarioNutricionista())) {
			throw new EntityNotFoundException(NUTRICIONISTA_NO_ENCONTRADO);
		}

		return this.controlRepositorio.actualizarControl(control);
	}

	public ControlEntidad consultarControl(int id) {
		if (!this.controlRepositorio.existeControl(id)) {
			throw new EntityNotFoundException(CONTROL_NO_ENCONTRADO);
		}
		return controlRepositorio.consultarControl(id);
	}

	public List<ControlEntidad> listadoControlesCyD(int id) {
		if (!this.usuarioRepositorio.existeDocumento(id)) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}
		return controlRepositorio.listadoControlesCyD(id);
	}

	public List<ControlEntidad> listadoControlesNutricionales(int id) {
		if (!this.usuarioRepositorio.existeDocumento(id)) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}
		return controlRepositorio.listadoControlesNutricionales(id);
	}

	public ControlEntidad ultimoControlCyD(int id, int idNutricionista) {
		if (!this.usuarioRepositorio.existeDocumento(id)) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}
		if (!this.usuarioRepositorio.existeDocumento(idNutricionista)) {
			throw new EntityNotFoundException(NUTRICIONISTA_NO_ENCONTRADO);
		}
		return controlRepositorio.ultimoControlCyD(id, idNutricionista);
	}

	public ControlEntidad ultimoControlNutricional(int id, int idNutricionista) {
		if (!this.usuarioRepositorio.existeDocumento(id)) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}
		if (!this.usuarioRepositorio.existeDocumento(idNutricionista)) {
			throw new EntityNotFoundException(NUTRICIONISTA_NO_ENCONTRADO);
		}
		return controlRepositorio.ultimoControlNutricional(id, idNutricionista);
	}

}
