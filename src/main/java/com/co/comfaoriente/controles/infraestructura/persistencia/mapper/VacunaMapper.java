package com.co.comfaoriente.controles.infraestructura.persistencia.mapper;

import java.util.Date;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaControlEntidad;

public class VacunaMapper {

	private VacunaMapper() {
	}

	private static final VacunaMapper INSTANCE = new VacunaMapper();

	public static VacunaMapper getInstance() {
		return INSTANCE;
	}

	public com.co.comfaoriente.controles.dominio.entidades.VacunaEntidad toDomain(
			com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaEntidad entity) {
		com.co.comfaoriente.controles.dominio.entidades.VacunaEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.VacunaEntidad();
		dominio.setId(entity.getId());
		dominio.setMeses(entity.getMeses());
		dominio.setNombre(entity.getNombre());
		return dominio;
	}

	public com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaEntidad toEntity(
			com.co.comfaoriente.controles.dominio.entidades.VacunaEntidad dominio) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaEntidad entity = new com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaEntidad();
		entity.setId(dominio.getId());
		entity.setMeses(dominio.getMeses());
		entity.setNombre(dominio.getNombre());
		return entity;
	}

	public VacunaControlEntidad vacunaControlToEntity(
			com.co.comfaoriente.controles.dominio.entidades.VacunaEntidad domain, int control, Date fechaAplicacion) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaControlEntidad entity = new com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaControlEntidad();
		entity.setIdControl(control);
		entity.setFecha(fechaAplicacion);
		entity.setIdVacuna(domain.getId());
		entity.setMeses(domain.getMeses());
		entity.setNombre(domain.getNombre());
		return entity;
	}

}
