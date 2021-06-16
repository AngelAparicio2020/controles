package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoEntidad;

public interface IngresoRepositorioJpa extends CrudRepository<IngresoEntidad, Integer> {

	@Query("select ingreso from IngresoEntidad ingreso where ingreso.id = :id")
	IngresoEntidad consultarIngreso(@Param("id") int id);

}
