package com.co.comfaoriente.controles.dominio.repositorios;

import java.util.List;

import com.co.comfaoriente.controles.dominio.entidades.BitacoraUsuarioEntidad;

public interface BitacoraRepositorio {

	public boolean registrarBitacora(BitacoraUsuarioEntidad bitacora);

	public List<BitacoraUsuarioEntidad> listarHistorialBitacora(int documento);

}
