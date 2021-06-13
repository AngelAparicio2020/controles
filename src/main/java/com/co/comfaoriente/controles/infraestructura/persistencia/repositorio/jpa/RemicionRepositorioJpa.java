package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.repository.CrudRepository;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RemicionEntidad;

public interface RemicionRepositorioJpa extends CrudRepository<RemicionEntidad, Integer>{

}
