package com.co.comfaoriente.controles.unitarias.dataBuilder;

import java.util.Date;

import com.co.comfaoriente.controles.dominio.entidades.ControlEntidad;

public class ControlBuilder {

	private int id;
	private int idUsuario;
	private int idUsuarioNutricionista;
	private Date fechaControl;
	private int peso;
	private int talla;
	private int imc;
	private String estadoNutricional;
	private String tension;
	private int edadGestacional;
	private Date ultimoControl;
	private Date proximoControl;
	private boolean vigente;

	public ControlBuilder() {
		this.id = 1;
		this.idUsuario = 1093779222;
		this.idUsuarioNutricionista = 1093779223;
	}

	public ControlBuilder conId(int id) {
		this.id = id;
		return this;
	}

	public ControlBuilder conIdUsuario(int id) {
		this.idUsuario = id;
		return this;
	}

	public ControlEntidad build() {
		ControlEntidad control = new ControlEntidad();
		control.setId(this.id);
		control.setEdadGestacional(this.edadGestacional);
		control.setEstadoNutricional(this.estadoNutricional);
		control.setFechaControl(this.fechaControl);
		control.setIdUsuario(this.idUsuario);
		control.setIdUsuarioNutricionista(this.idUsuarioNutricionista);
		control.setImc(this.imc);
		control.setPeso(this.peso);
		control.setProximoControl(proximoControl);
		control.setTalla(this.talla);
		control.setTension(this.tension);
		control.setUltimoControl(this.ultimoControl);
		control.setVigente(this.vigente);
		return control;
	}

}
