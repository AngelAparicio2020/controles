package com.co.comfaoriente.controles.aplicacion.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.aplicacion.entidades.RolEntidad;
import com.co.comfaoriente.controles.aplicacion.mapper.RolMapper;
import com.co.comfaoriente.controles.dominio.servicios.SesionService;

@Component
public class SesionServiceApl {

	@Autowired
	private SesionService sesionService;
	private static final RolMapper mapper = RolMapper.getInstance();

	public List<String> iniciarSesion(int documento, String clave, int rol) {
		return sesionService.iniciarSesion(documento, clave, rol);
	}

	public List<RolEntidad> listarRoles() {
		List<com.co.comfaoriente.controles.dominio.entidades.RolEntidad> roles = sesionService.listarRoles();
		return roles.stream().map(domain -> mapper.toAplication(domain)).collect(Collectors.toList());
	}

}
