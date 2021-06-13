package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingresoinfante", schema = "controles")
public class IngresoInfanteEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ingreso_infante", nullable = false)
	private int id;
	
	@Column(name = "id_ingreso", nullable = false)
	private int idIngreso;
	
	@Column(name = "alarma_enfer_prev", nullable = false)
	private String alarmaPreventiva;

	@Column(name = "cuenta_con_contr_cyd", nullable = false)
	private String controlCyD;

	@Column(name = "recibe_suplem", nullable = false)
	private String recibeSuplementos;

	@Column(name = "valor_medica", nullable = true)
	private String valoracionMedica;

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

	public String getAlarmaPreventiva() {
		return alarmaPreventiva;
	}

	public void setAlarmaPreventiva(String alarmaPreventiva) {
		this.alarmaPreventiva = alarmaPreventiva;
	}

	public String getControlCyD() {
		return controlCyD;
	}

	public void setControlCyD(String controlCyD) {
		this.controlCyD = controlCyD;
	}

	public String getRecibeSuplementos() {
		return recibeSuplementos;
	}

	public void setRecibeSuplementos(String recibeSuplementos) {
		this.recibeSuplementos = recibeSuplementos;
	}

	public String getValoracionMedica() {
		return valoracionMedica;
	}

	public void setValoracionMedica(String valoracionMedica) {
		this.valoracionMedica = valoracionMedica;
	}



}
