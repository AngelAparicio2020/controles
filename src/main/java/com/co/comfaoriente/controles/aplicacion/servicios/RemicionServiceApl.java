package com.co.comfaoriente.controles.aplicacion.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.aplicacion.entidades.RemicionEntidad;
import com.co.comfaoriente.controles.aplicacion.mapper.RemicionMapper;
import com.co.comfaoriente.controles.dominio.servicios.RemicionService;

@Component
public class RemicionServiceApl {

	@Autowired
	private RemicionService remicionService;
	private static final RemicionMapper mapper = RemicionMapper.getInstance();

	public boolean registrarRemicion(RemicionEntidad remicion) {
		return remicionService.registrarRemicion(mapper.toDominio(remicion, true));
	}

	public RemicionEntidad consultarRemicion(int id) {
		return mapper.toAplicacion(this.remicionService.consultarRemicion(id));
	}

	public boolean actualizarRemicion(RemicionEntidad remicion) {
		com.co.comfaoriente.controles.dominio.entidades.RemicionEntidad remicionDom = mapper.toDominio(remicion, false);
		return this.remicionService.actualizarRemicion(remicionDom);
	}

	public boolean eliminarRemicion(int id) {
		return this.remicionService.eliminarRemicion(id);
	}

}
