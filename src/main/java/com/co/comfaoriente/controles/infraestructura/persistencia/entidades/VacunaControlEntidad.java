package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "vacunas_control", schema = "controles")
@IdClass(value = VacunaControlPK.class)
public class VacunaControlEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_vacuna ", nullable = false)
	private int idVacuna;

	@Id
	@Column(name = "id_control", nullable = false)
	private int idControl;

	@Column(name = "nombre_vacuna")
	private String nombre;

	@Column(name = "edad_meses")
	private int meses;

	@Column(name = "fecha_aplicacion")
	private Date fecha;

	public int getIdVacuna() {
		return idVacuna;
	}

	public void setIdVacuna(int idVacuna) {
		this.idVacuna = idVacuna;
	}

	public int getIdControl() {
		return idControl;
	}

	public void setIdControl(int idControl) {
		this.idControl = idControl;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMeses() {
		return meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "VacunaControlEntidad [idVacuna=" + idVacuna + ", idControl=" + idControl + ", nombre=" + nombre
				+ ", meses=" + meses + ", fecha=" + fecha + "]";
	}
	
	

}
