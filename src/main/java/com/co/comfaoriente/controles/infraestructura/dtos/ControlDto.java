package com.co.comfaoriente.controles.infraestructura.dtos;

import java.util.Date;

public class ControlDto {

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

	public int getIdUsuarioNutricionista() {
		return idUsuarioNutricionista;
	}

	public void setIdUsuarioNutricionista(int idUsuarioNutricionista) {
		this.idUsuarioNutricionista = idUsuarioNutricionista;
	}

	public Date getFechaControl() {
		return fechaControl;
	}

	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getTalla() {
		return talla;
	}

	public void setTalla(int talla) {
		this.talla = talla;
	}

	public int getImc() {
		return imc;
	}

	public void setImc(int imc) {
		this.imc = imc;
	}

	public String getEstadoNutricional() {
		return estadoNutricional;
	}

	public void setEstadoNutricional(String estadoNutricional) {
		this.estadoNutricional = estadoNutricional;
	}

	public String getTension() {
		return tension;
	}

	public void setTension(String tension) {
		this.tension = tension;
	}

	public int getEdadGestacional() {
		return edadGestacional;
	}

	public void setEdadGestacional(int edadGestacional) {
		this.edadGestacional = edadGestacional;
	}

	public Date getUltimoControl() {
		return ultimoControl;
	}

	public void setUltimoControl(Date ultimoControl) {
		this.ultimoControl = ultimoControl;
	}

	public Date getProximoControl() {
		return proximoControl;
	}

	public void setProximoControl(Date proximoControl) {
		this.proximoControl = proximoControl;
	}

	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}

}
