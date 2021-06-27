package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaEntidad;

public interface VacunaRepositorioJpa extends CrudRepository<VacunaEntidad, Integer> {

	@Query("select vacuna from VacunaEntidad vacuna where vacuna.meses = :mes")
	List<VacunaEntidad> consultarVacunasxMes(@Param("mes") int mes);

}
