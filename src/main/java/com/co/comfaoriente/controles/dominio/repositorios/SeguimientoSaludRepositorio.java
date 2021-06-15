package com.co.comfaoriente.controles.dominio.repositorios;

import com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad;

public interface SeguimientoSaludRepositorio {

	public boolean registrarControl(SeguimientoSaludEntidad control);

	public int cantidadDeControlesDePersona(int idUsuario);

	public int ultimoControlVigente(int idUsuario);

	public boolean volverNoVigente(int id);

	public boolean actualizarControl(SeguimientoSaludEntidad control);

	public boolean eliminarControl(int id);

	public SeguimientoSaludEntidad consultarControl(int id);

	public int ultimoControlNoVigente(int idUsuario);

	public boolean volverVigente(int id);

	public boolean existeControl(int id);
	
	public boolean esVigente(int id);

}
