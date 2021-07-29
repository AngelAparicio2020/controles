package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.dominio.entidades.CompromisoEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.CompromisoRepositorio;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.CompromisoMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.CompromisoRepositorioJpa;

@Component
public class CompromisoRepositorioImpl implements CompromisoRepositorio {

	@Autowired
	private CompromisoRepositorioJpa compromisoRepositorioJpa;
	private static final CompromisoMapper mapper = CompromisoMapper.getInstance();

	@Override
	public boolean registrarCompromiso(CompromisoEntidad compromiso) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.CompromisoEntidad entity = mapper
				.toEntity(compromiso);
		return compromisoRepositorioJpa.save(entity) != null;
	}

	@Override
	public boolean actualizarCompromiso(CompromisoEntidad compromiso) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.CompromisoEntidad entity = mapper
				.toEntity(compromiso);
		return compromisoRepositorioJpa.save(entity) != null;
	}

	@Override
	public boolean eliminarCompromiso(int id) {
		compromisoRepositorioJpa.deleteById(id);
		return !compromisoRepositorioJpa.existsById(id);
	}

	@Override
	public CompromisoEntidad consultarCompromiso(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.CompromisoEntidad entity = compromisoRepositorioJpa
				.consultarCompromiso(id);
		return mapper.toDomain(entity);
	}

	@Override
	public boolean existeCompromiso(int id) {
		return compromisoRepositorioJpa.existsById(id);
	}

	@Override
	public List<CompromisoEntidad> consultarCompromisoxSeguimiento(int id) {
		List<com.co.comfaoriente.controles.infraestructura.persistencia.entidades.CompromisoEntidad> entity = compromisoRepositorioJpa
				.consultarCompromisoxSeguimiento(id);
		return entity.stream().filter(compromiso -> compromiso != null).map(mapper::toDomain).collect(Collectors.toList());
	}

}
