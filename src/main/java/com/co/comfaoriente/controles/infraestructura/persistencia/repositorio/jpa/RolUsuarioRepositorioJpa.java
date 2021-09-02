package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolUsuarioEntidad;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolUsuarioPK;

public interface RolUsuarioRepositorioJpa extends CrudRepository<RolUsuarioEntidad, RolUsuarioPK> {

	@Query("select rol from RolUsuarioEntidad rol where rol.documento = :documento")
	List<RolUsuarioEntidad> consultarRolesUsuario(@Param("documento") int documento);

}
