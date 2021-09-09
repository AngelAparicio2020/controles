package com.co.comfaoriente.controles.aplicacion.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.aplicacion.entidades.UsuarioEntidad;
import com.co.comfaoriente.controles.aplicacion.mapper.UsuarioMapper;
import com.co.comfaoriente.controles.dominio.servicios.UsuarioService;

@Component
public class UsuarioServiceApl {

	@Autowired
	private UsuarioService usuarioService;
	private static final UsuarioMapper mapper = UsuarioMapper.getInstance();

	public boolean registrarUsuario(UsuarioEntidad usuario) {
		return usuarioService.registrarUsuario(mapper.toDominio(usuario));
	}

	public UsuarioEntidad consultarUsuario(int documento) {
		return mapper.toAplicacion(usuarioService.consultarUsuario(documento));
	}

	public boolean actualizarUsuario(UsuarioEntidad usuario) {
		com.co.comfaoriente.controles.dominio.entidades.UsuarioEntidad usuarioDom = mapper.toDominio(usuario);
		return usuarioService.actualizarUsuario(usuarioDom);
	}

	public boolean eliminarUsuario(int documento) {
		return usuarioService.eliminarUsuario(documento);
	}

	public List<UsuarioEntidad> listarUsuarios() {
		return usuarioService.listarUsuarios().stream().map(dominio -> mapper.toAplicacion(dominio))
				.collect(Collectors.toList());
	}

	public List<UsuarioEntidad> consultarUsuariosxRol(String nombre) {
		return usuarioService.consultarUsuariosxRol(nombre).stream().map(mapper::toAplicacion)
				.collect(Collectors.toList());
	}

}
