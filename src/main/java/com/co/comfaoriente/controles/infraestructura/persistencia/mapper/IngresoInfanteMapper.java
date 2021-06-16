package com.co.comfaoriente.controles.infraestructura.persistencia.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.IngresoInfanteEntidad;
import com.co.comfaoriente.controles.infraestructura.dtos.IngresoInfanteDto;

public class IngresoInfanteMapper {

	private IngresoInfanteMapper() {
	}

	private static final IngresoInfanteMapper INSTANCE = new IngresoInfanteMapper();

	public static IngresoInfanteMapper getInstance() {
		return INSTANCE;
	}

	public IngresoInfanteEntidad toAplicacion(IngresoInfanteDto dto) {
		IngresoInfanteEntidad aplicacion = new IngresoInfanteEntidad();
		aplicacion.setId(dto.getId());
		aplicacion.setAlarmaPreventiva(dto.getAlarmaPreventiva());
		aplicacion.setControlCyD(dto.getControlCyD());
		aplicacion.setIdIngreso(dto.getIdIngreso());
		aplicacion.setRecibeSuplementos(dto.getRecibeSuplementos());
		aplicacion.setValoracionMedica(dto.getValoracionMedica());
		return aplicacion;
	}

	public IngresoInfanteDto toDto(IngresoInfanteEntidad aplicacion) {
		IngresoInfanteDto dto = new IngresoInfanteDto();
		dto.setId(aplicacion.getId());
		dto.setAlarmaPreventiva(aplicacion.getAlarmaPreventiva());
		dto.setControlCyD(aplicacion.getControlCyD());
		dto.setIdIngreso(aplicacion.getIdIngreso());
		dto.setRecibeSuplementos(aplicacion.getRecibeSuplementos());
		dto.setValoracionMedica(aplicacion.getValoracionMedica());
		return dto;
	}

	public com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoInfanteEntidad toEntity(
			com.co.comfaoriente.controles.dominio.entidades.IngresoInfanteEntidad dominio) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoInfanteEntidad entidad = new com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoInfanteEntidad();
		entidad.setId(dominio.getId());
		entidad.setAlarmaPreventiva(dominio.getAlarmaPreventiva());
		entidad.setControlCyD(dominio.getControlCyD());
		entidad.setIdIngreso(dominio.getIdIngreso());
		entidad.setRecibeSuplementos(dominio.getRecibeSuplementos());
		entidad.setValoracionMedica(dominio.getValoracionMedica());
		return entidad;
	}

	public com.co.comfaoriente.controles.dominio.entidades.IngresoInfanteEntidad toDomain(
			com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoInfanteEntidad entidad) {
		com.co.comfaoriente.controles.dominio.entidades.IngresoInfanteEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.IngresoInfanteEntidad();
		dominio.setId(entidad.getId());
		dominio.setAlarmaPreventiva(entidad.getAlarmaPreventiva());
		dominio.setControlCyD(entidad.getControlCyD());
		dominio.setIdIngreso(entidad.getIdIngreso());
		dominio.setRecibeSuplementos(entidad.getRecibeSuplementos());
		dominio.setValoracionMedica(entidad.getValoracionMedica());
		return dominio;
	}

}
