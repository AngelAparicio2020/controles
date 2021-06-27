package com.co.comfaoriente.controles.dominio.servicios;

import java.util.Date;
import java.util.List;

import com.co.comfaoriente.controles.dominio.entidades.ControlVacunacionEntidad;
import com.co.comfaoriente.controles.dominio.entidades.VacunaEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.ControlVacunacionRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.UsuarioRepositorio;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaControlEntidad;

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

	public List<ControlVacunacionEntidad> listadoControlesVacunacion(int idUsuario) {
		return controlRepositorio.consultarControlesxPersona(idUsuario);
	}

	public List<VacunaEntidad> consultarVacunasXedad(int meses) {
		return controlRepositorio.consultarVacunasXedad(meses);
	}

	public int consultarUltimoControl(int idUsuario) {
		return this.controlRepositorio.ultimoControlVigente(idUsuario);
	}

	public boolean asignarVacunasaControl(List<VacunaEntidad> vacunas, int control, Date fechaAplicacion) {
		return this.controlRepositorio.asignarVacunasaControl(vacunas, control, fechaAplicacion);
	}

	public boolean eliminarVacuna(int control, int vacuna) {
		return this.controlRepositorio.eliminarVacuna(control, vacuna);
	}

	public List<Integer> listarControlesxDocumento(int documento) {
		if (!this.usuarioRepositorio.existeDocumento(documento)) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}
		return this.controlRepositorio.listadoControlesxDocumento(documento);
	}

	public List<VacunaControlEntidad> consultarVacunasxControl(int control) {
		return this.controlRepositorio.consultarVacunasxControl(control);
	}

}
