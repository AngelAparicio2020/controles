package com.co.comfaoriente.controles.aplicacion.servicios;

import java.util.Date;
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

	public boolean registrarControl(ControlEntidad control, boolean nutricional) {
		com.co.comfaoriente.controles.dominio.entidades.ControlEntidad controlDom = mapper.toDominio(control, true);
		if (!nutricional) {
			controlDom.setUltimoControl(control.getFechaControl());
			controlDom.setProximoControl(fechaProximoControlCyD(control.getFechaControl(), control.getMeses()));
		} else {
			controlDom.setUltimoControl(null);
			controlDom.setProximoControl(null);
		}
		return controlService.registrarControl(controlDom);
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

	public ControlEntidad ultimoControlCyDxDocumento(int documento) {
		return mapper.toAplicacion(this.controlService.ultimoControlCyDxDocumento(documento));
	}

	@SuppressWarnings("deprecation")
	private Date fechaProximoControlCyD(Date fechaControl, int meses) {
		Date fechaProximoDate;
		int proximoMes = 0;
		if (meses >= 0 && meses <= 12) {
			proximoMes = 3;
		}
		if (meses >= 13 && meses <= 24) {
			proximoMes = 4;
		}
		if (meses >= 25 && meses <= 84) {
			proximoMes = 6;
		}
		if (meses >= 97 && meses <= 108) {
			proximoMes = 12;
		}

		fechaProximoDate = new Date(fechaControl.getYear(), fechaControl.getMonth() + proximoMes,
				fechaControl.getDate());
		return fechaProximoDate;
	}

}
