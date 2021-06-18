package com.co.comfaoriente.controles.dominio.repositorios;

import com.co.comfaoriente.controles.dominio.entidades.CompromisoEntidad;

public interface CompromisoRepositorio {
	
	public boolean registrarCompromiso(CompromisoEntidad compromiso);

	public boolean actualizarCompromiso(CompromisoEntidad compromiso);

	public boolean eliminarCompromiso(int id);

	public CompromisoEntidad consultarCompromiso(int id);

	public boolean existeCompromiso(int id);

}
