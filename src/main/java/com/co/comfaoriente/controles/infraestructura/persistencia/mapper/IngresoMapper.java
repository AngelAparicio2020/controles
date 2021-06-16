package com.co.comfaoriente.controles.infraestructura.persistencia.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.IngresoEntidad;
import com.co.comfaoriente.controles.infraestructura.dtos.IngresoDto;

public class IngresoMapper {

	private IngresoMapper() {
	}

	private static final IngresoMapper INSTANCE = new IngresoMapper();

	public static IngresoMapper getInstance() {
		return INSTANCE;
	}

	public IngresoEntidad toAplicacion(IngresoDto dto) {
		IngresoEntidad aplicacion = new IngresoEntidad();
		aplicacion.setAfiliacionSgsss(dto.getAfiliacionSgsss());
		aplicacion.setCausa(dto.getCausa());
		aplicacion.setConoceUrgencias(dto.getConoceUrgencias());
		aplicacion.setEapb(dto.getEapb());
		aplicacion.setId(dto.getId());
		aplicacion.setIdSeguimiento(dto.getIdSeguimiento());
		aplicacion.setIps(dto.getIps());
		aplicacion.setNombreMedFormululada(dto.getNombreMedFormululada());
		aplicacion.setNombrePatologia(dto.getNombrePatologia());
		aplicacion.setPatologiaIdentificadaSgsss(dto.isPatologiaIdentificadaSgsss());
		aplicacion.setRecibeMedFormulada(dto.isRecibeMedFormulada());
		aplicacion.setSaludOral(dto.getSaludOral());
		aplicacion.setUsuarioRemitido(dto.getUsuarioRemitido());
		return aplicacion;
	}

	public IngresoDto toDto(IngresoEntidad aplicacion) {
		IngresoDto dto = new IngresoDto();
		dto.setAfiliacionSgsss(aplicacion.getAfiliacionSgsss());
		dto.setCausa(aplicacion.getCausa());
		dto.setConoceUrgencias(aplicacion.getConoceUrgencias());
		dto.setEapb(aplicacion.getEapb());
		dto.setId(aplicacion.getId());
		dto.setIdSeguimiento(aplicacion.getIdSeguimiento());
		dto.setIps(aplicacion.getIps());
		dto.setNombreMedFormululada(aplicacion.getNombreMedFormululada());
		dto.setNombrePatologia(aplicacion.getNombrePatologia());
		dto.setPatologiaIdentificadaSgsss(aplicacion.isPatologiaIdentificadaSgsss());
		dto.setRecibeMedFormulada(aplicacion.isRecibeMedFormulada());
		dto.setSaludOral(aplicacion.getSaludOral());
		dto.setUsuarioRemitido(aplicacion.getUsuarioRemitido());
		return dto;
	}

	public com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoEntidad toEntity(
			com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad dominio) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoEntidad entidad = new com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoEntidad();
		entidad.setAfiliacionSgsss(dominio.getAfiliacionSgsss());
		entidad.setCausa(dominio.getCausa());
		entidad.setConoceUrgencias(dominio.getConoceUrgencias());
		entidad.setEapb(dominio.getEapb());
		entidad.setId(dominio.getId());
		entidad.setIdSeguimiento(dominio.getIdSeguimiento());
		entidad.setIps(dominio.getIps());
		entidad.setNombreMedFormululada(dominio.getNombreMedFormululada());
		entidad.setNombrePatologia(dominio.getNombrePatologia());
		entidad.setPatologiaIdentificadaSgsss(dominio.isPatologiaIdentificadaSgsss());
		entidad.setRecibeMedFormulada(dominio.isRecibeMedFormulada());
		entidad.setSaludOral(dominio.getSaludOral());
		entidad.setUsuarioRemitido(dominio.getUsuarioRemitido());
		return entidad;
	}

	public com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad toDomain(
			com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoEntidad entidad) {
		com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad();
		dominio.setAfiliacionSgsss(entidad.getAfiliacionSgsss());
		dominio.setCausa(entidad.getCausa());
		dominio.setConoceUrgencias(entidad.getConoceUrgencias());
		dominio.setEapb(entidad.getEapb());
		dominio.setId(entidad.getId());
		dominio.setIdSeguimiento(entidad.getIdSeguimiento());
		dominio.setIps(entidad.getIps());
		dominio.setNombreMedFormululada(entidad.getNombreMedFormululada());
		dominio.setNombrePatologia(entidad.getNombrePatologia());
		dominio.setPatologiaIdentificadaSgsss(entidad.isPatologiaIdentificadaSgsss());
		dominio.setRecibeMedFormulada(entidad.isRecibeMedFormulada());
		dominio.setSaludOral(entidad.getSaludOral());
		dominio.setUsuarioRemitido(entidad.getUsuarioRemitido());
		return dominio;
	}

}
