package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.dominio.entidades.ControlVacunacionEntidad;
import com.co.comfaoriente.controles.dominio.entidades.VacunaEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.ControlVacunacionRepositorio;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaControlEntidad;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaControlPK;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.ControlVacunacionMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.VacunaMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.ControlVacunacionRepositorioJpa;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.VacunaControlRepositorioJpa;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.VacunaRepositorioJpa;

@Component
public class ControlVacunacionRespositorioImpl implements ControlVacunacionRepositorio {

	@Autowired
	private ControlVacunacionRepositorioJpa repositorioJpa;
	private static final ControlVacunacionMapper mapper = ControlVacunacionMapper.getInstance();

	@Autowired
	private VacunaRepositorioJpa vacunaRepositorioJpa;

	@Autowired
	private VacunaControlRepositorioJpa vacunaControlRepositorioJpa;
	private static final VacunaMapper vacunaMapper = VacunaMapper.getInstance();

	@Override
	public boolean registrarControl(ControlVacunacionEntidad control) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlVacunacionEntidad entity = mapper
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
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlVacunacionEntidad entity = repositorioJpa
				.consultarControl(id);
		entity.setVigente(false);
		return repositorioJpa.save(entity) != null;
	}

	@Override
	public boolean actualizarControl(ControlVacunacionEntidad control) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlVacunacionEntidad entity = mapper
				.toEntity(control);
		return repositorioJpa.save(entity) != null;
	}

	@Override
	public boolean eliminarControl(int id) {
		repositorioJpa.deleteById(id);
		return !repositorioJpa.existsById(id);
	}

	@Override
	public ControlVacunacionEntidad consultarControl(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlVacunacionEntidad entity = repositorioJpa
				.consultarControl(id);
		return mapper.toDomain(entity);
	}

	@Override
	public int ultimoControlNoVigente(int idUsuario) {
		return repositorioJpa.ultimoControlNoVigente(idUsuario);
	}

	@Override
	public boolean volverVigente(int id) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlVacunacionEntidad entity = repositorioJpa
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
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlVacunacionEntidad entity = repositorioJpa
				.consultarControl(id);
		return entity != null ? entity.isVigente() : false;
	}

	@Override
	public int cantidadDeControlesNoVigentesDePersona(int idUsuario) {
		return repositorioJpa.contarControlesNovigentesDeUsuario(idUsuario);
	}

	@Override
	public List<ControlVacunacionEntidad> consultarControlesxPersona(int idUsuario) {
		List<com.co.comfaoriente.controles.infraestructura.persistencia.entidades.ControlVacunacionEntidad> entity = repositorioJpa
				.controlesVacunacion(idUsuario);
		return entity.stream().map(entityI -> mapper.toDomain(entityI)).collect(Collectors.toList());
	}

	@Override
	public List<VacunaEntidad> consultarVacunasXedad(int meses) {
		List<com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaEntidad> entitys = vacunaRepositorioJpa
				.consultarVacunasxMes(meses);
		return entitys.stream().map(entityI -> vacunaMapper.toDomain(entityI)).collect(Collectors.toList());
	}

	@Override
	public boolean asignarVacunasaControl(List<VacunaEntidad> vacunas, int control, Date fechaAplicacion) {
		List<VacunaControlEntidad> entities = vacunas.stream()
				.map(domain -> vacunaMapper.vacunaControlToEntity(domain, control, fechaAplicacion))
				.collect(Collectors.toList());
		return vacunaControlRepositorioJpa.saveAll(entities) != null;
	}

	@Override
	public boolean eliminarVacuna(int control, int vacuna) {
		VacunaControlEntidad entity = new VacunaControlEntidad();
		VacunaControlPK pk = new VacunaControlPK(control, vacuna);
		entity.setIdVacuna(vacuna);
		entity.setIdControl(control);
		vacunaControlRepositorioJpa.delete(entity);
		return !vacunaControlRepositorioJpa.existsById(pk);
	}

	@Override
	public List<VacunaControlEntidad> consultarVacunasxControl(int control) {
		return vacunaControlRepositorioJpa.consultarVacunaxControl(control);
	}
	
	@Override
	public List<Integer> listadoControlesxDocumento(int idUsuario) {
		return repositorioJpa.listarControlesxDocumento(idUsuario);
	}

}
