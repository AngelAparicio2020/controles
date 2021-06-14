package com.co.comfaoriente.controles.dominio.servicios;

import java.util.List;

import com.co.comfaoriente.controles.dominio.entidades.RolEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.UnauthorizedException;
import com.co.comfaoriente.controles.dominio.repositorios.SesionRepositorio;

public class SesionService {

	private SesionRepositorio sesionRepositorio;

	public SesionService(SesionRepositorio sesionRepositorio) {
		this.sesionRepositorio = sesionRepositorio;
	}

	public List<String> iniciarSesion(int documento, String clave, int rol) {
		
		if (!sesionRepositorio.existeUsuario(documento, clave)) {
			throw new UnauthorizedException("LA CLAVE O EL USUARIO NO SON CORRECTOS");
		}

		if (!sesionRepositorio.consultarRolesUsuario(documento, rol)) {
			throw new UnauthorizedException("NO TIENE PERMISOS PARA ESTE ROL");

		}
		return sesionRepositorio.consultarPrivilegios(rol);
	}
	
	public List<RolEntidad> listarRoles(){
		return sesionRepositorio.listarRoles();
	}
	
	
	

}
