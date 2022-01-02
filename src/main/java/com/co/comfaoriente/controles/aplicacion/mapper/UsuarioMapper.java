package com.co.comfaoriente.controles.aplicacion.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.UsuarioEntidad;

public class UsuarioMapper {

	private UsuarioMapper() {
	}

	private static final UsuarioMapper INSTANCE = new UsuarioMapper();

	public static UsuarioMapper getInstance() {
		return INSTANCE;
	}

	public UsuarioEntidad toAplicacion(com.co.comfaoriente.controles.dominio.entidades.UsuarioEntidad dominio) {
		UsuarioEntidad aplicacion = new UsuarioEntidad();
		aplicacion.setCelular(dominio.getCelular());
		aplicacion.setClave(dominio.getClave());
		aplicacion.setCorreoElectronico(dominio.getCorreoElectronico());
		aplicacion.setDireccion(dominio.getDireccion());
		aplicacion.setDocumento(dominio.getDocumento());
		aplicacion.setEdad(dominio.getEdad());
		aplicacion.setFechaNacimiento(dominio.getFechaNacimiento());
		aplicacion.setNombre(dominio.getNombre());
		aplicacion.setMunicipio(dominio.getMunicipio());
		aplicacion.setTipoDocumento(dominio.getTipoDocumento());
		aplicacion.setSexo(dominio.getSexo());
		aplicacion.setFechaRegistro(dominio.getFechaRegistro());
		aplicacion.setFechaIngresoPrograma(dominio.getFechaIngresoPrograma());
		return aplicacion;
	}

	public com.co.comfaoriente.controles.dominio.entidades.UsuarioEntidad toDominio(UsuarioEntidad aplicacion) {
		com.co.comfaoriente.controles.dominio.entidades.UsuarioEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.UsuarioEntidad();
		dominio.setCelular(aplicacion.getCelular());
		dominio.setClave(aplicacion.getClave());
		dominio.setCorreoElectronico(aplicacion.getCorreoElectronico());
		dominio.setDireccion(aplicacion.getDireccion());
		dominio.setDocumento(aplicacion.getDocumento());
		dominio.setEdad(aplicacion.getEdad());
		dominio.setFechaNacimiento(aplicacion.getFechaNacimiento());
		dominio.setNombre(aplicacion.getNombre());
		dominio.setMunicipio(aplicacion.getMunicipio());
		dominio.setTipoDocumento(aplicacion.getTipoDocumento());
		dominio.setSexo(aplicacion.getSexo());
		dominio.setFechaRegistro(aplicacion.getFechaRegistro());
		dominio.setFechaIngresoPrograma(aplicacion.getFechaIngresoPrograma());
		return dominio;
	}

}
