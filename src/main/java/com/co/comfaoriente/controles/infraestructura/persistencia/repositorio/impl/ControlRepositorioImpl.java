package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.dominio.entidades.ControlEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.ControlRepositorio;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.ControlMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.ControlRepositorioJpa;

@Component
public class ControlRepositorioImpl implements ControlRepositorio {

	@Autowired
	private ControlRepositorioJpa repositorioJpa;
	private static final ControlMapper mapper = ControlMapper.getInstance();

	@Override
	public boolean registrarControl(ControlEntidad control) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad entity = mapper
				.toEntity(control);
		return repositorioJpa.save(entity) != null;
	}

	@Override
	public int cantidadDeControlesDePersona(int idUsuario) {
		return repositorioJpa.contarControlesDeUsuario(idUsuario);
	}

	@Override
	public int ultimoControlVigente(int idUsuario) {
		return repositorioJpa.ultimoControlVigente(idUsuario);
	}

	@Override
	public boolean volverNoVigente(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad entity = repositorioJpa
				.consultarControl(id);
		entity.setVigente(false);
		return repositorioJpa.save(entity) != null;
	}

	@Override
	public boolean actualizarControl(ControlEntidad control) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad entity = mapper
				.toEntity(control);
		return repositorioJpa.save(entity) != null;
	}

	@Override
	public boolean eliminarControl(int id) {
		repositorioJpa.deleteById(id);
		return !repositorioJpa.existsById(id);
	}

	@Override
	public ControlEntidad consultarControl(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad entity = repositorioJpa
				.consultarControl(id);
		return mapper.toDomain(entity);
	}

	@Override
	public int ultimoControlNoVigente(int idUsuario) {
		return repositorioJpa.ultimoControlNoVigente(idUsuario);
	}

	@Override
	public boolean volverVigente(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad entity = repositorioJpa
				.consultarControl(id);
		entity.setVigente(true);
		return repositorioJpa.save(entity) != null;
	}

	@Override
	public boolean existeControl(int id) {
		return repositorioJpa.existsById(id);
	}

	@Override
	public boolean esVigente(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad entity = repositorioJpa
				.consultarControl(id);
		return entity != null ? entity.isVigente() : false;
	}

	@Override
	public int cantidadDeControlesNoVigentesDePersona(int idUsuario) {
		return repositorioJpa.contarControlesNovigentesDeUsuario(idUsuario);
	}

	@Override
	public ControlEntidad ultimoControlCyD(int id, int idNutricionista) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad entity = repositorioJpa
				.ultimoControlCyD(id, idNutricionista);
		return mapper.toDomain(entity);
	}

	@Override
	public ControlEntidad ultimoControlNutricional(int id, int idNutricionista) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad entity = repositorioJpa
				.ultimoControlNutricional(id, idNutricionista);
		return mapper.toDomain(entity);
	}

	@Override
	public List<ControlEntidad> listadoControlesCyD(int id) {
		List<com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad> entity = repositorioJpa
				.controlesCyDXPersona(id);
		return entity.stream().map(entityI -> mapper.toDomain(entityI)).collect(Collectors.toList());
	}

	@Override
	public List<ControlEntidad> listadoControlesNutricionales(int id) {
		List<com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlEntidad> entity = repositorioJpa
				.controlesNutricionalesXPersona(id);
		return entity.stream().map(entityI -> mapper.toDomain(entityI)).collect(Collectors.toList());
	}

}
