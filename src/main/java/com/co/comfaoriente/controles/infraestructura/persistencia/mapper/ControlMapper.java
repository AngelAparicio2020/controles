package com.co.comfaoriente.controles.infraestructura.persistencia.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.ControlEntidad;
import com.co.comfaoriente.controles.infraestructura.dtos.ControlDto;

public class ControlMapper {

	private ControlMapper() {
	}

	private static final ControlMapper INSTANCE = new ControlMapper();

	public static ControlMapper getInstance() {
		return INSTANCE;
	}

	public ControlEntidad toAplicacion(ControlDto dto) {
		ControlEntidad aplicacion = null;
		if (dto != null) {
			aplicacion = new ControlEntidad();
			aplicacion.setId(dto.getId());
			aplicacion.setEdadGestacional(dto.getEdadGestacional());
			aplicacion.setEstadoNutricional(dto.getEstadoNutricional());
			aplicacion.setFechaControl(dto.getFechaControl());
			aplicacion.setIdUsuario(dto.getIdUsuario());
			aplicacion.setIdUsuarioNutricionista(dto.getIdUsuarioNutricionista());
			aplicacion.setImc(dto.getImc());
			aplicacion.setPeso(dto.getPeso());
			aplicacion.setProximoControl(dto.getProximoControl());
			aplicacion.setTalla(dto.getTalla());
			aplicacion.setTension(dto.getTension());
			aplicacion.setUltimoControl(dto.getUltimoControl());
			aplicacion.setVigente(dto.isVigente());
		}
		return aplicacion;
	}

	public ControlDto toDto(ControlEntidad aplicacion) {
		ControlDto dto = null;
		if (aplicacion != null) {
			dto = new ControlDto();
			dto.setId(aplicacion.getId());
			dto.setEdadGestacional(aplicacion.getEdadGestacional());
			dto.setEstadoNutricional(aplicacion.getEstadoNutricional());
			dto.setFechaControl(aplicacion.getFechaControl());
			dto.setIdUsuario(aplicacion.getIdUsuario());
			dto.setIdUsuarioNutricionista(aplicacion.getIdUsuarioNutricionista());
			dto.setImc(aplicacion.getImc());
			dto.setPeso(aplicacion.getPeso());
			dto.setProximoControl(aplicacion.getProximoControl());
			dto.setTalla(aplicacion.getTalla());
			dto.setTension(aplicacion.getTension());
			dto.setUltimoControl(aplicacion.getUltimoControl());
			dto.setVigente(aplicacion.isVigente());
		}
		return dto;
	}

	public com.co.comfaoriente.controles.dominio.entidades.ControlEntidad toDomain(
			com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad entity) {
		com.co.comfaoriente.controles.dominio.entidades.ControlEntidad dominio = null;
		if (entity != null) {
			dominio = new com.co.comfaoriente.controles.dominio.entidades.ControlEntidad();
			dominio.setId(entity.getId());
			dominio.setEdadGestacional(entity.getEdadGestacional());
			dominio.setEstadoNutricional(entity.getEstadoNutricional());
			dominio.setFechaControl(entity.getFechaControl());
			dominio.setIdUsuario(entity.getIdUsuario());
			dominio.setIdUsuarioNutricionista(entity.getIdUsuarioNutricionista());
			dominio.setImc(entity.getImc());
			dominio.setPeso(entity.getPeso());
			dominio.setProximoControl(entity.getProximoControl());
			dominio.setTalla(entity.getTalla());
			dominio.setTension(entity.getTension());
			dominio.setUltimoControl(entity.getUltimoControl());
			dominio.setVigente(entity.isVigente());
		}
		return dominio;
	}

	public com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad toEntity(
			com.co.comfaoriente.controles.dominio.entidades.ControlEntidad dominio) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad entity = new com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad();
		entity.setId(dominio.getId());
		entity.setEdadGestacional(dominio.getEdadGestacional());
		entity.setEstadoNutricional(dominio.getEstadoNutricional());
		entity.setFechaControl(dominio.getFechaControl());
		entity.setIdUsuario(dominio.getIdUsuario());
		entity.setIdUsuarioNutricionista(dominio.getIdUsuarioNutricionista());
		entity.setImc(dominio.getImc());
		entity.setPeso(dominio.getPeso());
		entity.setProximoControl(dominio.getProximoControl());
		entity.setTalla(dominio.getTalla());
		entity.setTension(dominio.getTension());
		entity.setUltimoControl(dominio.getUltimoControl());
		entity.setVigente(dominio.isVigente());
		return entity;
	}

}
