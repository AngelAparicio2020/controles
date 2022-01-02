package com.co.comfaoriente.controles.aplicacion.entidades;

import java.io.Serializable;
import java.util.Date;

public class UsuarioEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	private int documento;

	private String tipoDocumento;

	private String nombre;

	private String sexo;

	private Date fechaNacimiento;

	private String celular;

	private int edad;

	private String municipio;

	private String direccion;

	private String correoElectronico;

	private String clave;
	
	private Date fechaRegistro;

	private Date fechaIngresoPrograma;

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaIngresoPrograma() {
		return fechaIngresoPrograma;
	}

	public void setFechaIngresoPrograma(Date fechaIngresoPrograma) {
		this.fechaIngresoPrograma = fechaIngresoPrograma;
	}

}
