package com.co.comfaoriente.controles.dominio.entidades;

import java.util.Date;
import java.util.List;

import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaControlEntidad;

public class ControlVacunacionEntidad {

	private int id;
	private int idUsuario;
	private Date fechaAplicacion;
	private int dosis;
	private int edadGestacional;
	private boolean vigente;
	private String nombreVacuna;
	private List<VacunaControlEntidad> vacunas;

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

	public List<VacunaControlEntidad> getVacunas() {
		return vacunas;
	}

	public void setVacunas(List<VacunaControlEntidad> vacunas) {
		this.vacunas = vacunas;
	}

	public String getNombreVacuna() {
		return nombreVacuna;
	}

	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}
	
	

}
