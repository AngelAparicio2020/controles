package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoMadreEntidad;

public interface IngresoMadreRepositorioJpa extends CrudRepository<IngresoMadreEntidad, Integer>{
	
	@Query("select ingreso from IngresoMadreEntidad ingreso where ingreso.id = :id")
	IngresoMadreEntidad consultarIngreso(@Param("id") int id);

}
