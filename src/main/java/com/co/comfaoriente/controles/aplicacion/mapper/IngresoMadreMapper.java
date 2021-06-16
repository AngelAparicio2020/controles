package com.co.comfaoriente.controles.aplicacion.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.IngresoMadreEntidad;

public class IngresoMadreMapper {

	private IngresoMadreMapper() {
	}

	private static final IngresoMadreMapper INSTANCE = new IngresoMadreMapper();

	public static IngresoMadreMapper getInstance() {
		return INSTANCE;
	}

	public IngresoMadreEntidad toAplicacion(
			com.co.comfaoriente.controles.dominio.entidades.IngresoMadreEntidad dominio) {
		IngresoMadreEntidad aplicacion = new IngresoMadreEntidad();
		aplicacion.setArdorOrinar(dominio.getArdorOrinar());
		aplicacion.setCantidadSemanas(dominio.getCantidadSemanas());
		aplicacion.setControlPrenatal(dominio.getControlPrenatal());
		aplicacion.setCuentaMicro(dominio.getCuentaMicro());
		aplicacion.setDolorBocaEstomago(dominio.getDolorBocaEstomago());
		aplicacion.setDolorCabeza(dominio.getDolorCabeza());
		aplicacion.setExamenMedico(dominio.getExamenMedico());
		aplicacion.setFiebre(dominio.getFiebre());
		aplicacion.setHinchamiento(dominio.getHinchamiento());
		aplicacion.setId(dominio.getId());
		aplicacion.setIdIngreso(dominio.getIdIngreso());
		aplicacion.setMetodoPlanificacion(dominio.getMetodoPlanificacion());
		aplicacion.setMovimientoFetal(dominio.getMovimientoFetal());
		aplicacion.setSangrado(dominio.getSangrado());
		aplicacion.setSenalPeligro(dominio.getSenalPeligro());
		aplicacion.setVomitoControlado(dominio.getVomitoControlado());
		return aplicacion;
	}

	public com.co.comfaoriente.controles.dominio.entidades.IngresoMadreEntidad toDominio(
			IngresoMadreEntidad aplicacion) {
		com.co.comfaoriente.controles.dominio.entidades.IngresoMadreEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.IngresoMadreEntidad();
		dominio.setArdorOrinar(aplicacion.getArdorOrinar());
		dominio.setCantidadSemanas(aplicacion.getCantidadSemanas());
		dominio.setControlPrenatal(aplicacion.getControlPrenatal());
		dominio.setCuentaMicro(aplicacion.getCuentaMicro());
		dominio.setDolorBocaEstomago(aplicacion.getDolorBocaEstomago());
		dominio.setDolorCabeza(aplicacion.getDolorCabeza());
		dominio.setExamenMedico(aplicacion.getExamenMedico());
		dominio.setFiebre(aplicacion.getFiebre());
		dominio.setHinchamiento(aplicacion.getHinchamiento());
		dominio.setId(aplicacion.getId());
		dominio.setIdIngreso(aplicacion.getIdIngreso());
		dominio.setMetodoPlanificacion(aplicacion.getMetodoPlanificacion());
		dominio.setMovimientoFetal(aplicacion.getMovimientoFetal());
		dominio.setSangrado(aplicacion.getSangrado());
		dominio.setSenalPeligro(aplicacion.getSenalPeligro());
		dominio.setVomitoControlado(aplicacion.getVomitoControlado());
		return dominio;
	}

}
