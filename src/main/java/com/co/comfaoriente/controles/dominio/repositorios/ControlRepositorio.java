package com.co.comfaoriente.controles.dominio.repositorios;

import com.co.comfaoriente.controles.dominio.entidades.ControlEntidad;

public interface ControlRepositorio {

	public boolean registrarControl(ControlEntidad control);

	public int cantidadDeControlesDePersona(int idUsuario);

	public int ultimoControlVigente(int idUsuario);

	public boolean volverNoVigente(int id);

	public boolean actualizarControl(ControlEntidad control);

	public boolean eliminarControl(int id);

	public ControlEntidad consultarControl(int id);

	public int ultimoControlNoVigente(int idUsuario);

	public boolean volverVigente(int id);

	public boolean existeControl(int id);

	public boolean esVigente(int id);

}
