package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad;

public interface ControlRepositorioJpa extends CrudRepository<ControlEntidad, Integer> {

	@Query("select control from ControlEntidad control where control.id = :id")
	ControlEntidad consultarControl(@Param("id") int id);

	@Query("select count(*) from ControlEntidad control where control.idUsuario = :idUsuario and control.vigente = true")
	int contarControlesDeUsuario(@Param("idUsuario") int idUsuario);
	
	@Query("select count(*) from ControlEntidad control where control.idUsuario = :idUsuario and control.vigente = false")
	int contarControlesNovigentesDeUsuario(@Param("idUsuario") int idUsuario);

	@Query("select max(control.id) from ControlEntidad control where control.vigente = true and control.idUsuario = :idUsuario")
	int ultimoControlVigente(@Param("idUsuario") int idUsuario);

	@Query("select max(control.id) from ControlEntidad control where control.vigente = false and control.idUsuario = :idUsuario")
	int ultimoControlNoVigente(@Param("idUsuario") int idUsuario);

}
