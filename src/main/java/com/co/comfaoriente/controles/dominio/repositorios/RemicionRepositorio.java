package com.co.comfaoriente.controles.dominio.repositorios;

import com.co.comfaoriente.controles.dominio.entidades.RemicionEntidad;

public interface RemicionRepositorio {


	public boolean registrarRemicion(RemicionEntidad remicion);

	public boolean actualizarRemicion(RemicionEntidad remicion);

	public boolean eliminarRemicion(int id);

	public RemicionEntidad consultarRemicion(int id);

	public boolean existeRemicion(int id);
	
	public RemicionEntidad consultarRemicionxSeguimiento(int id);

}
