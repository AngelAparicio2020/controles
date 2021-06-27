package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlVacunacionEntidad;

public interface ControlVacunacionRepositorioJpa extends CrudRepository<ControlVacunacionEntidad, Integer>{

	@Query("select control from ControlVacunacionEntidad control where control.id = :id")
	ControlVacunacionEntidad consultarControl(@Param("id") int id);

	@Query("select count(*) from ControlVacunacionEntidad control where control.idUsuario = :idUsuario and control.vigente = true")
	int contarControlesDeUsuario(@Param("idUsuario") int idUsuario);
	
	@Query("select count(*) from ControlVacunacionEntidad control where control.idUsuario = :idUsuario and control.vigente = false")
	int contarControlesNovigentesDeUsuario(@Param("idUsuario") int idUsuario);

	@Query("select max(control.id) from ControlVacunacionEntidad control where control.vigente = true and control.idUsuario = :idUsuario")
	int ultimoControlVigente(@Param("idUsuario") int idUsuario);

	@Query("select max(control.id) from ControlVacunacionEntidad control where control.vigente = false and control.idUsuario = :idUsuario")
	int ultimoControlNoVigente(@Param("idUsuario") int idUsuario);
	
	@Query("select control from ControlVacunacionEntidad control where control.idUsuario = :idUsuario")
	List<ControlVacunacionEntidad> controlesVacunacion(@Param("idUsuario") int idUsuario);
	
	@Query("select control.id from ControlVacunacionEntidad control where control.idUsuario = :idUsuario")
	List<Integer> listarControlesxDocumento(@Param("idUsuario") int idUsuario);

}
