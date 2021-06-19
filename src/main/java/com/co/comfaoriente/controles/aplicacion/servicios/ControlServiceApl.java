package com.co.comfaoriente.controles.aplicacion.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.aplicacion.entidades.ControlEntidad;
import com.co.comfaoriente.controles.aplicacion.mapper.ControlMapper;
import com.co.comfaoriente.controles.dominio.servicios.ControlService;

@Component
public class ControlServiceApl {

	@Autowired
	private ControlService controlService;
	private static final ControlMapper mapper = ControlMapper.getInstance();

	public boolean registrarControl(ControlEntidad control) {
		return controlService.registrarControl(mapper.toDominio(control, true));
	}

	public ControlEntidad consultarControl(int id) {
		return mapper.toAplicacion(this.controlService.consultarControl(id));
	}

	public boolean actualizarControl(ControlEntidad control) {
		com.co.comfaoriente.controles.dominio.entidades.ControlEntidad controlDom = mapper.toDominio(control, false);
		return this.controlService.actualizarControl(controlDom);
	}

	public boolean eliminarControl(int id) {
		return this.controlService.eliminarControl(id);
	}

	public List<ControlEntidad> listadoControlesCyD(int id) {
		return this.controlService.listadoControlesCyD(id).stream().map(dominio -> mapper.toAplicacion(dominio))
				.collect(Collectors.toList());
	}

	public List<ControlEntidad> listadoControlesNutricionales(int id) {
		return this.controlService.listadoControlesNutricionales(id).stream()
				.map(dominio -> mapper.toAplicacion(dominio)).collect(Collectors.toList());
	}

	public ControlEntidad ultimoControlCyD(int id, int idNutricionista) {
		return mapper.toAplicacion(this.controlService.ultimoControlCyD(id, idNutricionista));
	}

	public ControlEntidad ultimoControlNutricional(int id, int idNutricionista) {
		return mapper.toAplicacion(this.controlService.ultimoControlNutricional(id, idNutricionista));
	}

}
