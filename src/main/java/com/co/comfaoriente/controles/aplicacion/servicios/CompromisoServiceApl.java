package com.co.comfaoriente.controles.aplicacion.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.aplicacion.entidades.CompromisoEntidad;
import com.co.comfaoriente.controles.aplicacion.mapper.CompromisoMapper;
import com.co.comfaoriente.controles.dominio.servicios.CompromisoService;

@Component
public class CompromisoServiceApl {

	@Autowired
	private CompromisoService compromisoService;
	private static final CompromisoMapper mapper = CompromisoMapper.getInstance();

	public boolean registrarCompromiso(CompromisoEntidad compromiso) {
		return compromisoService.registrarCompromiso(mapper.toDominio(compromiso));
	}

	public CompromisoEntidad consultarCompromiso(int id) {
		return mapper.toAplicacion(this.compromisoService.consultarCompromiso(id));
	}

	public boolean actualizarCompromiso(CompromisoEntidad remicion) {
		com.co.comfaoriente.controles.dominio.entidades.CompromisoEntidad remicionDom = mapper.toDominio(remicion);
		return this.compromisoService.actualizarCompromiso(remicionDom);
	}

	public boolean eliminarCompromiso(int id) {
		return this.compromisoService.eliminarCompromiso(id);
	}
}
