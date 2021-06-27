package com.co.comfaoriente.controles.dominio.repositorios;

import java.util.Date;
import java.util.List;

import com.co.comfaoriente.controles.dominio.entidades.ControlVacunacionEntidad;
import com.co.comfaoriente.controles.dominio.entidades.VacunaEntidad;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaControlEntidad;

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

	public List<VacunaEntidad> consultarVacunasXedad(int meses);

	public boolean asignarVacunasaControl(List<VacunaEntidad> vacunas, int control, Date fechaAplicacion);

	public boolean eliminarVacuna(int control, int vacuna);
	
	public List<VacunaControlEntidad> consultarVacunasxControl(int control);
	
	public List<Integer> listadoControlesxDocumento(int idUsuario);

}
