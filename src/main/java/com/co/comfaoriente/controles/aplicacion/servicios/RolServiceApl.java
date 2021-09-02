package com.co.comfaoriente.controles.aplicacion.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.aplicacion.entidades.PrivilegioAsociadoEntidad;
import com.co.comfaoriente.controles.aplicacion.entidades.PrivilegioEntidad;
import com.co.comfaoriente.controles.aplicacion.entidades.RolEntidad;
import com.co.comfaoriente.controles.aplicacion.mapper.RolMapper;
import com.co.comfaoriente.controles.dominio.servicios.RolService;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolUsuarioEntidad;

@Component
public class RolServiceApl {

	@Autowired
	private RolService rolService;
	private static final RolMapper mapper = RolMapper.getInstance();

	public boolean actualizarRol(PrivilegioAsociadoEntidad datos) {
		List<com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad> privilegios = datos
				.getPrivilegios() == null ? new ArrayList<>()
						: datos.getPrivilegios().stream().map(aplicacion -> mapper.privilegiotoDominio(aplicacion))
								.collect(Collectors.toList());
		com.co.comfaoriente.controles.dominio.entidades.RolEntidad rol = mapper.toDomain(datos.getRol());
		if (rolService.actualizarRol(rol)) {
			return rolService.asignarPrivilegios(privilegios, datos.getRol().getIdRol());
		}
		return false;

	}

	public boolean eliminarRol(int rol) {
		return rolService.eliminarRol(rol);
	}

	public PrivilegioAsociadoEntidad consultarRol(int rol) {
		PrivilegioAsociadoEntidad datos = new PrivilegioAsociadoEntidad();
		List<PrivilegioEntidad> privilegios = rolService.consultarPrivilegiosxRol(rol).stream()
				.map(domain -> mapper.privilegiotoAplication(domain)).collect(Collectors.toList());
		RolEntidad rolApl = mapper.toAplication(rolService.consultarRol(rol));
		datos.setPrivilegios(privilegios);
		datos.setRol(rolApl);
		return datos;
	}

	public boolean registrarRol(PrivilegioAsociadoEntidad datos) {
		List<com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad> privilegios = datos
				.getPrivilegios() == null ? new ArrayList<>()
						: datos.getPrivilegios().stream().map(aplicacion -> mapper.privilegiotoDominio(aplicacion))
								.collect(Collectors.toList());
		com.co.comfaoriente.controles.dominio.entidades.RolEntidad rol = mapper.toDomain(datos.getRol());
		if (rolService.registrarRol(rol)) {
			return rolService.asignarPrivilegios(privilegios, datos.getRol().getIdRol());
		}
		return false;
	}

	public List<PrivilegioEntidad> consultarPrivilegios() {
		return rolService.consultarPrivilegios().stream().map(domain -> mapper.privilegiotoAplication(domain))
				.collect(Collectors.toList());
	}

	public boolean asignarRol(int documento, int rol) {
		return rolService.asignarRol(documento, rol);
	}

	public boolean retirarRol(int documento, int rol) {
		return rolService.retirarRol(documento, rol);
	}

	public List<RolUsuarioEntidad> consultarRolesUsuario(int documento) {
		return rolService.consultarRolesUsuario(documento);
	}

}
