package com.co.comfaoriente.controles.aplicacion.mapper;

import com.co.comfaoriente.controles.aplicacion.entidades.PrivilegioEntidad;
import com.co.comfaoriente.controles.dominio.entidades.RolEntidad;

public class RolMapper {

	private RolMapper() {
	}

	private static final RolMapper INSTANCE = new RolMapper();

	public static RolMapper getInstance() {
		return INSTANCE;
	}

	public com.co.comfaoriente.controles.aplicacion.entidades.RolEntidad toAplication(RolEntidad domain) {
		com.co.comfaoriente.controles.aplicacion.entidades.RolEntidad aplicacion = new com.co.comfaoriente.controles.aplicacion.entidades.RolEntidad();
		aplicacion.setIdRol(domain.getIdRol());
		aplicacion.setNombre(domain.getNombre());
		return aplicacion;
	}
	
	public RolEntidad toDomain(com.co.comfaoriente.controles.aplicacion.entidades.RolEntidad aplicacion) {
		RolEntidad domain = new RolEntidad();
		domain.setIdRol(aplicacion.getIdRol());
		domain.setNombre(aplicacion.getNombre());
		return domain;
	}

	public PrivilegioEntidad privilegiotoAplication(com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad domain) {
		PrivilegioEntidad aplicacion = new PrivilegioEntidad();
		aplicacion.setId(domain.getId());
		aplicacion.setNombre(domain.getNombre());
		return aplicacion;
	}
	
	public com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad privilegiotoDominio(PrivilegioEntidad aplicacion) {
		com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad dominio = new com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad();
		dominio.setId(aplicacion.getId());
		dominio.setNombre(aplicacion.getNombre());
		return dominio;
	}

}
