package com.co.comfaoriente.controles.aplicacion.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.aplicacion.entidades.SeguimientoSaludEntidad;
import com.co.comfaoriente.controles.aplicacion.mapper.SeguimientoSaludMapper;
import com.co.comfaoriente.controles.dominio.servicios.SeguimientoSaludService;

@Component
public class SeguimientoSaludServiceApl {

	@Autowired
	private SeguimientoSaludService seguimientoService;
	private static final SeguimientoSaludMapper mapper = SeguimientoSaludMapper.getInstance();

	public boolean registrarSeguimiento(SeguimientoSaludEntidad seguimiento) {
		return seguimientoService.registrarSeguimiento(mapper.toDominio(seguimiento, true));
	}

	public SeguimientoSaludEntidad consultarSeguimiento(int id) {
		return mapper.toAplicacion(this.seguimientoService.consultarSeguimiento(id));
	}

	public boolean actualizarSeguimiento(SeguimientoSaludEntidad seguimiento) {
		com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad seguimientoDom = mapper
				.toDominio(seguimiento, false);
		return this.seguimientoService.actualizarSeguimiento(seguimientoDom);
	}

	public boolean eliminarSeguimiento(int id) {
		return this.seguimientoService.eliminarSeguimiento(id);
	}

}
