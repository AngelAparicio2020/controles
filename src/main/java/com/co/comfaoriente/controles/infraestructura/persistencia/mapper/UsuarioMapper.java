package com.co.comfaoriente.controles.infraestructura.persistencia.mapper;

import java.security.MessageDigest;
import java.util.Formatter;

import com.co.comfaoriente.controles.aplicacion.entidades.UsuarioEntidad;
import com.co.comfaoriente.controles.infraestructura.dtos.UsuarioDto;

public class UsuarioMapper {

	private UsuarioMapper() {
	}

	private static final UsuarioMapper INSTANCE = new UsuarioMapper();

	public static UsuarioMapper getInstance() {
		return INSTANCE;
	}

	public UsuarioEntidad toAplicacion(UsuarioDto dto) {
		UsuarioEntidad aplicacion = new UsuarioEntidad();
		aplicacion.setCelular(dto.getCelular());
		aplicacion.setClave(dto.getClave());
		aplicacion.setCorreoElectronico(dto.getCorreoElectronico());
		aplicacion.setDireccion(dto.getDireccion());
		aplicacion.setDocumento(dto.getDocumento());
		aplicacion.setEdad(dto.getEdad());
		aplicacion.setFechaNacimiento(dto.getFechaNacimiento());
		aplicacion.setNombre(dto.getNombre());
		aplicacion.setMunicipio(dto.getMunicipio());
		aplicacion.setTipoDocumento(dto.getTipoDocumento());
		aplicacion.setSexo(dto.getSexo());
		aplicacion.setFechaRegistro(dto.getFechaRegistro());
		aplicacion.setFechaIngresoPrograma(dto.getFechaIngresoPrograma());
		return aplicacion;
	}

	public UsuarioDto toDto(UsuarioEntidad aplicacion) {
		UsuarioDto dto = new UsuarioDto();
		dto.setCelular(aplicacion.getCelular());
		dto.setClave(aplicacion.getClave());
		dto.setCorreoElectronico(aplicacion.getCorreoElectronico());
		dto.setDireccion(aplicacion.getDireccion());
		dto.setDocumento(aplicacion.getDocumento());
		dto.setEdad(aplicacion.getEdad());
		dto.setFechaNacimiento(aplicacion.getFechaNacimiento());
		dto.setNombre(aplicacion.getNombre());
		dto.setMunicipio(aplicacion.getMunicipio());
		dto.setTipoDocumento(aplicacion.getTipoDocumento());
		dto.setSexo(aplicacion.getSexo());
		dto.setFechaRegistro(aplicacion.getFechaRegistro());
		dto.setFechaIngresoPrograma(aplicacion.getFechaIngresoPrograma());
		return dto;
	}

	public com.co.comfaoriente.controles.infraestructura.persistencia.entidades.UsuarioEntidad toEntity(
			com.co.comfaoriente.controles.dominio.entidades.UsuarioEntidad dominio, boolean registrar) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.UsuarioEntidad entidad = new com.co.comfaoriente.controles.infraestructura.persistencia.entidades.UsuarioEntidad();
		entidad.setCelular(dominio.getCelular());
		entidad.setClave(dominio.getClave());
		entidad.setCorreoElectronico(dominio.getCorreoElectronico());
		entidad.setDireccion(dominio.getDireccion());
		entidad.setDocumento(dominio.getDocumento());
		entidad.setEdad(dominio.getEdad());
		entidad.setFechaNacimiento(dominio.getFechaNacimiento());
		entidad.setNombre(dominio.getNombre());
		entidad.setMunicipio(dominio.getMunicipio());
		entidad.setTipoDocumento(dominio.getTipoDocumento());
		entidad.setSexo(dominio.getSexo());
		entidad.setFechaRegistro(dominio.getFechaRegistro());
		entidad.setFechaIngresoPrograma(dominio.getFechaIngresoPrograma());
		return entidad;
	}

	public com.co.comfaoriente.controles.dominio.entidades.UsuarioEntidad toDomain(
			com.co.comfaoriente.controles.infraestructura.persistencia.entidades.UsuarioEntidad entidad) {
		com.co.comfaoriente.controles.dominio.entidades.UsuarioEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.UsuarioEntidad();
		dominio.setCelular(entidad.getCelular());
		dominio.setClave(entidad.getClave());
		dominio.setCorreoElectronico(entidad.getCorreoElectronico());
		dominio.setDireccion(entidad.getDireccion());
		dominio.setDocumento(entidad.getDocumento());
		dominio.setEdad(entidad.getEdad());
		dominio.setFechaNacimiento(entidad.getFechaNacimiento());
		dominio.setNombre(entidad.getNombre());
		dominio.setMunicipio(entidad.getMunicipio());
		dominio.setTipoDocumento(entidad.getTipoDocumento());
		dominio.setSexo(entidad.getSexo());
		dominio.setFechaRegistro(entidad.getFechaRegistro());
		dominio.setFechaIngresoPrograma(entidad.getFechaIngresoPrograma());
		return dominio;
	}

	private static String encryptPassword(String password) {
		String sha1 = "";
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(password.getBytes("UTF-8"));
			sha1 = byteToHex(crypt.digest());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sha1;
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

}
