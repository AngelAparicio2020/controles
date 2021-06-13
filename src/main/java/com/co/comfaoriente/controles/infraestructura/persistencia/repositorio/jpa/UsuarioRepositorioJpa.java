package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolEntidad;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolUsuarioEntidad;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.UsuarioEntidad;

public interface UsuarioRepositorioJpa extends CrudRepository<UsuarioEntidad, Integer>{

	@Query("select user from UsuarioEntidad user where user.documento = :documento and user.clave = :clave")
	UsuarioEntidad consultarUsuarioLogueado(@Param("documento") int documento, @Param("clave") String clave);
	
	@Query("select roles from RolUsuarioEntidad roles where roles.documento = :documento and roles.idRol = :rol")
	RolUsuarioEntidad consultarRolesUsuario(@Param("documento") int documento, @Param("rol") int rol);
	
	@Query("select privilegio.nombre from RolPrivilegioEntidad privilegio where privilegio.idRol = :rol")
	List<String> consultarPrivilegios(@Param("rol") int rol);
	
	@Query("select rol from RolEntidad rol")
	List<RolEntidad> listarRoles();
	
	@Query("select usuario from UsuarioEntidad usuario")
	List<UsuarioEntidad> listarUsuarios();
	
	@Query("select user from UsuarioEntidad user where user.documento = :documento")
	UsuarioEntidad consultarUsuario(@Param("documento") int documento);
	
	
}
