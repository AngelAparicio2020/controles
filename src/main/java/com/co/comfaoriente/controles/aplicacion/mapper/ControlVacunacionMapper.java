package com.co.comfaoriente.controles.aplicacion.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.ControlVacunacionEntidad;

public class ControlVacunacionMapper {

	private ControlVacunacionMapper() {
	}

	private static final ControlVacunacionMapper INSTANCE = new ControlVacunacionMapper();

	public static ControlVacunacionMapper getInstance() {
		return INSTANCE;
	}

	public ControlVacunacionEntidad toAplicacion(
			com.co.comfaoriente.controles.dominio.entidades.ControlVacunacionEntidad dominio) {
		ControlVacunacionEntidad aplicacion = new ControlVacunacionEntidad();
		aplicacion.setId(dominio.getId());
		aplicacion.setEdadGestacional(dominio.getEdadGestacional());
		aplicacion.setDosis(dominio.getDosis());
		aplicacion.setFechaAplicacion(dominio.getFechaAplicacion());
		aplicacion.setNombreVacuna(dominio.getNombreVacuna());
		aplicacion.setIdUsuario(dominio.getIdUsuario());
		aplicacion.setVigente(dominio.isVigente());
		return aplicacion;
	}

	public com.co.comfaoriente.controles.dominio.entidades.ControlVacunacionEntidad toDominio(
			ControlVacunacionEntidad aplicacion, boolean registrar) {
		com.co.comfaoriente.controles.dominio.entidades.ControlVacunacionEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.ControlVacunacionEntidad();
		dominio.setId(registrar ? 0 : aplicacion.getId());
		dominio.setEdadGestacional(aplicacion.getEdadGestacional());
		dominio.setDosis(aplicacion.getDosis());
		dominio.setFechaAplicacion(aplicacion.getFechaAplicacion());
		dominio.setNombreVacuna(aplicacion.getNombreVacuna());
		dominio.setIdUsuario(aplicacion.getIdUsuario());
		if (!registrar) {
			dominio.setVigente(aplicacion.isVigente());
		} else {
			dominio.setVigente(true);
		}
		return dominio;
	}

}
