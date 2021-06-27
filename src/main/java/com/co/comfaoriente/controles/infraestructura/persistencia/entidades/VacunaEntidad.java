package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vacuna", schema = "controles")
public class VacunaEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_vacuna")
	private int id;

	@Column(name = "edad_meses")
	private int meses;

	@Column(name = "nombre_vacuna")
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
