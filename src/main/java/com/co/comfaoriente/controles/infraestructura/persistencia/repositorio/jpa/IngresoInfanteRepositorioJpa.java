package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoInfanteEntidad;

public interface IngresoInfanteRepositorioJpa extends CrudRepository<IngresoInfanteEntidad, Integer> {

	@Query("select ingreso from IngresoInfanteEntidad ingreso where ingreso.id = :id")
	IngresoInfanteEntidad consultarIngreso(@Param("id") int id);
}
