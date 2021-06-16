package com.co.comfaoriente.controles.infraestructura.dtos;

import java.util.Date;

public class SeguimientoSaludDto {

	private int id;

	private int idUsuario;

	private int idUsuarioNutricionista;

	private String nombreAcudiente;

	private String tipoDocAcudiente;

	private int numeroDocAcudiente;

	private Date fecha;

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

	public String getNombreAcudiente() {
		return nombreAcudiente;
	}

	public void setNombreAcudiente(String nombreAcudiente) {
		this.nombreAcudiente = nombreAcudiente;
	}

	public String getTipoDocAcudiente() {
		return tipoDocAcudiente;
	}

	public void setTipoDocAcudiente(String tipoDocAcudiente) {
		this.tipoDocAcudiente = tipoDocAcudiente;
	}

	public int getNumeroDocAcudiente() {
		return numeroDocAcudiente;
	}

	public void setNumeroDocAcudiente(int numeroDocAcudiente) {
		this.numeroDocAcudiente = numeroDocAcudiente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}

}
