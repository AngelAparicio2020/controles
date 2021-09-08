package com.co.comfaoriente.controles.dominio.repositorios;

import java.util.List;

import com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad;
import com.co.comfaoriente.controles.dominio.entidades.RolEntidad;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolUsuarioEntidad;

public interface RolRepositorio {

	public boolean registrarRol(RolEntidad rol);

	public boolean actualizarRol(RolEntidad rol);

	public boolean eliminarRol(int rol);

	public boolean asignarPrivilegio(List<PrivilegioEntidad> privilegio, int rol);

	public RolEntidad consultarRol(int rol);

	public List<PrivilegioEntidad> consultarPrivilegiosxRol(int rol);

	public List<PrivilegioEntidad> consultarPrivilegios();

	public boolean asignarRol(int documento, int rol);

	public boolean existeRol(int rol);

	public boolean retirarRol(int documento, int rol);

	public List<RolUsuarioEntidad> consultarRolUsuario(int documento);

	public void eliminarPrivilegiosAnteriores(int rol);

}
