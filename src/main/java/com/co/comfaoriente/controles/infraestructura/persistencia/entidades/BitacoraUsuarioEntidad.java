package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bitacora_usuarios", schema = "controles")
public class BitacoraUsuarioEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "id_usuario", nullable = false)
	private int idUsuario;

	@Column(name = "accion", nullable = false)
	private boolean accion;

	@Column(name = "nombre_usuario", nullable = false)
	private String nombreUsuario;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@Column(name = "documento_aprobador", nullable = false)
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

	@Override
	public String toString() {
		return "BitacoraUsuarioEntidad [id=" + id + ", idUsuario=" + idUsuario + ", accion=" + accion
				+ ", nombreUsuario=" + nombreUsuario + ", descripcion=" + descripcion + ", documentoAprobador="
				+ documentoAprobador + "]";
	}
	
	
}
