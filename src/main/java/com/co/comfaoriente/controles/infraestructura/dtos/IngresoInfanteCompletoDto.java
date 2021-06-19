package com.co.comfaoriente.controles.infraestructura.dtos;

public class IngresoInfanteCompletoDto {

	private IngresoInfanteDto ingresoInfante;
	private IngresoDto ingreso;

	public IngresoInfanteDto getIngresoInfante() {
		return ingresoInfante;
	}

	public void setIngresoInfante(IngresoInfanteDto ingresoInfante) {
		this.ingresoInfante = ingresoInfante;
	}

	public IngresoDto getIngreso() {
		return ingreso;
	}

	public void setIngreso(IngresoDto ingreso) {
		this.ingreso = ingreso;
	}

}
