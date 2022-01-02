package com.co.comfaoriente.controles.dominio.entidades;

import java.io.Serializable;

public class BitacoraUsuarioEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int idUsuario;
	private boolean accion;
	private String nombreUsuario;
	private String descripcion;
	private String documentoAprobador;

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

	public boolean isAccion() {
		return accion;
	}

	public void setAccion(boolean accion) {
		this.accion = accion;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDocumentoAprobador() {
		return documentoAprobador;
	}

	public void setDocumentoAprobador(String documentoAprobador) {
		this.documentoAprobador = documentoAprobador;
	}
	
	
}
