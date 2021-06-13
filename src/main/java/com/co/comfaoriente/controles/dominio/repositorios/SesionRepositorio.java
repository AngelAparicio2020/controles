package com.co.comfaoriente.controles.dominio.repositorios;

import java.util.List;

import com.co.comfaoriente.controles.dominio.entidades.RolEntidad;

public interface SesionRepositorio {

	public boolean existeUsuario(int documento, String clave);

	public boolean consultarRolesUsuario(int documento, int rol);

	public List<String> consultarPrivilegios(int rol);
	
	public List<RolEntidad> listarRoles();

}
