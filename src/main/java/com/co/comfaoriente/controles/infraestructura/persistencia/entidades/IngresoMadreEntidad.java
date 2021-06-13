package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingresomadregestante", schema = "controles")
public class IngresoMadreEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ingreso_madre", nullable = false)
	private int id;

	@Column(name = "id_ingreso", nullable = false)
	private int idIngreso;

	@Column(name = "control_prenat", nullable = false)
	private String controlPrenatal;

	@Column(name = "semana_gestac", nullable = false)
	private int cantidadSemanas;

	@Column(name = "cuenta_con_micron", nullable = false)
	private String cuentaMicro;

	@Column(name = "examen_medic", nullable = false)
	private String examenMedico;

	@Column(name = "reconoce_senal_pelig", nullable = false)
	private String senalPeligro;

	@Column(name = "metod_planific", nullable = false)
	private String metodoPlanificacion;

	@Column(name = "vomito_cont", nullable = false)
	private String vomitoControlado;

	@Column(name = "dolor_cabeza", nullable = false)
	private String dolorCabeza;

	@Column(name = "fiebre", nullable = false)
	private String fiebre;

	@Column(name = "ardor_orinar", nullable = false)
	private String ardorOrinar;

	@Column(name = "hinchamiento", nullable = false)
	private String hinchamiento;

	@Column(name = "dolor_boca_estom", nullable = false)
	private String dolorBocaEstomago;

	@Column(name = "sangrado", nullable = false)
	private String sangrado;

	@Column(name = "dism_mov_fetal", nullable = false)
	private String movimientoFetal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdIngreso() {
		return idIngreso;
	}

	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
	}

	public String getControlPrenatal() {
		return controlPrenatal;
	}

	public void setControlPrenatal(String controlPrenatal) {
		this.controlPrenatal = controlPrenatal;
	}

	public int getCantidadSemanas() {
		return cantidadSemanas;
	}

	public void setCantidadSemanas(int cantidadSemanas) {
		this.cantidadSemanas = cantidadSemanas;
	}

	public String getCuentaMicro() {
		return cuentaMicro;
	}

	public void setCuentaMicro(String cuentaMicro) {
		this.cuentaMicro = cuentaMicro;
	}

	public String getExamenMedico() {
		return examenMedico;
	}

	public void setExamenMedico(String examenMedico) {
		this.examenMedico = examenMedico;
	}

	public String getSenalPeligro() {
		return senalPeligro;
	}

	public void setSenalPeligro(String senalPeligro) {
		this.senalPeligro = senalPeligro;
	}

	public String getMetodoPlanificacion() {
		return metodoPlanificacion;
	}

	public void setMetodoPlanificacion(String metodoPlanificacion) {
		this.metodoPlanificacion = metodoPlanificacion;
	}

	public String getVomitoControlado() {
		return vomitoControlado;
	}

	public void setVomitoControlado(String vomitoControlado) {
		this.vomitoControlado = vomitoControlado;
	}

	public String getDolorCabeza() {
		return dolorCabeza;
	}

	public void setDolorCabeza(String dolorCabeza) {
		this.dolorCabeza = dolorCabeza;
	}

	public String getFiebre() {
		return fiebre;
	}

	public void setFiebre(String fiebre) {
		this.fiebre = fiebre;
	}

	public String getArdorOrinar() {
		return ardorOrinar;
	}

	public void setArdorOrinar(String ardorOrinar) {
		this.ardorOrinar = ardorOrinar;
	}

	public String getHinchamiento() {
		return hinchamiento;
	}

	public void setHinchamiento(String hinchamiento) {
		this.hinchamiento = hinchamiento;
	}

	public String getDolorBocaEstomago() {
		return dolorBocaEstomago;
	}

	public void setDolorBocaEstomago(String dolorBocaEstomago) {
		this.dolorBocaEstomago = dolorBocaEstomago;
	}

	public String getSangrado() {
		return sangrado;
	}

	public void setSangrado(String sangrado) {
		this.sangrado = sangrado;
	}

	public String getMovimientoFetal() {
		return movimientoFetal;
	}

	public void setMovimientoFetal(String movimientoFetal) {
		this.movimientoFetal = movimientoFetal;
	}

}
