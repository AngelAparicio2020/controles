package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingreso", schema = "controles")
public class IngresoEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ingreso", nullable = false)
	private int id;
	
	@Column(name = "id_segui_gest_salud", nullable = false)
	private int idSeguimiento;
	
	@Column(name = "afiliacion_sgsss", nullable = false)
	private String afiliacionSgsss;
	
	@Column(name = "salud_oral", nullable = false)
	private String saludOral;
	
	@Column(name = "conoce_urgencias", nullable = false)
	private String conoceUrgencias;
	
	@Column(name = "patologia_identificad_sgsss", nullable = false)
	private boolean patologiaIdentificadaSgsss;
	
	@Column(name = "nombre_patol", nullable = true)
	private String nombrePatologia;
	
	@Column(name = "recibe_medic_formul", nullable = false)
	private boolean recibeMedFormulada;
	
	@Column(name = "nombre_med_formul", nullable = true)
	private String nombreMedFormululada;
	
	@Column(name = "eapb", nullable = false)
	private String eapb;
	
	@Column(name = "ips", nullable = false)
	private String ips;
	
	@Column(name = "usuario_remitido", nullable = false)
	private String usuarioRemitido;
	
	@Column(name = "causa_remit", nullable = true)
	private String causa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSeguimiento() {
		return idSeguimiento;
	}

	public void setIdSeguimiento(int idSeguimiento) {
		this.idSeguimiento = idSeguimiento;
	}

	public String getAfiliacionSgsss() {
		return afiliacionSgsss;
	}

	public void setAfiliacionSgsss(String afiliacionSgsss) {
		this.afiliacionSgsss = afiliacionSgsss;
	}

	public String getSaludOral() {
		return saludOral;
	}

	public void setSaludOral(String saludOral) {
		this.saludOral = saludOral;
	}

	public String getConoceUrgencias() {
		return conoceUrgencias;
	}

	public void setConoceUrgencias(String conoceUrgencias) {
		this.conoceUrgencias = conoceUrgencias;
	}

	public boolean isPatologiaIdentificadaSgsss() {
		return patologiaIdentificadaSgsss;
	}

	public void setPatologiaIdentificadaSgsss(boolean patologiaIdentificadaSgsss) {
		this.patologiaIdentificadaSgsss = patologiaIdentificadaSgsss;
	}

	public String getNombrePatologia() {
		return nombrePatologia;
	}

	public void setNombrePatologia(String nombrePatologia) {
		this.nombrePatologia = nombrePatologia;
	}

	public boolean isRecibeMedFormulada() {
		return recibeMedFormulada;
	}

	public void setRecibeMedFormulada(boolean recibeMedFormulada) {
		this.recibeMedFormulada = recibeMedFormulada;
	}

	public String getNombreMedFormululada() {
		return nombreMedFormululada;
	}

	public void setNombreMedFormululada(String nombreMedFormululada) {
		this.nombreMedFormululada = nombreMedFormululada;
	}

	public String getEapb() {
		return eapb;
	}

	public void setEapb(String eapb) {
		this.eapb = eapb;
	}

	public String getIps() {
		return ips;
	}

	public void setIps(String ips) {
		this.ips = ips;
	}

	public String getUsuarioRemitido() {
		return usuarioRemitido;
	}

	public void setUsuarioRemitido(String usuarioRemitido) {
		this.usuarioRemitido = usuarioRemitido;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}
	
	
	
	

}
