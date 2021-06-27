package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaControlEntidad;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaControlPK;

public interface VacunaControlRepositorioJpa extends CrudRepository<VacunaControlEntidad, VacunaControlPK> {

	@Query("select vacuna from VacunaControlEntidad vacuna where vacuna.idControl = :id")
	List<VacunaControlEntidad> consultarVacunaxControl(@Param("id") int id);

}
