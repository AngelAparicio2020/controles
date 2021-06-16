package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.impl;

import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad;
import com.co.comfaoriente.controles.dominio.entidades.IngresoInfanteEntidad;
import com.co.comfaoriente.controles.dominio.entidades.IngresoMadreEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.IngresoRepositorio;

@Component
public class IngresoRepositorioImpl implements IngresoRepositorio{

	@Override
	public boolean registrarIngreso(IngresoEntidad ingreso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarIngreso(IngresoEntidad ingreso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarIngreso(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IngresoEntidad consultarIngreso(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeIngreso(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registrarIngresoInfante(IngresoInfanteEntidad ingreso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarIngresoInfante(IngresoInfanteEntidad ingreso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarIngresoInfante(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IngresoInfanteEntidad consultarIngresoInfante(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeIngresoInfante(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registrarIngresoMadre(IngresoMadreEntidad ingreso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarIngresoMadre(IngresoMadreEntidad ingreso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarIngresoMadre(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IngresoMadreEntidad consultarIngresoMadre(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeIngresoMadre(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
