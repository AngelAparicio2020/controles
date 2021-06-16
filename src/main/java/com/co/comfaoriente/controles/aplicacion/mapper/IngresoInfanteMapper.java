package com.co.comfaoriente.controles.aplicacion.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.IngresoInfanteEntidad;

public class IngresoInfanteMapper {

	private IngresoInfanteMapper() {
	}

	private static final IngresoInfanteMapper INSTANCE = new IngresoInfanteMapper();

	public static IngresoInfanteMapper getInstance() {
		return INSTANCE;
	}

	public IngresoInfanteEntidad toAplicacion(
			com.co.comfaoriente.controles.dominio.entidades.IngresoInfanteEntidad dominio) {
		IngresoInfanteEntidad aplicacion = new IngresoInfanteEntidad();
		aplicacion.setId(dominio.getId());
		aplicacion.setAlarmaPreventiva(dominio.getAlarmaPreventiva());
		aplicacion.setControlCyD(dominio.getControlCyD());
		aplicacion.setIdIngreso(dominio.getIdIngreso());
		aplicacion.setRecibeSuplementos(dominio.getRecibeSuplementos());
		aplicacion.setValoracionMedica(dominio.getValoracionMedica());
		return aplicacion;
	}

	public com.co.comfaoriente.controles.dominio.entidades.IngresoInfanteEntidad toDominio(
			IngresoInfanteEntidad aplicacion) {
		com.co.comfaoriente.controles.dominio.entidades.IngresoInfanteEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.IngresoInfanteEntidad();
		dominio.setId(aplicacion.getId());
		dominio.setAlarmaPreventiva(aplicacion.getAlarmaPreventiva());
		dominio.setControlCyD(aplicacion.getControlCyD());
		dominio.setIdIngreso(aplicacion.getIdIngreso());
		dominio.setRecibeSuplementos(aplicacion.getRecibeSuplementos());
		dominio.setValoracionMedica(aplicacion.getValoracionMedica());
		return dominio;
	}

}
