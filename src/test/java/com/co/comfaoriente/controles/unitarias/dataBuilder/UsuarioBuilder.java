package com.co.comfaoriente.controles.unitarias.dataBuilder;

import java.util.Date;

import com.co.comfaoriente.controles.dominio.entidades.UsuarioEntidad;

public class UsuarioBuilder {

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

	public UsuarioBuilder() {
		this.documento = 1093779232;
		this.nombre = "JOSE SUAREZ";
	}

	public UsuarioBuilder conDocumento(int documento) {
		this.documento = documento;
		return this;
	}

	public UsuarioEntidad build() {
		UsuarioEntidad usuario = new UsuarioEntidad();
		usuario.setCelular(this.celular);
		usuario.setClave(this.clave);
		usuario.setCorreoElectronico(this.correoElectronico);
		usuario.setDireccion(this.direccion);
		usuario.setDocumento(this.documento);
		usuario.setEdad(this.edad);
		usuario.setFechaNacimiento(this.fechaNacimiento);
		usuario.setNombre(this.nombre);
		usuario.setMunicipio(this.municipio);
		usuario.setTipoDocumento(this.tipoDocumento);
		usuario.setSexo(this.sexo);
		usuario.setFechaIngresoPrograma(new Date());
		return usuario;
	}

}
