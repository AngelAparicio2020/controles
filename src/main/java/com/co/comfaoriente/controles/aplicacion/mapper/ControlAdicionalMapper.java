package com.co.comfaoriente.controles.aplicacion.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.ControlAdicionalEntidad;

public class ControlAdicionalMapper {

	private ControlAdicionalMapper() {
	}

	private static final ControlAdicionalMapper INSTANCE = new ControlAdicionalMapper();

	public static ControlAdicionalMapper getInstance() {
		return INSTANCE;
	}

	public ControlAdicionalEntidad toAplicacion(com.co.comfaoriente.controles.dominio.entidades.ControlAdicionalEntidad dominio) {
		ControlAdicionalEntidad aplicacion = new ControlAdicionalEntidad();
		aplicacion.setDescripcion(dominio.getDescripcion());
		aplicacion.setId(dominio.getId());
		aplicacion.setIdUsuario(dominio.getIdUsuario());
		aplicacion.setNombreProceso(dominio.getNombreProceso());
		aplicacion.setNombreProfesional(dominio.getNombreProfesional());
		aplicacion.setTipoControl(dominio.getTipoControl());
		return aplicacion;
	}

	public com.co.comfaoriente.controles.dominio.entidades.ControlAdicionalEntidad toDominio(ControlAdicionalEntidad aplicacion) {
		com.co.comfaoriente.controles.dominio.entidades.ControlAdicionalEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.ControlAdicionalEntidad();
		dominio.setDescripcion(aplicacion.getDescripcion());
		dominio.setId(aplicacion.getId());
		dominio.setIdUsuario(aplicacion.getIdUsuario());
		dominio.setNombreProceso(aplicacion.getNombreProceso());
		dominio.setNombreProfesional(aplicacion.getNombreProfesional());
		dominio.setTipoControl(aplicacion.getTipoControl());
		return dominio;
	}

}
