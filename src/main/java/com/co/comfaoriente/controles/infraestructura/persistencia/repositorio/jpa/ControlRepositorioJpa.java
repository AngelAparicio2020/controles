package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.repository.CrudRepository;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad;

public interface ControlRepositorioJpa extends CrudRepository<ControlEntidad, Integer>{

}
