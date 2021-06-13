package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolEntidad;

public interface RolRepositorioJpa extends CrudRepository<RolEntidad, Integer> {

	@Query("select rol from RolEntidad rol where rol.idRol = :rol")
	RolEntidad consultarRol(@Param("rol") int rol);



}
