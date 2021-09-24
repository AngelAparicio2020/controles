package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.SeguimientoSaludEntidad;

public interface SeguimientoSaludRepositorioJpa extends CrudRepository<SeguimientoSaludEntidad, Integer> {

	@Query("select control from SeguimientoSaludEntidad control where control.id = :id")
	SeguimientoSaludEntidad consultarSeguimiento(@Param("id") int id);

	@Query("select count(*) from SeguimientoSaludEntidad control where control.idUsuario = :idUsuario and control.vigente = true")
	int contarSeguimientosDeUsuario(@Param("idUsuario") int idUsuario);

	@Query("select count(*) from SeguimientoSaludEntidad control where control.idUsuario = :idUsuario and control.vigente = false")
	int contarSeguimientosNovigentesDeUsuario(@Param("idUsuario") int idUsuario);

	@Query("select max(control.id) from SeguimientoSaludEntidad control where control.vigente = true and control.idUsuario = :idUsuario")
	int ultimoSeguimientoVigente(@Param("idUsuario") int idUsuario);

	@Query("select max(control.id) from SeguimientoSaludEntidad control where control.vigente = false and control.idUsuario = :idUsuario")
	int ultimoSeguimientoNoVigente(@Param("idUsuario") int idUsuario);

	@Query("select control.id from SeguimientoSaludEntidad control where control.idUsuario = :idUsuario")
	List<Integer> listarSeguimientosxDocumento(@Param("idUsuario") int idUsuario);
	
	@Query("select control from SeguimientoSaludEntidad control where control.idUsuario = :idUsuario")
	List<SeguimientoSaludEntidad> listarSeguimientosxDocumentoCompletos(@Param("idUsuario") int idUsuario);

}
