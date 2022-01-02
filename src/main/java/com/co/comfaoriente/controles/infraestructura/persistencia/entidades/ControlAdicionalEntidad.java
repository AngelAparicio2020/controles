package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "controles_adicionales", schema = "controles")
public class ControlAdicionalEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "id_usuario", nullable = false)
	private int idUsuario;

	@Column(name = "nombre_proceso", nullable = false)
	private String nombreProceso;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@Column(name = "nombre_profesional", nullable = false)
	private String nombreProfesional;

	@Column(name = "tipo_control", nullable = false)
	private int tipoControl;

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

	public String getNombreProceso() {
		return nombreProceso;
	}

	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreProfesional() {
		return nombreProfesional;
	}

	public void setNombreProfesional(String nombreProfesional) {
		this.nombreProfesional = nombreProfesional;
	}

	public int getTipoControl() {
		return tipoControl;
	}

	public void setTipoControl(int tipoControl) {
		this.tipoControl = tipoControl;
	}

	@Override
	public String toString() {
		return "ControlesAdicionalesEntidad [id=" + id + ", idUsuario=" + idUsuario + ", nombreProceso=" + nombreProceso
				+ ", descripcion=" + descripcion + ", nombreProfesional=" + nombreProfesional + ", tipoControl="
				+ tipoControl + "]";
	}

}
