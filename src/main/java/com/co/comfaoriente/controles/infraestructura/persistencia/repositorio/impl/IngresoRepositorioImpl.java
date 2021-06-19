package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad;
import com.co.comfaoriente.controles.dominio.entidades.IngresoInfanteEntidad;
import com.co.comfaoriente.controles.dominio.entidades.IngresoMadreEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.IngresoRepositorio;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.IngresoInfanteMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.IngresoMadreMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.IngresoMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.IngresoInfanteRepositorioJpa;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.IngresoMadreRepositorioJpa;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.IngresoRepositorioJpa;

@Component
public class IngresoRepositorioImpl implements IngresoRepositorio {

	@Autowired
	private IngresoInfanteRepositorioJpa ingresoinfanteRepositorioJpa;
	@Autowired
	private IngresoRepositorioJpa ingresoRepositorioJpa;
	@Autowired
	private IngresoMadreRepositorioJpa ingresoMadreRepositorioJpa;

	private static final IngresoMapper mapper = IngresoMapper.getInstance();
	private static final IngresoMadreMapper madreMapper = IngresoMadreMapper.getInstance();
	private static final IngresoInfanteMapper infanteMapper = IngresoInfanteMapper.getInstance();

	@Override
	public int registrarIngreso(IngresoEntidad ingreso) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoEntidad entity = mapper
				.toEntity(ingreso);
		return ingresoRepositorioJpa.save(entity).getId();
	}

	@Override
	public boolean actualizarIngreso(IngresoEntidad ingreso) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoEntidad entity = mapper
				.toEntity(ingreso);
		return ingresoRepositorioJpa.save(entity) != null;
	}

	@Override
	public boolean eliminarIngreso(int id) {
		ingresoRepositorioJpa.deleteById(id);
		return !ingresoRepositorioJpa.existsById(id);
	}

	@Override
	public IngresoEntidad consultarIngreso(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoEntidad entity = ingresoRepositorioJpa
				.consultarIngreso(id);
		return mapper.toDomain(entity);
	}

	@Override
	public boolean existeIngreso(int id) {
		return ingresoRepositorioJpa.existsById(id);
	}

	@Override
	public boolean registrarIngresoInfante(IngresoInfanteEntidad ingreso) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoInfanteEntidad entity = infanteMapper
				.toEntity(ingreso);
		return ingresoinfanteRepositorioJpa.save(entity) != null;
	}

	@Override
	public boolean actualizarIngresoInfante(IngresoInfanteEntidad ingreso) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoInfanteEntidad entity = infanteMapper
				.toEntity(ingreso);
		return ingresoinfanteRepositorioJpa.save(entity) != null;
	}

	@Override
	public boolean eliminarIngresoInfante(int id) {
		return false;
	}

	@Override
	public IngresoInfanteEntidad consultarIngresoInfante(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoInfanteEntidad entity = ingresoinfanteRepositorioJpa
				.consultarIngreso(id);
		return infanteMapper.toDomain(entity);
	}

	@Override
	public boolean existeIngresoInfante(int id) {
		return ingresoinfanteRepositorioJpa.existsById(id);
	}

	@Override
	public boolean registrarIngresoMadre(IngresoMadreEntidad ingreso) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoMadreEntidad entity = madreMapper
				.toEntity(ingreso);
		return ingresoMadreRepositorioJpa.save(entity) != null;
	}

	@Override
	public boolean actualizarIngresoMadre(IngresoMadreEntidad ingreso) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoMadreEntidad entity = madreMapper
				.toEntity(ingreso);
		return ingresoMadreRepositorioJpa.save(entity) != null;
	}

	@Override
	public boolean eliminarIngresoMadre(int id) {
		return false;
	}

	@Override
	public IngresoMadreEntidad consultarIngresoMadre(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoMadreEntidad entity = ingresoMadreRepositorioJpa
				.consultarIngreso(id);
		return madreMapper.toDomain(entity);
	}

	@Override
	public boolean existeIngresoMadre(int id) {
		return ingresoMadreRepositorioJpa.existsById(id);
	}

	@Override
	public IngresoEntidad consultarIngresoxSeguimiento(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.IngresoEntidad entity = ingresoRepositorioJpa
				.consultarIngresoxSeguimiento(id);
		return mapper.toDomain(entity);
	}

}
