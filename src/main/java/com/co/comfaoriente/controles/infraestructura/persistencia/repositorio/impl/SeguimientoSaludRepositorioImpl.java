package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.SeguimientoSaludRepositorio;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.SeguimientoSaludMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.SeguimientoSaludRepositorioJpa;

@Component
public class SeguimientoSaludRepositorioImpl implements SeguimientoSaludRepositorio {

	@Autowired
	private SeguimientoSaludRepositorioJpa seguimientoRepositorioJpa;
	private static final SeguimientoSaludMapper mapper = SeguimientoSaludMapper.getInstance();

	@Override
	public boolean registrarSeguimiento(SeguimientoSaludEntidad seguimiento) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.SeguimientoSaludEntidad entity = mapper
				.toEntity(seguimiento);
		return seguimientoRepositorioJpa.save(entity) != null;
	}

	@Override
	public int cantidadDeSeguimientosDePersona(int idUsuario) {
		return seguimientoRepositorioJpa.contarSeguimientosDeUsuario(idUsuario);
	}

	@Override
	public int ultimoSeguimientoVigente(int idUsuario) {
		return seguimientoRepositorioJpa.ultimoSeguimientoVigente(idUsuario);
	}

	@Override
	public boolean volverNoVigente(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.SeguimientoSaludEntidad entity = seguimientoRepositorioJpa
				.consultarSeguimiento(id);
		entity.setVigente(false);
		return seguimientoRepositorioJpa.save(entity) != null;
	}

	@Override
	public boolean actualizarSeguimiento(SeguimientoSaludEntidad seguimiento) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.SeguimientoSaludEntidad entity = mapper
				.toEntity(seguimiento);
		return seguimientoRepositorioJpa.save(entity) != null;
	}

	@Override
	public boolean eliminarSeguimiento(int id) {
		seguimientoRepositorioJpa.deleteById(id);
		return !seguimientoRepositorioJpa.existsById(id);
	}

	@Override
	public SeguimientoSaludEntidad consultarSeguimiento(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.SeguimientoSaludEntidad entity = seguimientoRepositorioJpa
				.consultarSeguimiento(id);
		return mapper.toDomain(entity);
	}

	@Override
	public int ultimoSeguimientoNoVigente(int idUsuario) {
		return seguimientoRepositorioJpa.ultimoSeguimientoNoVigente(idUsuario);
	}

	@Override
	public boolean volverVigente(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.SeguimientoSaludEntidad entity = seguimientoRepositorioJpa
				.consultarSeguimiento(id);
		entity.setVigente(true);
		return seguimientoRepositorioJpa.save(entity) != null;
	}

	@Override
	public boolean existeSeguimiento(int id) {
		return seguimientoRepositorioJpa.existsById(id);
	}

	@Override
	public boolean esVigente(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.SeguimientoSaludEntidad entity = seguimientoRepositorioJpa
				.consultarSeguimiento(id);
		return entity != null ? entity.isVigente() : false;
	}

	@Override
	public int cantidadDeSeguimientosNoVigentesDePersona(int idUsuario) {
		return seguimientoRepositorioJpa.contarSeguimientosNovigentesDeUsuario(idUsuario);
	}

}
