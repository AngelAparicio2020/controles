package com.co.comfaoriente.controles.aplicacion.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.BitacoraUsuarioEntidad;

public class BitacoraUsuarioMapper {

	private BitacoraUsuarioMapper() {
	}

	private static final BitacoraUsuarioMapper INSTANCE = new BitacoraUsuarioMapper();

	public static BitacoraUsuarioMapper getInstance() {
		return INSTANCE;
	}

	public BitacoraUsuarioEntidad toAplicacion(com.co.comfaoriente.controles.dominio.entidades.BitacoraUsuarioEntidad dominio) {
		BitacoraUsuarioEntidad aplicacion = new BitacoraUsuarioEntidad();
		aplicacion.setAccion(dominio.isAccion());
		aplicacion.setDescripcion(dominio.getDescripcion());
		aplicacion.setDocumentoAprobador(dominio.getDocumentoAprobador());
		aplicacion.setId(dominio.getId());
		aplicacion.setIdUsuario(dominio.getIdUsuario());
		aplicacion.setNombreUsuario(dominio.getNombreUsuario());
		aplicacion.setFechaCambio(dominio.getFechaCambio());
		return aplicacion;
	}

	public com.co.comfaoriente.controles.dominio.entidades.BitacoraUsuarioEntidad toDominio(BitacoraUsuarioEntidad aplicacion) {
		com.co.comfaoriente.controles.dominio.entidades.BitacoraUsuarioEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.BitacoraUsuarioEntidad();
		dominio.setAccion(aplicacion.isAccion());
		dominio.setDescripcion(aplicacion.getDescripcion());
		dominio.setDocumentoAprobador(aplicacion.getDocumentoAprobador());
		dominio.setId(aplicacion.getId());
		dominio.setIdUsuario(aplicacion.getIdUsuario());
		dominio.setNombreUsuario(aplicacion.getNombreUsuario());
		dominio.setFechaCambio(aplicacion.getFechaCambio());
		return dominio;
	}

}
