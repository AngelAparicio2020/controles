package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;
import java.util.Objects;

public class VacunaControlPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idVacuna;
	private int idControl;

	public VacunaControlPK(int idVacuna, int idControl) {
		this.idVacuna = idVacuna;
		this.idControl = idControl;
	}

	public VacunaControlPK() {
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.idVacuna);
		hash = 59 * hash + Objects.hashCode(this.idControl);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final VacunaControlPK other = (VacunaControlPK) obj;
		if (!Objects.equals(this.idVacuna, other.idVacuna)) {
			return false;
		}
		if (!Objects.equals(this.idControl, other.idControl)) {
			return false;
		}
		return true;
	}
}
