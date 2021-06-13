package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.PrivilegioEntidad;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolPrivilegioEntidad;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolPrivilegioPK;

public interface PrivilegioRepositorioJpa extends CrudRepository<RolPrivilegioEntidad, RolPrivilegioPK> {

	@Query("select privilegio from RolPrivilegioEntidad privilegio where privilegio.idRol = :rol")
	List<RolPrivilegioEntidad> consultarPrivilegiosxRol(@Param("rol") int rol);

	@Query("select privilegio from PrivilegioEntidad privilegio")
	List<PrivilegioEntidad> consultarPrivilegios();

}
