package com.co.comfaoriente.controles.dominio.repositorios;

import com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad;
import com.co.comfaoriente.controles.dominio.entidades.IngresoInfanteEntidad;
import com.co.comfaoriente.controles.dominio.entidades.IngresoMadreEntidad;

public interface IngresoRepositorio {

	public boolean registrarIngreso(IngresoEntidad ingreso);

	public boolean actualizarIngreso(IngresoEntidad ingreso);

	public boolean eliminarIngreso(int id);

	public IngresoEntidad consultarIngreso(int id);

	public boolean existeIngreso(int id);

	public boolean registrarIngresoInfante(IngresoInfanteEntidad ingreso);

	public boolean actualizarIngresoInfante(IngresoInfanteEntidad ingreso);

	public boolean eliminarIngresoInfante(int id);

	public IngresoInfanteEntidad consultarIngresoInfante(int id);

	public boolean existeIngresoInfante(int id);

	public boolean registrarIngresoMadre(IngresoMadreEntidad ingreso);

	public boolean actualizarIngresoMadre(IngresoMadreEntidad ingreso);

	public boolean eliminarIngresoMadre(int id);

	public IngresoMadreEntidad consultarIngresoMadre(int id);

	public boolean existeIngresoMadre(int id);

}
