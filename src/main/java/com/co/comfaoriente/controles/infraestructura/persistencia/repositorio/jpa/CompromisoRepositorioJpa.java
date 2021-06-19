package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.CompromisoEntidad;

public interface CompromisoRepositorioJpa extends CrudRepository<CompromisoEntidad, Integer>{
	
	@Query("select compromiso from CompromisoEntidad compromiso where compromiso.id = :id")
	CompromisoEntidad consultarCompromiso(@Param("id") int id);
	
	@Query("select compromiso from CompromisoEntidad compromiso where compromiso.idSeguimientoSalud = :id")
	CompromisoEntidad consultarCompromisoxSeguimiento(@Param("id") int id);

}
