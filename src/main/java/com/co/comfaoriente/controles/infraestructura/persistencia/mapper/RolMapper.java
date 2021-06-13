package com.co.comfaoriente.controles.infraestructura.persistencia.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.co.comfaoriente.controles.aplicacion.entidades.PrivilegioAsociadoEntidad;
import com.co.comfaoriente.controles.dominio.entidades.RolEntidad;
import com.co.comfaoriente.controles.infraestructura.dtos.PrivilegioAsociadoDto;
import com.co.comfaoriente.controles.infraestructura.dtos.PrivilegioDto;
import com.co.comfaoriente.controles.infraestructura.dtos.RolDto;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.PrivilegioEntidad;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolPrivilegioEntidad;

public class RolMapper {

	private RolMapper() {
	}

	private static final RolMapper INSTANCE = new RolMapper();

	public static RolMapper getInstance() {
		return INSTANCE;
	}

	public RolEntidad toDomain(com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolEntidad entity) {
		RolEntidad domain = new RolEntidad();
		domain.setIdRol(entity.getIdRol());
		domain.setNombre(entity.getNombre());
		return domain;
	}

	public com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolEntidad toEntity(RolEntidad domain) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolEntidad entity = new com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolEntidad();
		entity.setIdRol(domain.getIdRol());
		entity.setNombre(domain.getNombre());
		return entity;
	}

	public RolDto toDto(com.co.comfaoriente.controles.aplicacion.entidades.RolEntidad aplicacion) {
		RolDto dto = new RolDto();
		dto.setIdRol(aplicacion.getIdRol());
		dto.setNombre(aplicacion.getNombre());
		return dto;
	}

	public com.co.comfaoriente.controles.aplicacion.entidades.RolEntidad toAplicacion(RolDto dto) {
		com.co.comfaoriente.controles.aplicacion.entidades.RolEntidad aplicacion = new com.co.comfaoriente.controles.aplicacion.entidades.RolEntidad();
		aplicacion.setIdRol(dto.getIdRol());
		aplicacion.setNombre(dto.getNombre());
		return aplicacion;
	}

	public com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad privilegioRolToDomain(
			RolPrivilegioEntidad entity) {
		com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad domain = new com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad();
		domain.setId(entity.getIdPrivilegio());
		domain.setNombre(entity.getNombre());
		return domain;
	}

	public com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad privilegioToDomain(
			PrivilegioEntidad entity) {
		com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad domain = new com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad();
		domain.setId(entity.getId());
		domain.setNombre(entity.getNombre());
		return domain;
	}

	public RolPrivilegioEntidad privilegioRolToEntity(
			com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad domain, int rol) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolPrivilegioEntidad entity = new com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolPrivilegioEntidad();
		entity.setIdPrivilegio(domain.getId());
		entity.setNombre(domain.getNombre());
		entity.setIdRol(rol);
		return entity;
	}

	public PrivilegioAsociadoEntidad privilegioRolToAplicacion(PrivilegioAsociadoDto info) {
		PrivilegioAsociadoEntidad datos = new PrivilegioAsociadoEntidad();
		List<com.co.comfaoriente.controles.aplicacion.entidades.PrivilegioEntidad> privilegios = info.getPrivilegios()
				.stream().map(dto -> privilegioToAplicacion(dto)).collect(Collectors.toList());
		com.co.comfaoriente.controles.aplicacion.entidades.RolEntidad rolApl = toAplicacion(info.getRol());
		datos.setPrivilegios(privilegios);
		datos.setRol(rolApl);
		return datos;
	}

	public PrivilegioAsociadoDto privilegioRolToDto(PrivilegioAsociadoEntidad info) {
		PrivilegioAsociadoDto datos = new PrivilegioAsociadoDto();
		List<PrivilegioDto> privilegios = info.getPrivilegios().stream().map(aplicacion -> privilegioToDto(aplicacion))
				.collect(Collectors.toList());
		RolDto rolApl = toDto(info.getRol());
		datos.setPrivilegios(privilegios);
		datos.setRol(rolApl);
		return datos;
	}

	public PrivilegioDto privilegioToDto(
			com.co.comfaoriente.controles.aplicacion.entidades.PrivilegioEntidad aplicacion) {
		PrivilegioDto privilegio = new PrivilegioDto();
		privilegio.setId(aplicacion.getId());
		privilegio.setNombre(aplicacion.getNombre());
		return privilegio;
	}

	public com.co.comfaoriente.controles.aplicacion.entidades.PrivilegioEntidad privilegioToAplicacion(
			PrivilegioDto aplicacion) {
		com.co.comfaoriente.controles.aplicacion.entidades.PrivilegioEntidad privilegio = new com.co.comfaoriente.controles.aplicacion.entidades.PrivilegioEntidad();
		privilegio.setId(aplicacion.getId());
		privilegio.setNombre(aplicacion.getNombre());
		return privilegio;
	}

}
