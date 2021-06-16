package com.co.comfaoriente.controles.dominio.repositorios;

import com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad;

public interface SeguimientoSaludRepositorio {

	public boolean registrarSeguimiento(SeguimientoSaludEntidad seguimiento);

	public int cantidadDeSeguimientosDePersona(int idUsuario);

	public int cantidadDeSeguimientosNoVigentesDePersona(int idUsuario);

	public int ultimoSeguimientoVigente(int idUsuario);

	public boolean volverNoVigente(int id);

	public boolean actualizarSeguimiento(SeguimientoSaludEntidad seguimiento);

	public boolean eliminarSeguimiento(int id);

	public SeguimientoSaludEntidad consultarSeguimiento(int id);

	public int ultimoSeguimientoNoVigente(int idUsuario);

	public boolean volverVigente(int id);

	public boolean existeSeguimiento(int id);

	public boolean esVigente(int id);

}
