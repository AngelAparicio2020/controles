package com.co.comfaoriente.controles.dominio.repositorios;

import java.util.List;

import com.co.comfaoriente.controles.dominio.entidades.UsuarioEntidad;

public interface UsuarioRepositorio {

	public List<UsuarioEntidad> listarUsuarios();

	public boolean registrarUsuario(UsuarioEntidad usuario);

	public boolean actualizarUsuario(UsuarioEntidad usuario);

	public boolean eliminarUsuario(int documento);

	public UsuarioEntidad consultarUsuario(int documento);

	public boolean existeDocumento(int documento);
	
	public List<UsuarioEntidad> consultarUsuariosxRol(String nombre);

}
