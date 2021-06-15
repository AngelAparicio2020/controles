package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.aplicacion.entidades.ControlVacunacionEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.ControlVacunacionRepositorio;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.ControlVacunacionRepositorioJpa;

@Component
public class ControlVacunacionRespositorioImpl implements ControlVacunacionRepositorio {

	
	@Autowired
	private ControlVacunacionRepositorioJpa repositorioJpa;
	
	@Override
	public boolean registrarControl(ControlVacunacionEntidad control) {
		return false;
	}

	@Override
	public int cantidadDeControlesDePersona(int idUsuario) {
		return 0;
	}

	@Override
	public int ultimoControlVigente(int idUsuario) {
		return 0;
	}

	@Override
	public boolean volverNoVigente(int id) {
		return false;
	}

	@Override
	public boolean actualizarControl(ControlVacunacionEntidad control) {
		return false;
	}

	@Override
	public boolean eliminarControl(int id) {
		return false;
	}

	@Override
	public ControlVacunacionEntidad consultarControl(int id) {
		return null;
	}

	@Override
	public int ultimoControlNoVigente(int idUsuario) {
		return 0;
	}

	@Override
	public boolean volverVigente(int id) {
		return false;
	}

	@Override
	public boolean existeControl(int id) {
		return false;
	}

	@Override
	public boolean esVigente(int id) {
		return false;
	}

}
