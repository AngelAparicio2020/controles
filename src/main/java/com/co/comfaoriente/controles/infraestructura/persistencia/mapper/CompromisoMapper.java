package com.co.comfaoriente.controles.infraestructura.persistencia.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.CompromisoEntidad;
import com.co.comfaoriente.controles.infraestructura.dtos.CompromisoDto;

public class CompromisoMapper {

	private CompromisoMapper() {
	}

	private static final CompromisoMapper INSTANCE = new CompromisoMapper();

	public static CompromisoMapper getInstance() {
		return INSTANCE;
	}

	public CompromisoEntidad toAplicacion(CompromisoDto dto, boolean registrar) {
		CompromisoEntidad aplicacion = new CompromisoEntidad();
		aplicacion.setId(registrar ? 0 : dto.getId());
		aplicacion.setFechaCompromiso(dto.getFechaCompromiso());
		aplicacion.setFechaCumplimiento(dto.getFechaCumplimiento());
		aplicacion.setIdSeguimientoSalud(dto.getIdSeguimientoSalud());
		aplicacion.setNombre(dto.getNombre());
		aplicacion.setNombreAuxiliarEnfermeria(dto.getNombreAuxiliarEnfermeria());
		aplicacion.setTipo(dto.getTipo());
		aplicacion.setNuevoCompromiso(dto.getNuevoCompromiso());
		return aplicacion;
	}

	public CompromisoDto toDto(CompromisoEntidad aplicacion) {
		CompromisoDto dto = new CompromisoDto();
		dto.setId(aplicacion.getId());
		dto.setFechaCompromiso(aplicacion.getFechaCompromiso());
		dto.setFechaCumplimiento(aplicacion.getFechaCumplimiento());
		dto.setIdSeguimientoSalud(aplicacion.getIdSeguimientoSalud());
		dto.setNombre(aplicacion.getNombre());
		dto.setNombreAuxiliarEnfermeria(aplicacion.getNombreAuxiliarEnfermeria());
		dto.setTipo(aplicacion.getTipo());
		dto.setNuevoCompromiso(aplicacion.getNuevoCompromiso());
		return dto;
	}

	public com.co.comfaoriente.controles.dominio.entidades.CompromisoEntidad toDomain(
			com.co.comfaoriente.controles.infraestructura.persistencia.entidades.CompromisoEntidad entity) {
		com.co.comfaoriente.controles.dominio.entidades.CompromisoEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.CompromisoEntidad();
		dominio.setId(entity.getId());
		dominio.setFechaCompromiso(entity.getFechaCompromiso());
		dominio.setFechaCumplimiento(entity.getFechaCumplimiento());
		dominio.setIdSeguimientoSalud(entity.getIdSeguimientoSalud());
		dominio.setNombre(entity.getNombre());
		dominio.setNombreAuxiliarEnfermeria(entity.getNombreAuxiliarEnfermeria());
		dominio.setTipo(entity.getTipo());
		dominio.setNuevoCompromiso(entity.getNuevoCompromiso());
		return dominio;
	}

	public com.co.comfaoriente.controles.infraestructura.persistencia.entidades.CompromisoEntidad toEntity(
			com.co.comfaoriente.controles.dominio.entidades.CompromisoEntidad dominio) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.CompromisoEntidad entity = new com.co.comfaoriente.controles.infraestructura.persistencia.entidades.CompromisoEntidad();
		entity.setId(dominio.getId());
		entity.setFechaCompromiso(dominio.getFechaCompromiso());
		entity.setFechaCumplimiento(dominio.getFechaCumplimiento());
		entity.setIdSeguimientoSalud(dominio.getIdSeguimientoSalud());
		entity.setNombre(dominio.getNombre());
		entity.setNombreAuxiliarEnfermeria(dominio.getNombreAuxiliarEnfermeria());
		entity.setTipo(dominio.getTipo());
		entity.setNuevoCompromiso(dominio.getNuevoCompromiso());
		return entity;
	}

}
