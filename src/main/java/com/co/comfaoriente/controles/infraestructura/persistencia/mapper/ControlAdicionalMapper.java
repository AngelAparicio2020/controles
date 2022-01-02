package com.co.comfaoriente.controles.infraestructura.persistencia.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.ControlAdicionalEntidad;
import com.co.comfaoriente.controles.infraestructura.dtos.ControlAdicionalDto;

public class ControlAdicionalMapper {

	private ControlAdicionalMapper() {
	}

	private static final ControlAdicionalMapper INSTANCE = new ControlAdicionalMapper();

	public static ControlAdicionalMapper getInstance() {
		return INSTANCE;
	}

	public ControlAdicionalEntidad toAplicacion(ControlAdicionalDto dto) {
		ControlAdicionalEntidad aplicacion = new ControlAdicionalEntidad();
		if (dto != null) {
			aplicacion.setDescripcion(dto.getDescripcion());
			aplicacion.setId(dto.getId());
			aplicacion.setIdUsuario(dto.getIdUsuario());
			aplicacion.setNombreProceso(dto.getNombreProceso());
			aplicacion.setNombreProfesional(dto.getNombreProfesional());
			aplicacion.setTipoControl(dto.getTipoControl());
		}
		return aplicacion;
	}

	public ControlAdicionalDto toDto(ControlAdicionalEntidad aplicacion) {
		ControlAdicionalDto dto = new ControlAdicionalDto();
		if (aplicacion != null) {
			dto.setDescripcion(aplicacion.getDescripcion());
			dto.setId(aplicacion.getId());
			dto.setIdUsuario(aplicacion.getIdUsuario());
			dto.setNombreProceso(aplicacion.getNombreProceso());
			dto.setNombreProfesional(aplicacion.getNombreProfesional());
			dto.setTipoControl(aplicacion.getTipoControl());
		}
		return dto;
	}

	public com.co.comfaoriente.controles.dominio.entidades.ControlAdicionalEntidad toDomain(
			com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlAdicionalEntidad entity) {
		com.co.comfaoriente.controles.dominio.entidades.ControlAdicionalEntidad dominio = null;
		if (entity != null) {
			dominio = new com.co.comfaoriente.controles.dominio.entidades.ControlAdicionalEntidad();
			dominio.setId(entity.getId());
			dominio.setDescripcion(entity.getDescripcion());
			dominio.setIdUsuario(entity.getIdUsuario());
			dominio.setNombreProceso(entity.getNombreProceso());
			dominio.setNombreProfesional(entity.getNombreProfesional());
			dominio.setTipoControl(entity.getTipoControl());
		}
		return dominio;
	}

	public com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlAdicionalEntidad toEntity(
			com.co.comfaoriente.controles.dominio.entidades.ControlAdicionalEntidad dominio) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlAdicionalEntidad entity = new com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlAdicionalEntidad();
		if (dominio != null) {
			entity.setId(dominio.getId());
			entity.setDescripcion(dominio.getDescripcion());
			entity.setIdUsuario(dominio.getIdUsuario());
			entity.setNombreProceso(dominio.getNombreProceso());
			entity.setNombreProfesional(dominio.getNombreProfesional());
			entity.setTipoControl(dominio.getTipoControl());
		}
		return entity;
	}

}
