package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad;
import com.co.comfaoriente.controles.dominio.entidades.RolEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.RolRepositorio;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolPrivilegioEntidad;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolUsuarioEntidad;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolUsuarioPK;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.RolMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.PrivilegioRepositorioJpa;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.RolRepositorioJpa;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.RolUsuarioRepositorioJpa;

@Component
public class RolRepositorioImpl implements RolRepositorio {

	@Autowired
	private RolRepositorioJpa repositorioJpa;
	@Autowired
	private PrivilegioRepositorioJpa repositorioPriJpa;
	@Autowired
	private RolUsuarioRepositorioJpa repositorioUsuJpa;

	private static final RolMapper mapper = RolMapper.getInstance();

	@Override
	public boolean registrarRol(RolEntidad rol) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolEntidad entity = mapper.toEntity(rol);
		return repositorioJpa.save(entity) != null;
	}

	@Override
	public boolean eliminarRol(int rol) {
		repositorioJpa.deleteById(rol);
		return !repositorioJpa.existsById(rol);
	}

	@Override
	public boolean asignarPrivilegio(List<PrivilegioEntidad> privilegios, int rol) {
		List<RolPrivilegioEntidad> entities = privilegios.stream()
				.map(domain -> mapper.privilegioRolToEntity(domain, rol)).collect(Collectors.toList());
		return repositorioPriJpa.saveAll(entities) != null;
	}

	@Override
	public RolEntidad consultarRol(int rol) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolEntidad entity = repositorioJpa
				.consultarRol(rol);
		return mapper.toDomain(entity);
	}

	@Override
	public List<PrivilegioEntidad> consultarPrivilegiosxRol(int rol) {
		List<com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolPrivilegioEntidad> entity = repositorioPriJpa
				.consultarPrivilegiosxRol(rol);
		return entity.stream().map(mapper::privilegioRolToDomain).collect(Collectors.toList());
	}

	@Override
	public List<PrivilegioEntidad> consultarPrivilegios() {
		List<com.co.comfaoriente.controles.infraestructura.persistencia.entidades.PrivilegioEntidad> entity = repositorioPriJpa
				.consultarPrivilegios();
		return entity.stream().map(mapper::privilegioToDomain).collect(Collectors.toList());
	}

	@Override
	public boolean actualizarRol(RolEntidad rol) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RolEntidad entity = mapper.toEntity(rol);
		return repositorioJpa.save(entity) != null;
	}

	@Override
	public boolean asignarRol(int documento, int rol) {
		RolUsuarioEntidad entity = new RolUsuarioEntidad();
		entity.setDocumento(documento);
		entity.setIdRol(rol);
		return repositorioUsuJpa.save(entity) != null;
	}

	@Override
	public List<RolUsuarioEntidad> consultarRolUsuario(int documento) {
		return repositorioUsuJpa.consultarRolesUsuario(documento);
	}

	@Override
	public boolean existeRol(int rol) {
		return repositorioJpa.existsById(rol);
	}

	@Override
	public boolean retirarRol(int documento, int rol) {
		RolUsuarioEntidad entity = new RolUsuarioEntidad();
		RolUsuarioPK pk = new RolUsuarioPK(rol, documento);
		entity.setDocumento(documento);
		entity.setIdRol(rol);
		repositorioUsuJpa.delete(entity);
		return !repositorioUsuJpa.existsById(pk);
	}

}
