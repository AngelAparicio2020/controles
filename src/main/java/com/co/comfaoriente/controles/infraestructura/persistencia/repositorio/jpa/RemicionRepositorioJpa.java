package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RemicionEntidad;

public interface RemicionRepositorioJpa extends CrudRepository<RemicionEntidad, Integer> {

	@Query("select remicion from RemicionEntidad remicion where remicion.id = :id")
	RemicionEntidad consultarRemicion(@Param("id") int id);

	@Query("select remicion from RemicionEntidad remicion where remicion.idSeguimiento = :id")
	List<RemicionEntidad> consultarRemicionxSeguimiento(@Param("id") int id);

}
