package com.co.comfaoriente.controles.unitarias.dataBuilder;

import java.util.Date;

import com.co.comfaoriente.controles.dominio.entidades.ControlVacunacionEntidad;

public class ControlVacunacionBuilder {

	private int id;
	private int idUsuario;
	private String nombreVacuna;
	private Date fechaAplicacion;
	private int dosis;
	private int edadGestacional;
	private boolean vigente;

	public ControlVacunacionBuilder() {
		this.id = 1;
		this.idUsuario = 1093779222;
	}

	public ControlVacunacionBuilder conId(int id) {
		this.id = id;
		return this;
	}

	public ControlVacunacionBuilder conIdUsuario(int id) {
		this.idUsuario = id;
		return this;
	}

	public ControlVacunacionEntidad build() {
		ControlVacunacionEntidad control = new ControlVacunacionEntidad();
		control.setDosis(dosis);
		control.setEdadGestacional(edadGestacional);
		control.setFechaAplicacion(fechaAplicacion);
		control.setId(id);
		control.setIdUsuario(idUsuario);
		control.setNombreVacuna(nombreVacuna);
		control.setVigente(vigente);
		return control;
	}

}
