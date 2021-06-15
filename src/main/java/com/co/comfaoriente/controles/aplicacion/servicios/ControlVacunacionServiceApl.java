package com.co.comfaoriente.controles.aplicacion.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.aplicacion.entidades.ControlVacunacionEntidad;
import com.co.comfaoriente.controles.aplicacion.mapper.ControlVacunacionMapper;
import com.co.comfaoriente.controles.dominio.servicios.ControlVacunacionService;

@Component
public class ControlVacunacionServiceApl {

	@Autowired
	private ControlVacunacionService controlService;
	private static final ControlVacunacionMapper mapper = ControlVacunacionMapper.getInstance();

	public boolean registrarControl(ControlVacunacionEntidad control) {
		System.out.println("control = " + control.isVigente());
		return controlService.registrarControl(mapper.toDominio(control, true));
	}

	public ControlVacunacionEntidad consultarControl(int id) {
		return mapper.toAplicacion(this.controlService.consultarControl(id));
	}

	public boolean actualizarControl(ControlVacunacionEntidad control) {
		com.co.comfaoriente.controles.dominio.entidades.ControlVacunacionEntidad controlDom = mapper.toDominio(control,
				false);
		return this.controlService.actualizarControl(controlDom);
	}

	public boolean eliminarControl(int id) {
		return this.controlService.eliminarControl(id);
	}

}
