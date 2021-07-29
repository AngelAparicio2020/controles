package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.dominio.entidades.RemicionEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.RemicionRepositorio;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.RemicionMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.RemicionRepositorioJpa;

@Component
public class RemicionRepositorioImpl implements RemicionRepositorio {

	@Autowired
	private RemicionRepositorioJpa ingresoinfanteRepositorioJpa;
	private static final RemicionMapper mapper = RemicionMapper.getInstance();

	@Override
	public boolean registrarRemicion(RemicionEntidad remicion) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RemicionEntidad entity = mapper
				.toEntity(remicion);
		return ingresoinfanteRepositorioJpa.save(entity) != null;
	}

	@Override
	public boolean actualizarRemicion(RemicionEntidad remicion) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RemicionEntidad entity = mapper
				.toEntity(remicion);
		return ingresoinfanteRepositorioJpa.save(entity) != null;
	}

	@Override
	public boolean eliminarRemicion(int id) {
		ingresoinfanteRepositorioJpa.deleteById(id);
		return !ingresoinfanteRepositorioJpa.existsById(id);
	}

	@Override
	public RemicionEntidad consultarRemicion(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RemicionEntidad entity = ingresoinfanteRepositorioJpa
				.consultarRemicion(id);
		return mapper.toDomain(entity);
	}

	@Override
	public boolean existeRemicion(int id) {
		return ingresoinfanteRepositorioJpa.existsById(id);
	}

	@Override
	public List<RemicionEntidad> consultarRemicionxSeguimiento(int id) {
		List<com.co.comfaoriente.controles.infraestructura.persistencia.entidades.RemicionEntidad> entity = ingresoinfanteRepositorioJpa
				.consultarRemicionxSeguimiento(id);
		return entity.stream().filter(Objects::nonNull).map(mapper::toDomain).collect(Collectors.toList());
	}

}
