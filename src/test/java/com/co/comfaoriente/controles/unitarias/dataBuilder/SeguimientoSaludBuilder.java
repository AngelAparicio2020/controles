package com.co.comfaoriente.controles.unitarias.dataBuilder;

import java.util.Date;

import com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad;

public class SeguimientoSaludBuilder {

	private int id;

	private int idUsuario;

	private int idUsuarioNutricionista;

	private String nombreAcudiente;

	private String tipoDocAcudiente;

	private int numeroDocAcudiente;

	private Date fecha;

	private boolean vigente;

	public SeguimientoSaludBuilder() {
		this.id = 1;
		this.idUsuario = 1093779222;
		this.idUsuarioNutricionista = 1093779223;
	}

	public SeguimientoSaludBuilder conId(int id) {
		this.id = id;
		return this;
	}

	public SeguimientoSaludBuilder conIdUsuario(int id) {
		this.idUsuario = id;
		return this;
	}

	public SeguimientoSaludEntidad build() {
		SeguimientoSaludEntidad seguimiento = new SeguimientoSaludEntidad();
		seguimiento.setId(this.id);
		seguimiento.setFecha(this.fecha);
		seguimiento.setNombreAcudiente(this.nombreAcudiente);
		seguimiento.setIdUsuario(this.idUsuario);
		seguimiento.setIdUsuarioNutricionista(this.idUsuarioNutricionista);
		seguimiento.setNumeroDocAcudiente(this.numeroDocAcudiente);
		seguimiento.setTipoDocAcudiente(this.tipoDocAcudiente);
		seguimiento.setVigente(this.vigente);
		return seguimiento;
	}

}
