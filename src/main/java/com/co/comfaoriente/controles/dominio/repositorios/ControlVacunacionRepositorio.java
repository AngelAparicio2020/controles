package com.co.comfaoriente.controles.dominio.repositorios;

import java.util.List;

import com.co.comfaoriente.controles.dominio.entidades.ControlVacunacionEntidad;

public interface ControlVacunacionRepositorio {

	public boolean registrarControl(ControlVacunacionEntidad control);

	public int cantidadDeControlesDePersona(int idUsuario);

	public int cantidadDeControlesNoVigentesDePersona(int idUsuario);

	public int ultimoControlVigente(int idUsuario);

	public boolean volverNoVigente(int id);

	public boolean actualizarControl(ControlVacunacionEntidad control);

	public boolean eliminarControl(int id);

	public ControlVacunacionEntidad consultarControl(int id);

	public int ultimoControlNoVigente(int idUsuario);

	public boolean volverVigente(int id);

	public boolean existeControl(int id);

	public boolean esVigente(int id);
	
	public List<ControlVacunacionEntidad> consultarControlesxPersona(int idUsuario);

}
