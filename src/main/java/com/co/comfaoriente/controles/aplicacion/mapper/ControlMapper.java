package com.co.comfaoriente.controles.aplicacion.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.ControlEntidad;

public class ControlMapper {

	private ControlMapper() {
	}

	private static final ControlMapper INSTANCE = new ControlMapper();

	public static ControlMapper getInstance() {
		return INSTANCE;
	}

	public ControlEntidad toAplicacion(com.co.comfaoriente.controles.dominio.entidades.ControlEntidad dominio) {
		ControlEntidad aplicacion = new ControlEntidad();
		aplicacion.setId(dominio.getId());
		aplicacion.setEdadGestacional(dominio.getEdadGestacional());
		aplicacion.setEstadoNutricional(dominio.getEstadoNutricional());
		aplicacion.setFechaControl(dominio.getFechaControl());
		aplicacion.setIdUsuario(dominio.getIdUsuario());
		aplicacion.setIdUsuarioNutricionista(dominio.getIdUsuarioNutricionista());
		aplicacion.setImc(dominio.getImc());
		aplicacion.setPeso(dominio.getPeso());
		aplicacion.setProximoControl(dominio.getProximoControl());
		aplicacion.setTalla(dominio.getTalla());
		aplicacion.setTension(dominio.getTension());
		aplicacion.setUltimoControl(dominio.getUltimoControl());
		aplicacion.setVigente(dominio.isVigente());
		return aplicacion;
	}

	public com.co.comfaoriente.controles.dominio.entidades.ControlEntidad toDominio(ControlEntidad aplicacion,
			boolean registrar) {
		com.co.comfaoriente.controles.dominio.entidades.ControlEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.ControlEntidad();
		dominio.setId(registrar ? 0 : aplicacion.getId());
		dominio.setEdadGestacional(aplicacion.getEdadGestacional());
		dominio.setEstadoNutricional(aplicacion.getEstadoNutricional());
		dominio.setFechaControl(aplicacion.getFechaControl());
		dominio.setIdUsuario(aplicacion.getIdUsuario());
		dominio.setIdUsuarioNutricionista(aplicacion.getIdUsuarioNutricionista());
		dominio.setImc(aplicacion.getImc());
		dominio.setPeso(aplicacion.getPeso());
		dominio.setProximoControl(aplicacion.getProximoControl());
		dominio.setTalla(aplicacion.getTalla());
		dominio.setTension(aplicacion.getTension());
		dominio.setUltimoControl(aplicacion.getUltimoControl());
		if (!registrar) {
			dominio.setVigente(aplicacion.isVigente());
		} else {
			dominio.setVigente(true);
		}
		return dominio;
	}

}
