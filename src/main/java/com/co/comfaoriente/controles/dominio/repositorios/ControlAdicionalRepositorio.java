package com.co.comfaoriente.controles.dominio.repositorios;

import java.util.List;

import com.co.comfaoriente.controles.dominio.entidades.ControlAdicionalEntidad;

public interface ControlAdicionalRepositorio {

	public boolean registrarControl(ControlAdicionalEntidad control);

	public boolean actualizarControl(ControlAdicionalEntidad control);

	public boolean eliminarControl(int control);

	public ControlAdicionalEntidad consultarControl(int control);

	public List<ControlAdicionalEntidad> listarControles();

	public boolean existeControl(int control);

}
