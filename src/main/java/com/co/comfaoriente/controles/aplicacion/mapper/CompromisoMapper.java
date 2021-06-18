package com.co.comfaoriente.controles.aplicacion.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.CompromisoEntidad;

public class CompromisoMapper {

	private CompromisoMapper() {
	}

	private static final CompromisoMapper INSTANCE = new CompromisoMapper();

	public static CompromisoMapper getInstance() {
		return INSTANCE;
	}

	public CompromisoEntidad toAplicacion(com.co.comfaoriente.controles.dominio.entidades.CompromisoEntidad dominio) {
		CompromisoEntidad aplicacion = new CompromisoEntidad();
		aplicacion.setId(dominio.getId());
		aplicacion.setFechaCompromiso(dominio.getFechaCompromiso());
		aplicacion.setFechaCumplimiento(dominio.getFechaCumplimiento());
		aplicacion.setIdSeguimientoSalud(dominio.getIdSeguimientoSalud());
		aplicacion.setNombre(dominio.getNombre());
		aplicacion.setNombreAuxiliarEnfermeria(dominio.getNombreAuxiliarEnfermeria());
		aplicacion.setTipo(dominio.getTipo());
		aplicacion.setNuevoCompromiso(dominio.getNuevoCompromiso());
		return aplicacion;
	}

	public com.co.comfaoriente.controles.dominio.entidades.CompromisoEntidad toDominio(CompromisoEntidad aplicacion) {
		com.co.comfaoriente.controles.dominio.entidades.CompromisoEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.CompromisoEntidad();
		dominio.setId(aplicacion.getId());
		dominio.setFechaCompromiso(aplicacion.getFechaCompromiso());
		dominio.setFechaCumplimiento(aplicacion.getFechaCumplimiento());
		dominio.setIdSeguimientoSalud(aplicacion.getIdSeguimientoSalud());
		dominio.setNombre(aplicacion.getNombre());
		dominio.setNombreAuxiliarEnfermeria(aplicacion.getNombreAuxiliarEnfermeria());
		dominio.setTipo(aplicacion.getTipo());
		dominio.setNuevoCompromiso(aplicacion.getNuevoCompromiso());
		return dominio;
	}

}
