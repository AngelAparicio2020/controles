package com.co.comfaoriente.controles.aplicacion.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.aplicacion.entidades.ControlAdicionalEntidad;
import com.co.comfaoriente.controles.aplicacion.mapper.ControlAdicionalMapper;
import com.co.comfaoriente.controles.dominio.servicios.ControlAdicionalService;

@Component
public class ControlAdicionalServiceApl {
	
	@Autowired(required=true)
	private ControlAdicionalService controlService;
	
	private static final ControlAdicionalMapper mapper = ControlAdicionalMapper.getInstance();
	
	public boolean registrarControl(ControlAdicionalEntidad control) {
		com.co.comfaoriente.controles.dominio.entidades.ControlAdicionalEntidad controlDom = mapper.toDominio(control);
		return this.controlService.registrarControl(controlDom);
	}
	
	public ControlAdicionalEntidad consultarControl(int id) {
		return mapper.toAplicacion(this.controlService.consultarControl(id));
	}

	public boolean actualizarControl(ControlAdicionalEntidad control) {
		com.co.comfaoriente.controles.dominio.entidades.ControlAdicionalEntidad controlDom = mapper.toDominio(control);
		return this.controlService.actualizarControl(controlDom);
	}

	public boolean eliminarControl(int id) {
		return this.controlService.eliminarControl(id);
	}

	public List<ControlAdicionalEntidad> listadoControles(int id) {
		return this.controlService.listadoControles(id).stream().map(dominio -> mapper.toAplicacion(dominio))
				.collect(Collectors.toList());
	}

}
