package com.co.comfaoriente.controles.infraestructura.persistencia.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.SeguimientoSaludEntidad;
import com.co.comfaoriente.controles.infraestructura.dtos.SeguimientoSaludDto;

public class SeguimientoSaludMapper {

	private SeguimientoSaludMapper() {
	}

	private static final SeguimientoSaludMapper INSTANCE = new SeguimientoSaludMapper();

	public static SeguimientoSaludMapper getInstance() {
		return INSTANCE;
	}

	public SeguimientoSaludEntidad toAplicacion(SeguimientoSaludDto dto) {
		SeguimientoSaludEntidad aplicacion = new SeguimientoSaludEntidad();
		aplicacion.setId(dto.getId());
		aplicacion.setFecha(dto.getFecha());
		aplicacion.setNombreAcudiente(dto.getNombreAcudiente());
		aplicacion.setNumeroDocAcudiente(dto.getNumeroDocAcudiente());
		aplicacion.setIdUsuario(dto.getIdUsuario());
		aplicacion.setIdUsuarioNutricionista(dto.getIdUsuarioNutricionista());
		aplicacion.setTipoDocAcudiente(dto.getTipoDocAcudiente());
		aplicacion.setVigente(dto.isVigente());
		return aplicacion;
	}

	public SeguimientoSaludDto toDto(SeguimientoSaludEntidad aplicacion) {
		SeguimientoSaludDto dto = new SeguimientoSaludDto();
		dto.setId(aplicacion.getId());
		dto.setFecha(aplicacion.getFecha());
		dto.setNombreAcudiente(aplicacion.getNombreAcudiente());
		dto.setNumeroDocAcudiente(aplicacion.getNumeroDocAcudiente());
		dto.setIdUsuario(aplicacion.getIdUsuario());
		dto.setIdUsuarioNutricionista(aplicacion.getIdUsuarioNutricionista());
		dto.setTipoDocAcudiente(aplicacion.getTipoDocAcudiente());
		dto.setVigente(aplicacion.isVigente());
		return dto;
	}

	public com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad toDomain(
			com.co.comfaoriente.controles.infraestructura.persistencia.entidades.SeguimientoSaludEntidad entity) {
		com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad();
		dominio.setId(entity.getId());
		dominio.setFecha(entity.getFecha());
		dominio.setNombreAcudiente(entity.getNombreAcudiente());
		dominio.setNumeroDocAcudiente(entity.getNumeroDocAcudiente());
		dominio.setIdUsuario(entity.getIdUsuario());
		dominio.setIdUsuarioNutricionista(entity.getIdUsuarioNutricionista());
		dominio.setTipoDocAcudiente(entity.getTipoDocAcudiente());
		dominio.setVigente(entity.isVigente());
		return dominio;
	}

	public com.co.comfaoriente.controles.infraestructura.persistencia.entidades.SeguimientoSaludEntidad toEntity(
			com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad dominio) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.SeguimientoSaludEntidad entity = new com.co.comfaoriente.controles.infraestructura.persistencia.entidades.SeguimientoSaludEntidad();
		entity.setId(dominio.getId());
		entity.setFecha(dominio.getFecha());
		entity.setNombreAcudiente(dominio.getNombreAcudiente());
		entity.setNumeroDocAcudiente(dominio.getNumeroDocAcudiente());
		entity.setIdUsuario(dominio.getIdUsuario());
		entity.setIdUsuarioNutricionista(dominio.getIdUsuarioNutricionista());
		entity.setTipoDocAcudiente(dominio.getTipoDocAcudiente());
		entity.setVigente(dominio.isVigente());
		return entity;
	}

}
