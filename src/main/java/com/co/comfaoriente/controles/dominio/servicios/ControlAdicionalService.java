package com.co.comfaoriente.controles.dominio.servicios;

import java.util.List;
import java.util.stream.Collectors;

import com.co.comfaoriente.controles.dominio.entidades.ControlAdicionalEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.ControlAdicionalRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.UsuarioRepositorio;

public class ControlAdicionalService {

	private ControlAdicionalRepositorio controlRepositorio;
	private UsuarioRepositorio usuarioRepositorio;
	private static final String USUARIO_NO_ENCONTRADO = "NO EXISTE UN USUARIO CON ESTE DOCUMENTO";
	private static final String CONTROL_NO_ENCONTRADO = "NO EXISTE UN CONTROL CON ESTE ID";

	public ControlAdicionalService(ControlAdicionalRepositorio controlRepositorio,
			UsuarioRepositorio usuarioRepositorio) {
		this.controlRepositorio = controlRepositorio;
		this.usuarioRepositorio = usuarioRepositorio;
	}

	public boolean registrarControl(ControlAdicionalEntidad control) {
		if (!this.usuarioRepositorio.existeDocumento(control.getIdUsuario())) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}
		return controlRepositorio.registrarControl(control);
	}

	public boolean eliminarControl(int id) {
		if (!this.controlRepositorio.existeControl(id)) {
			throw new EntityNotFoundException(CONTROL_NO_ENCONTRADO);
		}
		return this.controlRepositorio.eliminarControl(id);
	}

	public boolean actualizarControl(ControlAdicionalEntidad control) {
		if (!this.usuarioRepositorio.existeDocumento(control.getIdUsuario())) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}
		return controlRepositorio.actualizarControl(control);
	}

	public ControlAdicionalEntidad consultarControl(int id) {
		if (!this.controlRepositorio.existeControl(id)) {
			throw new EntityNotFoundException(CONTROL_NO_ENCONTRADO);
		}
		return controlRepositorio.consultarControl(id);
	}

	public List<ControlAdicionalEntidad> listadoControles(int id) {
		if (id < 0 || id > 3) {
			throw new EntityNotFoundException("TIPO DE CONTROL INVALIDO");
		}
		if (id == 0) {
			return controlRepositorio.listarControles();
		}
		return controlRepositorio.listarControles().stream().filter(controles -> controles.getTipoControl() == id)
				.collect(Collectors.toList());
	}

}
