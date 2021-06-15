package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.SeguimientoSaludRepositorio;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.SeguimientoSaludRepositorioJpa;

@Component
public class SeguimientoSaludRepositorioImpl implements SeguimientoSaludRepositorio {

	@Autowired
	private SeguimientoSaludRepositorioJpa seguimientoRepositorio;

	@Override
	public boolean registrarControl(SeguimientoSaludEntidad control) {
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
	public boolean actualizarControl(SeguimientoSaludEntidad control) {
		return false;
	}

	@Override
	public boolean eliminarControl(int id) {
		return false;
	}

	@Override
	public SeguimientoSaludEntidad consultarControl(int id) {
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
