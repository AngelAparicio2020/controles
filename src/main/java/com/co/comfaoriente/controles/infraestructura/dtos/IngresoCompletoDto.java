package com.co.comfaoriente.controles.infraestructura.dtos;

public class IngresoCompletoDto {

	private IngresoInfanteDto ingresoInfante;
	private IngresoMadreDto ingresoMadre;
	private IngresoDto ingreso;
	private boolean esInfante;

	public IngresoInfanteDto getIngresoInfante() {
		return ingresoInfante;
	}

	public void setIngresoInfante(IngresoInfanteDto ingresoInfante) {
		this.ingresoInfante = ingresoInfante;
	}

	public IngresoMadreDto getIngresoMadre() {
		return ingresoMadre;
	}

	public void setIngresoMadre(IngresoMadreDto ingresoMadre) {
		this.ingresoMadre = ingresoMadre;
	}

	public IngresoDto getIngreso() {
		return ingreso;
	}

	public void setIngreso(IngresoDto ingreso) {
		this.ingreso = ingreso;
	}

	public boolean isEsInfante() {
		return esInfante;
	}

	public void setEsInfante(boolean esInfante) {
		this.esInfante = esInfante;
	}

}
