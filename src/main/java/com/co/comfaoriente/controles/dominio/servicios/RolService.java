package com.co.comfaoriente.controles.dominio.servicios;

import java.util.List;

import com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad;
import com.co.comfaoriente.controles.dominio.entidades.RolEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.RolRepositorio;

public class RolService {

	private RolRepositorio rolRepositorio;
	private static final String ROL_NO_ENCONTRADO = "NO EXISTE UN ROL CON ESTE ID";

	public RolService(RolRepositorio rolRepositorio) {
		this.rolRepositorio = rolRepositorio;
	}

	public boolean registrarRol(RolEntidad rol) {
		return rolRepositorio.registrarRol(rol);
	}

	public boolean asignarRol(int documento, int rol) {
		if (!rolRepositorio.existeRol(rol)) {
			throw new EntityNotFoundException(ROL_NO_ENCONTRADO);
		}

		if (!rolRepositorio.existeRol(rol)) {
			throw new EntityNotFoundException("NO EXISTE UN USUARIO CON ESTE DOCUMENTO");
		}
		return rolRepositorio.asignarRol(documento, rol);
	}

	public boolean eliminarRol(int rol) {
		if (!rolRepositorio.existeRol(rol)) {
			throw new EntityNotFoundException(ROL_NO_ENCONTRADO);
		}
		return rolRepositorio.eliminarRol(rol);
	}

	public RolEntidad consultarRol(int rol) {
		if (!rolRepositorio.existeRol(rol)) {
			throw new EntityNotFoundException(ROL_NO_ENCONTRADO);
		}
		return rolRepositorio.consultarRol(rol);
	}

	public List<PrivilegioEntidad> consultarPrivilegios() {
		return rolRepositorio.consultarPrivilegios();
	}

	public boolean asignarPrivilegios(List<PrivilegioEntidad> privilegios, int rol) {
		if (!rolRepositorio.existeRol(rol)) {
			throw new EntityNotFoundException(ROL_NO_ENCONTRADO);
		}
		if (privilegios == null || privilegios.isEmpty()) {
			return true;
		}
		return rolRepositorio.asignarPrivilegio(privilegios, rol);
	}

	public List<PrivilegioEntidad> consultarPrivilegiosxRol(int rol) {
		if (!rolRepositorio.existeRol(rol)) {
			throw new EntityNotFoundException(ROL_NO_ENCONTRADO);
		}
		return rolRepositorio.consultarPrivilegiosxRol(rol);
	}

	public boolean actualizarRol(RolEntidad rol) {
		if (rol == null || !rolRepositorio.existeRol(rol.getIdRol())) {
			throw new EntityNotFoundException(ROL_NO_ENCONTRADO);
		}
		return rolRepositorio.actualizarRol(rol);
	}

	public boolean retirarRol(int documento, int rol) {
		if (!rolRepositorio.existeRol(rol)) {
			throw new EntityNotFoundException(ROL_NO_ENCONTRADO);
		}

		if (!rolRepositorio.existeRol(rol)) {
			throw new EntityNotFoundException("NO EXISTE UN USUARIO CON ESTE DOCUMENTO");
		}
		return rolRepositorio.retirarRol(documento, rol);
	}

}
