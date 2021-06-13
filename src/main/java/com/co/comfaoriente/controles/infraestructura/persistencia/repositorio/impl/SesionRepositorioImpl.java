package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.dominio.entidades.RolEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.SesionRepositorio;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.RolMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.UsuarioRepositorioJpa;

@Component
public class SesionRepositorioImpl implements SesionRepositorio {

	@Autowired
	private UsuarioRepositorioJpa repositorioJpa;
	private static final RolMapper mapper = RolMapper.getInstance();

	@Override
	public boolean existeUsuario(int documento, String clave) {
		return repositorioJpa.consultarUsuarioLogueado(documento, clave) != null;
	}

	@Override
	public boolean consultarRolesUsuario(int documento, int rol) {
		return repositorioJpa.consultarRolesUsuario(documento, rol) != null;
	}

	@Override
	public List<String> consultarPrivilegios(int rol) {
		return repositorioJpa.consultarPrivilegios(rol);
	}

	@Override
	public List<RolEntidad> listarRoles() {
		List<com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolEntidad> roles = repositorioJpa
				.listarRoles();
		return roles.stream().map(entity -> mapper.toDomain(entity)).collect(Collectors.toList());
	}

}
