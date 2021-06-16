package com.co.comfaoriente.controles.infraestructura.persistencia.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.IngresoMadreEntidad;
import com.co.comfaoriente.controles.infraestructura.dtos.IngresoMadreDto;

public class IngresoMadreMapper {

	private IngresoMadreMapper() {
	}

	private static final IngresoMadreMapper INSTANCE = new IngresoMadreMapper();

	public static IngresoMadreMapper getInstance() {
		return INSTANCE;
	}

	public IngresoMadreEntidad toAplicacion(IngresoMadreDto dto) {
		IngresoMadreEntidad aplicacion = new IngresoMadreEntidad();
		aplicacion.setArdorOrinar(dto.getArdorOrinar());
		aplicacion.setCantidadSemanas(dto.getCantidadSemanas());
		aplicacion.setControlPrenatal(dto.getControlPrenatal());
		aplicacion.setCuentaMicro(dto.getCuentaMicro());
		aplicacion.setDolorBocaEstomago(dto.getDolorBocaEstomago());
		aplicacion.setDolorCabeza(dto.getDolorCabeza());
		aplicacion.setExamenMedico(dto.getExamenMedico());
		aplicacion.setFiebre(dto.getFiebre());
		aplicacion.setHinchamiento(dto.getHinchamiento());
		aplicacion.setId(dto.getId());
		aplicacion.setIdIngreso(dto.getIdIngreso());
		aplicacion.setMetodoPlanificacion(dto.getMetodoPlanificacion());
		aplicacion.setMovimientoFetal(dto.getMovimientoFetal());
		aplicacion.setSangrado(dto.getSangrado());
		aplicacion.setSenalPeligro(dto.getSenalPeligro());
		aplicacion.setVomitoControlado(dto.getVomitoControlado());
		return aplicacion;
	}

	public IngresoMadreDto toDto(IngresoMadreEntidad aplicacion) {
		IngresoMadreDto dto = new IngresoMadreDto();
		dto.setArdorOrinar(aplicacion.getArdorOrinar());
		dto.setCantidadSemanas(aplicacion.getCantidadSemanas());
		dto.setControlPrenatal(aplicacion.getControlPrenatal());
		dto.setCuentaMicro(aplicacion.getCuentaMicro());
		dto.setDolorBocaEstomago(aplicacion.getDolorBocaEstomago());
		dto.setDolorCabeza(aplicacion.getDolorCabeza());
		dto.setExamenMedico(aplicacion.getExamenMedico());
		dto.setFiebre(aplicacion.getFiebre());
		dto.setHinchamiento(aplicacion.getHinchamiento());
		dto.setId(aplicacion.getId());
		dto.setIdIngreso(aplicacion.getIdIngreso());
		dto.setMetodoPlanificacion(aplicacion.getMetodoPlanificacion());
		dto.setMovimientoFetal(aplicacion.getMovimientoFetal());
		dto.setSangrado(aplicacion.getSangrado());
		dto.setSenalPeligro(aplicacion.getSenalPeligro());
		dto.setVomitoControlado(aplicacion.getVomitoControlado());
		return dto;
	}

	public com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoMadreEntidad toEntity(
			com.co.comfaoriente.controles.dominio.entidades.IngresoMadreEntidad dominio) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoMadreEntidad entidad = new com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoMadreEntidad();
		entidad.setArdorOrinar(dominio.getArdorOrinar());
		entidad.setCantidadSemanas(dominio.getCantidadSemanas());
		entidad.setControlPrenatal(dominio.getControlPrenatal());
		entidad.setCuentaMicro(dominio.getCuentaMicro());
		entidad.setDolorBocaEstomago(dominio.getDolorBocaEstomago());
		entidad.setDolorCabeza(dominio.getDolorCabeza());
		entidad.setExamenMedico(dominio.getExamenMedico());
		entidad.setFiebre(dominio.getFiebre());
		entidad.setHinchamiento(dominio.getHinchamiento());
		entidad.setId(dominio.getId());
		entidad.setIdIngreso(dominio.getIdIngreso());
		entidad.setMetodoPlanificacion(dominio.getMetodoPlanificacion());
		entidad.setMovimientoFetal(dominio.getMovimientoFetal());
		entidad.setSangrado(dominio.getSangrado());
		entidad.setSenalPeligro(dominio.getSenalPeligro());
		entidad.setVomitoControlado(dominio.getVomitoControlado());
		return entidad;
	}

	public com.co.comfaoriente.controles.dominio.entidades.IngresoMadreEntidad toDomain(
			com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoMadreEntidad entidad) {
		com.co.comfaoriente.controles.dominio.entidades.IngresoMadreEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.IngresoMadreEntidad();
		dominio.setArdorOrinar(entidad.getArdorOrinar());
		dominio.setCantidadSemanas(entidad.getCantidadSemanas());
		dominio.setControlPrenatal(entidad.getControlPrenatal());
		dominio.setCuentaMicro(entidad.getCuentaMicro());
		dominio.setDolorBocaEstomago(entidad.getDolorBocaEstomago());
		dominio.setDolorCabeza(entidad.getDolorCabeza());
		dominio.setExamenMedico(entidad.getExamenMedico());
		dominio.setFiebre(entidad.getFiebre());
		dominio.setHinchamiento(entidad.getHinchamiento());
		dominio.setId(entidad.getId());
		dominio.setIdIngreso(entidad.getIdIngreso());
		dominio.setMetodoPlanificacion(entidad.getMetodoPlanificacion());
		dominio.setMovimientoFetal(entidad.getMovimientoFetal());
		dominio.setSangrado(entidad.getSangrado());
		dominio.setSenalPeligro(entidad.getSenalPeligro());
		dominio.setVomitoControlado(entidad.getVomitoControlado());
		return dominio;
	}

}
