package com.co.comfaoriente.controles.dominio.servicios;

import java.util.List;

import com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad;
import com.co.comfaoriente.controles.dominio.entidades.RolEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.RolRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.UsuarioRepositorio;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolUsuarioEntidad;

public class RolService {

	private RolRepositorio rolRepositorio;
	private UsuarioRepositorio usuarioRepositorio;
	private static final String ROL_NO_ENCONTRADO = "NO EXISTE UN ROL CON ESTE ID";
	private static final String USUARIO_NO_ENCONTRADO = "NO EXISTE UN USUARIO CON ESTE DOCUMENTO";

	public RolService(RolRepositorio rolRepositorio, UsuarioRepositorio usuarioRepositorio) {
		this.rolRepositorio = rolRepositorio;
		this.usuarioRepositorio = usuarioRepositorio;
	}

	public boolean registrarRol(RolEntidad rol) {
		return rolRepositorio.registrarRol(rol);
	}

	public boolean asignarRol(int documento, int rol) {
		if (!rolRepositorio.existeRol(rol)) {
			throw new EntityNotFoundException(ROL_NO_ENCONTRADO);
		}

		if (!usuarioRepositorio.existeDocumento(documento)) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
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

	public void eliminarPrivilegiosAnteriores(int rol) {
		rolRepositorio.eliminarPrivilegiosAnteriores(rol);
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

		if (!usuarioRepositorio.existeDocumento(documento)) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}
		return rolRepositorio.retirarRol(documento, rol);
	}

	public List<RolUsuarioEntidad> consultarRolesUsuario(int documento) {
		if (!usuarioRepositorio.existeDocumento(documento)) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}
		return rolRepositorio.consultarRolUsuario(documento);
	}

}
