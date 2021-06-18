package com.co.comfaoriente.controles.aplicacion.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.RemicionEntidad;

public class RemicionMapper {

	private RemicionMapper() {
	}

	private static final RemicionMapper INSTANCE = new RemicionMapper();

	public static RemicionMapper getInstance() {
		return INSTANCE;
	}

	public RemicionEntidad toAplicacion(com.co.comfaoriente.controles.dominio.entidades.RemicionEntidad dominio) {
		RemicionEntidad aplicacion = new RemicionEntidad();
		aplicacion.setAtendido(dominio.isAtendido());
		aplicacion.setEntidadRemitida(dominio.getEntidadRemitida());
		aplicacion.setFallecido(dominio.isFallecido());
		aplicacion.setFechaAtencion(dominio.getFechaAtencion());
		aplicacion.setFechaIngreso(dominio.getFechaIngreso());
		aplicacion.setFechaRemision(dominio.getFechaRemision());
		aplicacion.setFechaSalida(dominio.getFechaSalida());
		aplicacion.setHospitalizado(dominio.isHospitalizado());
		aplicacion.setId(dominio.getId());
		aplicacion.setIdSeguimiento(dominio.getIdSeguimiento());
		aplicacion.setMotivo(dominio.getMotivo());
		aplicacion.setNombreAuxEnfermero(dominio.getNombreAuxEnfermero());
		aplicacion.setRazonFallecimiento(dominio.getRazonFallecimiento());
		aplicacion.setSeguimiento(dominio.getSeguimiento());
		return aplicacion;
	}

	public com.co.comfaoriente.controles.dominio.entidades.RemicionEntidad toDominio(RemicionEntidad aplicacion,
			boolean registrar) {
		com.co.comfaoriente.controles.dominio.entidades.RemicionEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.RemicionEntidad();
		dominio.setAtendido(aplicacion.isAtendido());
		dominio.setEntidadRemitida(aplicacion.getEntidadRemitida());
		dominio.setFallecido(aplicacion.isFallecido());
		dominio.setFechaAtencion(aplicacion.getFechaAtencion());
		dominio.setFechaIngreso(aplicacion.getFechaIngreso());
		dominio.setFechaRemision(aplicacion.getFechaRemision());
		dominio.setFechaSalida(aplicacion.getFechaSalida());
		dominio.setHospitalizado(aplicacion.isHospitalizado());
		dominio.setId(registrar ? 0 : aplicacion.getId());
		dominio.setIdSeguimiento(aplicacion.getIdSeguimiento());
		dominio.setMotivo(aplicacion.getMotivo());
		dominio.setNombreAuxEnfermero(aplicacion.getNombreAuxEnfermero());
		dominio.setRazonFallecimiento(aplicacion.getRazonFallecimiento());
		dominio.setSeguimiento(aplicacion.getSeguimiento());
		return dominio;
	}

}
