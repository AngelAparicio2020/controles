package com.co.comfaoriente.controles.aplicacion.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.SeguimientoSaludEntidad;

public class SeguimientoSaludMapper {

	private SeguimientoSaludMapper() {
	}

	private static final SeguimientoSaludMapper INSTANCE = new SeguimientoSaludMapper();

	public static SeguimientoSaludMapper getInstance() {
		return INSTANCE;
	}

	public SeguimientoSaludEntidad toAplicacion(
			com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad dominio) {
		SeguimientoSaludEntidad aplicacion = new SeguimientoSaludEntidad();
		aplicacion.setId(dominio.getId());
		aplicacion.setFecha(dominio.getFecha());
		aplicacion.setNombreAcudiente(dominio.getNombreAcudiente());
		aplicacion.setNumeroDocAcudiente(dominio.getNumeroDocAcudiente());
		aplicacion.setIdUsuario(dominio.getIdUsuario());
		aplicacion.setIdUsuarioNutricionista(dominio.getIdUsuarioNutricionista());
		aplicacion.setTipoDocAcudiente(dominio.getTipoDocAcudiente());
		aplicacion.setVigente(dominio.isVigente());
		return aplicacion;
	}

	public com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad toDominio(
			SeguimientoSaludEntidad aplicacion, boolean registrar) {
		com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad();
		dominio.setId(registrar ? 0 : aplicacion.getId());
		dominio.setFecha(aplicacion.getFecha());
		dominio.setNombreAcudiente(aplicacion.getNombreAcudiente());
		dominio.setNumeroDocAcudiente(aplicacion.getNumeroDocAcudiente());
		dominio.setIdUsuario(aplicacion.getIdUsuario());
		dominio.setIdUsuarioNutricionista(aplicacion.getIdUsuarioNutricionista());
		dominio.setTipoDocAcudiente(aplicacion.getTipoDocAcudiente());
		if (!registrar) {
			dominio.setVigente(aplicacion.isVigente());
		} else {
			dominio.setVigente(true);
		}
		return dominio;
	}

}
