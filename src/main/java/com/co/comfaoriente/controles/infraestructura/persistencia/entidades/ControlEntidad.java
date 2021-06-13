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
@Table(name = "control", schema = "controles")
public class ControlEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_control", nullable = false)
	private int id;
	
	@Column(name = "id_usuario", nullable = false)
	private int idUsuario;
	
	@Column(name = "id_usuario_nutricionista", nullable = false)
	private int idUsuarioNutricionista;
	
	@Column(name = "fecha_cont", nullable = false)
	private Date fechaControl;
	
	@Column(name = "peso", nullable = false)
	private int peso;
	
	@Column(name = "talla", nullable = false)
	private int talla;
	
	@Column(name = "imc_calculado", nullable = false)
	private int imc;
	
	@Column(name = "estado_nutric", nullable = false)
	private String estadoNutricional;
	
	@Column(name = "tension", nullable = true)
	private String tension;
	
	@Column(name = "edad_gestacional", nullable = true)
	private int edadGestacional;
	
	@Column(name = "fecha_ulti_cont", nullable = true)
	private Date ultimoControl;
	
	@Column(name = "fecha_prox_cont", nullable = true)
	private Date proximoControl;
	
	@Column(name = "vigente", columnDefinition = "tinyint(1) default 1", nullable = false)
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
