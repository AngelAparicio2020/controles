package com.co.comfaoriente.controles.aplicacion.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.aplicacion.entidades.ControlVacunacionEntidad;
import com.co.comfaoriente.controles.aplicacion.mapper.ControlVacunacionMapper;
import com.co.comfaoriente.controles.dominio.entidades.VacunaEntidad;
import com.co.comfaoriente.controles.dominio.servicios.ControlVacunacionService;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaControlEntidad;

@Component
public class ControlVacunacionServiceApl {

	@Autowired
	private ControlVacunacionService controlService;
	private static final ControlVacunacionMapper mapper = ControlVacunacionMapper.getInstance();

	public boolean registrarControl(ControlVacunacionEntidad control, List<VacunaEntidad> vacunas) {
		if (vacunas != null && !vacunas.isEmpty()) {
			controlService.registrarControl(mapper.toDominio(control, true));
			int controlRegistrado = controlService.consultarUltimoControl(control.getIdUsuario());
			return controlService.asignarVacunasaControl(vacunas, controlRegistrado, control.getFechaAplicacion());
		} else {
			return controlService.registrarControl(mapper.toDominio(control, true));
		}

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

	public List<ControlVacunacionEntidad> listadoControlesVacunacion(int idUsuario) {
		return this.controlService.listadoControlesVacunacion(idUsuario).stream()
				.map(dominio -> mapper.toAplicacion(dominio)).collect(Collectors.toList());
	}

	public List<VacunaEntidad> consultarVacunasXedad(int meses) {
		return controlService.consultarVacunasXedad(meses);
	}

	public boolean eliminarVacuna(int control, int vacuna) {
		return this.controlService.eliminarVacuna(control, vacuna);
	}

	public List<VacunaControlEntidad> consultarVacunasxControl(int control) {
		return this.controlService.consultarVacunasxControl(control);
	}

	public List<VacunaControlEntidad> listarControlesxDocumento(int documento) {
		List<VacunaControlEntidad> vacunas = new ArrayList<>();
		this.controlService.listarControlesxDocumento(documento).stream()
				.forEach(idControl -> vacunas.addAll(this.controlService.consultarVacunasxControl(idControl)));
		return vacunas;
	}

}
