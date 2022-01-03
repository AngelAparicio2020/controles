package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.dominio.entidades.ControlAdicionalEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.ControlAdicionalRepositorio;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.ControlAdicionalMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.ControlAdicionalRepositorioJpa;

@Component
public class ControlAdicionalRepositorioImpl implements ControlAdicionalRepositorio {

	@Autowired
	private ControlAdicionalRepositorioJpa repositorioJpa;
	private static final ControlAdicionalMapper mapper = ControlAdicionalMapper.getInstance();

	@Override
	public boolean registrarControl(ControlAdicionalEntidad control) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlAdicionalEntidad entity = mapper
				.toEntity(control);
		return repositorioJpa.save(entity) != null;
	}

	@Override
	public boolean actualizarControl(ControlAdicionalEntidad control) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlAdicionalEntidad entity = mapper
				.toEntity(control);
		return repositorioJpa.save(entity) != null;
	}

	@Override
	public boolean eliminarControl(int control) {
		repositorioJpa.deleteById(control);
		return !repositorioJpa.existsById(control);
	}

	@Override
	public ControlAdicionalEntidad consultarControl(int control) {
		Optional<com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlAdicionalEntidad> entity = repositorioJpa
				.findById(control);
		if (entity.isPresent()) {
			return mapper.toDomain(entity.get());
		}
		return null;
	}

	@Override
	public List<ControlAdicionalEntidad> listarControles() {
		List<com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlAdicionalEntidad> entity = StreamSupport
				.stream(repositorioJpa.findAll().spliterator(), false).collect(Collectors.toList());
		return entity.stream().map(mapper::toDomain).collect(Collectors.toList());
	}

	@Override
	public boolean existeControl(int id) {
		return repositorioJpa.existsById(id);
	}

}
