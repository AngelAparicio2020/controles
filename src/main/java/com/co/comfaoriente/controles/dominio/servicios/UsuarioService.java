package com.co.comfaoriente.controles.dominio.servicios;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.co.comfaoriente.controles.dominio.entidades.UsuarioEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.UsuarioRepositorio;

public class UsuarioService {

	private UsuarioRepositorio usuarioRepositorio;

	private static final String USUARIO_NO_ENCONTRADO = "NO EXISTE UN USUARIO CON ESTE DOCUMENTO";

	public UsuarioService(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}

	public boolean registrarUsuario(UsuarioEntidad usuario) {
		if (usuarioRepositorio.existeDocumento(usuario.getDocumento())) {
			throw new EntityNotFoundException("ESTE USUARIO YA SE ENCONTRABA REGISTRADO");
		}
		usuario.setFechaRegistro(new Date());
		return usuarioRepositorio.registrarUsuario(usuario);
	}

	public UsuarioEntidad consultarUsuario(int documento) {
		if (!usuarioRepositorio.existeDocumento(documento)) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}
		return usuarioRepositorio.consultarUsuario(documento);
	}

	public boolean actualizarUsuario(UsuarioEntidad usuario) {
		if (!usuarioRepositorio.existeDocumento(usuario.getDocumento())) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}
		return usuarioRepositorio.actualizarUsuario(usuario);
	}

	public boolean eliminarUsuario(int documento) {
		if (!usuarioRepositorio.existeDocumento(documento)) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}
		return usuarioRepositorio.eliminarUsuario(documento);
	}

	public List<UsuarioEntidad> listarUsuarios() {
		return usuarioRepositorio.listarUsuarios().stream().filter(usuario -> usuario.getFechaIngresoPrograma() != null)
				.collect(Collectors.toList());
	}

	public List<UsuarioEntidad> listarUsuariosInactivos() {
		return usuarioRepositorio.listarUsuarios().stream().filter(usuario -> usuario.getFechaIngresoPrograma() == null)
				.collect(Collectors.toList());
	}

	public List<UsuarioEntidad> consultarUsuariosxRol(String nombre) {
		return usuarioRepositorio.consultarUsuariosxRol(nombre);
	}

}
