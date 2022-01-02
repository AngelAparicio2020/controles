package com.co.comfaoriente.controles.infraestructura.persistencia.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.BitacoraUsuarioEntidad;
import com.co.comfaoriente.controles.infraestructura.dtos.BitacoraUsuarioDto;

public class BitacoraUsuarioMapper {

	private BitacoraUsuarioMapper() {
	}

	private static final BitacoraUsuarioMapper INSTANCE = new BitacoraUsuarioMapper();

	public static BitacoraUsuarioMapper getInstance() {
		return INSTANCE;
	}

	public BitacoraUsuarioEntidad toAplicacion(BitacoraUsuarioDto dto) {
		BitacoraUsuarioEntidad aplicacion = new BitacoraUsuarioEntidad();
		if (dto != null) {
			aplicacion.setAccion(dto.isAccion());
			aplicacion.setDescripcion(dto.getDescripcion());
			aplicacion.setDocumentoAprobador(dto.getDocumentoAprobador());
			aplicacion.setId(dto.getId());
			aplicacion.setIdUsuario(dto.getIdUsuario());
			aplicacion.setNombreUsuario(dto.getNombreUsuario());
		}
		return aplicacion;
	}

	public BitacoraUsuarioDto toDto(BitacoraUsuarioEntidad aplicacion) {
		BitacoraUsuarioDto dto = new BitacoraUsuarioDto();
		if (aplicacion != null) {
			dto.setAccion(aplicacion.isAccion());
			dto.setDescripcion(aplicacion.getDescripcion());
			dto.setDocumentoAprobador(aplicacion.getDocumentoAprobador());
			dto.setId(aplicacion.getId());
			dto.setIdUsuario(aplicacion.getIdUsuario());
			dto.setNombreUsuario(aplicacion.getNombreUsuario());
		}
		return dto;
	}

	public com.co.comfaoriente.controles.dominio.entidades.BitacoraUsuarioEntidad toDomain(
			com.co.comfaoriente.controles.infraestructura.persistencia.entidades.BitacoraUsuarioEntidad entity) {
		com.co.comfaoriente.controles.dominio.entidades.BitacoraUsuarioEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.BitacoraUsuarioEntidad();
		if (entity != null) {
			dominio.setAccion(entity.isAccion());
			dominio.setDescripcion(entity.getDescripcion());
			dominio.setDocumentoAprobador(entity.getDocumentoAprobador());
			dominio.setId(entity.getId());
			dominio.setIdUsuario(entity.getIdUsuario());
			dominio.setNombreUsuario(entity.getNombreUsuario());
		}
		return dominio;
	}

	public com.co.comfaoriente.controles.infraestructura.persistencia.entidades.BitacoraUsuarioEntidad toEntity(
			com.co.comfaoriente.controles.dominio.entidades.BitacoraUsuarioEntidad dominio) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.BitacoraUsuarioEntidad entity = new com.co.comfaoriente.controles.infraestructura.persistencia.entidades.BitacoraUsuarioEntidad();
		if (dominio != null) {
			entity.setAccion(dominio.isAccion());
			entity.setDescripcion(dominio.getDescripcion());
			entity.setDocumentoAprobador(dominio.getDocumentoAprobador());
			entity.setId(dominio.getId());
			entity.setIdUsuario(dominio.getIdUsuario());
			entity.setNombreUsuario(dominio.getNombreUsuario());
		}
		return entity;
	}

}
