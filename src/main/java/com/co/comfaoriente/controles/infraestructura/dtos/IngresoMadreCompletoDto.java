package com.co.comfaoriente.controles.infraestructura.dtos;

public class IngresoMadreCompletoDto {

	private IngresoMadreDto ingresoMadre;
	private IngresoDto ingreso;

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

}
