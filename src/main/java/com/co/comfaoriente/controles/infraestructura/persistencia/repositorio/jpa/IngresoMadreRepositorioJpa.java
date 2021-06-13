package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.repository.CrudRepository;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoMadreEntidad;

public interface IngresoMadreRepositorioJpa extends CrudRepository<IngresoMadreEntidad, Integer>{

}
