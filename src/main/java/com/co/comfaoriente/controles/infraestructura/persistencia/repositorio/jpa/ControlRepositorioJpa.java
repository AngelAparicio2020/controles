package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad;

public interface ControlRepositorioJpa extends CrudRepository<ControlEntidad, Integer> {

	@Query("select control from ControlEntidad control where control.id = :id")
	ControlEntidad consultarControl(@Param("id") int id);

	@Query("select count(*) from ControlEntidad control where control.idUsuario = :idUsuario and control.vigente = true")
	int contarControlesDeUsuario(@Param("idUsuario") int idUsuario);
	
	@Query("select count(*) from ControlEntidad control where control.idUsuario = :idUsuario and control.vigente = false")
	int contarControlesNovigentesDeUsuario(@Param("idUsuario") int idUsuario);

	@Query("select max(control.id) from ControlEntidad control where control.vigente = true and control.idUsuario = :idUsuario")
	int ultimoControlVigente(@Param("idUsuario") int idUsuario);

	@Query("select max(control.id) from ControlEntidad control where control.vigente = false and control.idUsuario = :idUsuario")
	int ultimoControlNoVigente(@Param("idUsuario") int idUsuario);
	
	@Query("select max(control) from ControlEntidad control where control.idUsuario = :idUsuario and control.idUsuarioNutricionista = :idUsuarioNutricionista and control.ultimoControl != null and control.proximoControl != null")
	ControlEntidad ultimoControlCyD(@Param("idUsuario") int idUsuario,@Param("idUsuarioNutricionista") int  idUsuarioNutricionista);

	@Query("select max(control) from ControlEntidad control where control.idUsuario = :idUsuario and control.idUsuarioNutricionista = :idUsuarioNutricionista and control.ultimoControl = null and control.proximoControl = null")
	ControlEntidad ultimoControlNutricional(@Param("idUsuario") int idUsuario,@Param("idUsuarioNutricionista") int  idUsuarioNutricionista);

	@Query("select control from ControlEntidad control where control.idUsuario = :idUsuario and control.ultimoControl = null and control.proximoControl = null")
	List<ControlEntidad> controlesNutricionalesXPersona(@Param("idUsuario") int idUsuario);

	@Query("select control from ControlEntidad control where control.idUsuario = :idUsuario and control.ultimoControl != null and control.proximoControl != null")
	List<ControlEntidad> controlesCyDXPersona(@Param("idUsuario") int idUsuario);
	
	@Query("select max(control) from ControlEntidad control where control.idUsuario = :idUsuario and control.ultimoControl != null and control.proximoControl != null")
	ControlEntidad ultimoControlCyDxDocumento(@Param("idUsuario") int idUsuario);


}
