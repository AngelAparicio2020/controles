package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.impl;

import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.dominio.entidades.RemicionEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.RemicionRepositorio;

@Component
public class RemicionRepositorioImpl implements RemicionRepositorio {

	@Override
	public boolean registrarRemicion(RemicionEntidad remicion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarRemicion(RemicionEntidad remicion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarRemicion(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RemicionEntidad consultarRemicion(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeRemicion(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
