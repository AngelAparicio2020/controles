package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.BitacoraUsuarioEntidad;

public interface BitacoraUsuariosRepositorioJpa extends CrudRepository<BitacoraUsuarioEntidad, Integer> {

	@Query("select archivos from BitacoraUsuarioEntidad archivos where archivos.idUsuario = :idUsuario")
	List<BitacoraUsuarioEntidad> consultarHistorialUsuario(@Param("idUsuario") int idUsuario);

}
