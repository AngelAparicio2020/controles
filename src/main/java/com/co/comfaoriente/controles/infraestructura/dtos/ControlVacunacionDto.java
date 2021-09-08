package com.co.comfaoriente.controles.infraestructura.dtos;

import java.util.Date;
import java.util.List;

import com.co.comfaoriente.controles.dominio.entidades.VacunaEntidad;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaControlEntidad;

public class ControlVacunacionDto {

	private int id;
	private int idUsuario;
	private Date fechaAplicacion;
	private int dosis;
	private int edadGestacional;
	private boolean vigente;
	private List<VacunaControlEntidad> vacunasRegistradas;
	private List<VacunaEntidad> vacunas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFechaAplicacion() {
		return fechaAplicacion;
	}

	public void setFechaAplicacion(Date fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}

	public int getDosis() {
		return dosis;
	}

	public void setDosis(int dosis) {
		this.dosis = dosis;
	}

	public int getEdadGestacional() {
		return edadGestacional;
	}

	public void setEdadGestacional(int edadGestacional) {
		this.edadGestacional = edadGestacional;
	}

	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}

	public List<VacunaControlEntidad> getVacunasRegistradas() {
		return vacunasRegistradas;
	}

	public void setVacunasRegistradas(List<VacunaControlEntidad> vacunasRegistrar) {
		this.vacunasRegistradas = vacunasRegistrar;
	}

	public List<VacunaEntidad> getVacunas() {
		return vacunas;
	}

	public void setVacunas(List<VacunaEntidad> vacunas) {
		this.vacunas = vacunas;
	}

}
