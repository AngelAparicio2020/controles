package com.co.comfaoriente.controles.infraestructura.persistencia.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.ControlVacunacionEntidad;
import com.co.comfaoriente.controles.infraestructura.dtos.ControlVacunacionDto;

public class ControlVacunacionMapper {

	private ControlVacunacionMapper() {
	}

	private static final ControlVacunacionMapper INSTANCE = new ControlVacunacionMapper();

	public static ControlVacunacionMapper getInstance() {
		return INSTANCE;
	}

	public ControlVacunacionEntidad toAplicacion(ControlVacunacionDto dto) {
		ControlVacunacionEntidad aplicacion = new ControlVacunacionEntidad();
		aplicacion.setId(dto.getId());
		aplicacion.setEdadGestacional(dto.getEdadGestacional());
		aplicacion.setDosis(dto.getDosis());
		aplicacion.setFechaAplicacion(dto.getFechaAplicacion());
		aplicacion.setIdUsuario(dto.getIdUsuario());
		aplicacion.setVigente(dto.isVigente());
		aplicacion.setNombreVacuna(dto.getNombreVacuna());
		aplicacion.setLote(dto.getLote());
		aplicacion.setInstitucion(dto.getInstitucion());
		aplicacion.setProfesionalSalud(dto.getProfesionalSalud());
		return aplicacion;
	}

	public ControlVacunacionDto toDto(ControlVacunacionEntidad controlVacunacionEntidad) {
		ControlVacunacionDto dto = new ControlVacunacionDto();
		dto.setId(controlVacunacionEntidad.getId());
		dto.setEdadGestacional(controlVacunacionEntidad.getEdadGestacional());
		dto.setDosis(controlVacunacionEntidad.getDosis());
		dto.setFechaAplicacion(controlVacunacionEntidad.getFechaAplicacion());
		dto.setIdUsuario(controlVacunacionEntidad.getIdUsuario());
		dto.setVigente(controlVacunacionEntidad.isVigente());
		dto.setNombreVacuna(controlVacunacionEntidad.getNombreVacuna());
		dto.setVacunasRegistradas(controlVacunacionEntidad.getVacunas());
		dto.setLote(controlVacunacionEntidad.getLote());
		dto.setInstitucion(controlVacunacionEntidad.getInstitucion());
		dto.setProfesionalSalud(controlVacunacionEntidad.getProfesionalSalud());
		return dto;
	}

	public com.co.comfaoriente.controles.dominio.entidades.ControlVacunacionEntidad toDomain(
			com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlVacunacionEntidad entity) {
		com.co.comfaoriente.controles.dominio.entidades.ControlVacunacionEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.ControlVacunacionEntidad();
		dominio.setId(entity.getId());
		dominio.setEdadGestacional(entity.getEdadGestacional());
		dominio.setDosis(entity.getDosis());
		dominio.setFechaAplicacion(entity.getFechaAplicacion());
		dominio.setIdUsuario(entity.getIdUsuario());
		dominio.setVigente(entity.isVigente());
		dominio.setNombreVacuna(entity.getNombreVacuna());
		dominio.setLote(entity.getLote());
		dominio.setInstitucion(entity.getInstitucion());
		dominio.setProfesionalSalud(entity.getProfesionalSalud());
		return dominio;
	}

	public com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlVacunacionEntidad toEntity(
			com.co.comfaoriente.controles.dominio.entidades.ControlVacunacionEntidad dominio) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlVacunacionEntidad entity = new com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlVacunacionEntidad();
		entity.setId(dominio.getId());
		entity.setEdadGestacional(dominio.getEdadGestacional());
		entity.setDosis(dominio.getDosis());
		entity.setIdUsuario(dominio.getIdUsuario());
		entity.setVigente(dominio.isVigente());
		entity.setFechaAplicacion(dominio.getFechaAplicacion());
		entity.setNombreVacuna(dominio.getNombreVacuna());
		entity.setLote(dominio.getLote());
		entity.setInstitucion(dominio.getInstitucion());
		entity.setProfesionalSalud(dominio.getProfesionalSalud());
		return entity;
	}

}
