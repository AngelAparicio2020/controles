package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario", schema = "controles")
public class UsuarioEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "documento", nullable = false)
	private int documento;

	@Column(name = "tipo_documento")
	private String tipoDocumento;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "fecha_nac")
	private Date fechaNacimiento;

	@Column(name = "celular")
	private String celular;

	@Column(name = "edad")
	private int edad;

	@Column(name = "municipio")
	private String municipio;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "correo_electronico")
	private String correoElectronico;

	@Column(name = "clave", nullable = false)
	private String clave;

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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "UsuarioEntidad [documento=" + documento + ", tipoDocumento=" + tipoDocumento + ", nombre=" + nombre
				+ ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", celular=" + celular + ", edad=" + edad
				+ ", municipio=" + municipio + ", direccion=" + direccion + ", correoElectronico=" + correoElectronico
				+ ", clave=" + clave + "]";
	}

}
