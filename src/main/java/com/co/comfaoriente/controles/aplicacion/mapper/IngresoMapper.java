package com.co.comfaoriente.controles.aplicacion.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.IngresoEntidad;

public class IngresoMapper {

	private IngresoMapper() {
	}

	private static final IngresoMapper INSTANCE = new IngresoMapper();

	public static IngresoMapper getInstance() {
		return INSTANCE;
	}

	public IngresoEntidad toAplicacion(com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad dominio) {
		IngresoEntidad aplicacion = new IngresoEntidad();
		aplicacion.setAfiliacionSgsss(dominio.getAfiliacionSgsss());
		aplicacion.setCausa(dominio.getCausa());
		aplicacion.setConoceUrgencias(dominio.getConoceUrgencias());
		aplicacion.setEapb(dominio.getEapb());
		aplicacion.setId(dominio.getId());
		aplicacion.setIdSeguimiento(dominio.getIdSeguimiento());
		aplicacion.setIps(dominio.getIps());
		aplicacion.setNombreMedFormululada(dominio.getNombreMedFormululada());
		aplicacion.setNombrePatologia(dominio.getNombrePatologia());
		aplicacion.setPatologiaIdentificadaSgsss(dominio.isPatologiaIdentificadaSgsss());
		aplicacion.setRecibeMedFormulada(dominio.isRecibeMedFormulada());
		aplicacion.setSaludOral(dominio.getSaludOral());
		aplicacion.setUsuarioRemitido(dominio.getUsuarioRemitido());
		return aplicacion;
	}

	public com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad toDominio(IngresoEntidad aplicacion) {
		com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad();
		dominio.setAfiliacionSgsss(aplicacion.getAfiliacionSgsss());
		dominio.setCausa(aplicacion.getCausa());
		dominio.setConoceUrgencias(aplicacion.getConoceUrgencias());
		dominio.setEapb(aplicacion.getEapb());
		dominio.setId(aplicacion.getId());
		dominio.setIdSeguimiento(aplicacion.getIdSeguimiento());
		dominio.setIps(aplicacion.getIps());
		dominio.setNombreMedFormululada(aplicacion.getNombreMedFormululada());
		dominio.setNombrePatologia(aplicacion.getNombrePatologia());
		dominio.setPatologiaIdentificadaSgsss(aplicacion.isPatologiaIdentificadaSgsss());
		dominio.setRecibeMedFormulada(aplicacion.isRecibeMedFormulada());
		dominio.setSaludOral(aplicacion.getSaludOral());
		dominio.setUsuarioRemitido(aplicacion.getUsuarioRemitido());
		return dominio;
	}

}
