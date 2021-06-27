package com.co.comfaoriente.controles.dominio.entidades;

import java.io.Serializable;

public class VacunaEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private int meses;

	private String nombre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMeses() {
		return meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
