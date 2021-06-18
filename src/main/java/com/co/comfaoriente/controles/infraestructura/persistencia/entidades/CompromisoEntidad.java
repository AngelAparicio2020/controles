package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compromiso", schema = "controles")
public class CompromisoEntidad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compromiso", nullable = false)
	private int id;
	
	@Column(name = "id_segui_gest_salud", nullable = false)
	private int idSeguimientoSalud;
	
	@Column(name = "fecha_comp", nullable = false)
	private Date fechaCompromiso;
	
	@Column(name = "nombre_compro", nullable = false)
	private String nombre;
	
	@Column(name = "nuevo_comp", nullable = false)
	private String nuevoCompromiso;
	
	@Column(name = "fecha_cumplim", nullable = true)
	private Date fechaCumplimiento;
	
	@Column(name = "nombre_aux_enfer", nullable = true)
	private String nombreAuxiliarEnfermeria;
	
	@Column(name = "tipo_compromiso", nullable = true)
	private String tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSeguimientoSalud() {
		return idSeguimientoSalud;
	}

	public void setIdSeguimientoSalud(int idSeguimientoSalud) {
		this.idSeguimientoSalud = idSeguimientoSalud;
	}

	public Date getFechaCompromiso() {
		return fechaCompromiso;
	}

	public void setFechaCompromiso(Date fechaCompromiso) {
		this.fechaCompromiso = fechaCompromiso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNuevoCompromiso() {
		return nuevoCompromiso;
	}

	public void setNuevoCompromiso(String nuevoCompromiso) {
		this.nuevoCompromiso = nuevoCompromiso;
	}

	public Date getFechaCumplimiento() {
		return fechaCumplimiento;
	}

	public void setFechaCumplimiento(Date fechaCumplimiento) {
		this.fechaCumplimiento = fechaCumplimiento;
	}

	public String getNombreAuxiliarEnfermeria() {
		return nombreAuxiliarEnfermeria;
	}

	public void setNombreAuxiliarEnfermeria(String nombreAuxiliarEnfermeria) {
		this.nombreAuxiliarEnfermeria = nombreAuxiliarEnfermeria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
	

}
