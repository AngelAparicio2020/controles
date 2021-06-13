package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.repository.CrudRepository;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolUsuarioEntidad;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolUsuarioPK;

public interface RolUsuarioRepositorioJpa extends CrudRepository<RolUsuarioEntidad, RolUsuarioPK> {

}
