package com.co.comfaoriente.controles.infraestructura.persistencia.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.RemicionEntidad;
import com.co.comfaoriente.controles.infraestructura.dtos.RemicionDto;

public class RemicionMapper {

	private RemicionMapper() {
	}

	private static final RemicionMapper INSTANCE = new RemicionMapper();

	public static RemicionMapper getInstance() {
		return INSTANCE;
	}

	public RemicionEntidad toAplicacion(RemicionDto dto) {
		RemicionEntidad aplicacion = new RemicionEntidad();
		aplicacion.setAtendido(dto.isAtendido());
		aplicacion.setEntidadRemitida(dto.getEntidadRemitida());
		aplicacion.setFallecido(dto.isFallecido());
		aplicacion.setFechaAtencion(dto.getFechaAtencion());
		aplicacion.setFechaIngreso(dto.getFechaIngreso());
		aplicacion.setFechaRemision(dto.getFechaRemision());
		aplicacion.setFechaSalida(dto.getFechaSalida());
		aplicacion.setHospitalizado(dto.isHospitalizado());
		aplicacion.setId(dto.getId());
		aplicacion.setIdSeguimiento(dto.getIdSeguimiento());
		aplicacion.setMotivo(dto.getMotivo());
		aplicacion.setNombreAuxEnfermero(dto.getNombreAuxEnfermero());
		aplicacion.setRazonFallecimiento(dto.getRazonFallecimiento());
		aplicacion.setSeguimiento(dto.getSeguimiento());
		return aplicacion;
	}

	public RemicionDto toDto(RemicionEntidad aplicacion) {
		RemicionDto dto = new RemicionDto();
		dto.setAtendido(aplicacion.isAtendido());
		dto.setEntidadRemitida(aplicacion.getEntidadRemitida());
		dto.setFallecido(aplicacion.isFallecido());
		dto.setFechaAtencion(aplicacion.getFechaAtencion());
		dto.setFechaIngreso(aplicacion.getFechaIngreso());
		dto.setFechaRemision(aplicacion.getFechaRemision());
		dto.setFechaSalida(aplicacion.getFechaSalida());
		dto.setHospitalizado(aplicacion.isHospitalizado());
		dto.setId(aplicacion.getId());
		dto.setIdSeguimiento(aplicacion.getIdSeguimiento());
		dto.setMotivo(aplicacion.getMotivo());
		dto.setNombreAuxEnfermero(aplicacion.getNombreAuxEnfermero());
		dto.setRazonFallecimiento(aplicacion.getRazonFallecimiento());
		dto.setSeguimiento(aplicacion.getSeguimiento());
		return dto;
	}

	public com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RemicionEntidad toEntity(
			com.co.comfaoriente.controles.dominio.entidades.RemicionEntidad dominio) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RemicionEntidad entidad = new com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RemicionEntidad();
		entidad.setAtendido(dominio.isAtendido());
		entidad.setEntidadRemitida(dominio.getEntidadRemitida());
		entidad.setFallecido(dominio.isFallecido());
		entidad.setFechaAtencion(dominio.getFechaAtencion());
		entidad.setFechaIngreso(dominio.getFechaIngreso());
		entidad.setFechaRemision(dominio.getFechaRemision());
		entidad.setFechaSalida(dominio.getFechaSalida());
		entidad.setHospitalizado(dominio.isHospitalizado());
		entidad.setId(dominio.getId());
		entidad.setIdSeguimiento(dominio.getIdSeguimiento());
		entidad.setMotivo(dominio.getMotivo());
		entidad.setNombreAuxEnfermero(dominio.getNombreAuxEnfermero());
		entidad.setRazonFallecimiento(dominio.getRazonFallecimiento());
		entidad.setSeguimiento(dominio.getSeguimiento());
		return entidad;
	}

	public com.co.comfaoriente.controles.dominio.entidades.RemicionEntidad toDomain(
			com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RemicionEntidad entidad) {
		com.co.comfaoriente.controles.dominio.entidades.RemicionEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.RemicionEntidad();
		dominio.setAtendido(entidad.isAtendido());
		dominio.setEntidadRemitida(entidad.getEntidadRemitida());
		dominio.setFallecido(entidad.isFallecido());
		dominio.setFechaAtencion(entidad.getFechaAtencion());
		dominio.setFechaIngreso(entidad.getFechaIngreso());
		dominio.setFechaRemision(entidad.getFechaRemision());
		dominio.setFechaSalida(entidad.getFechaSalida());
		dominio.setHospitalizado(entidad.isHospitalizado());
		dominio.setId(entidad.getId());
		dominio.setIdSeguimiento(entidad.getIdSeguimiento());
		dominio.setMotivo(entidad.getMotivo());
		dominio.setNombreAuxEnfermero(entidad.getNombreAuxEnfermero());
		dominio.setRazonFallecimiento(entidad.getRazonFallecimiento());
		dominio.setSeguimiento(entidad.getSeguimiento());
		return dominio;
	}

}
