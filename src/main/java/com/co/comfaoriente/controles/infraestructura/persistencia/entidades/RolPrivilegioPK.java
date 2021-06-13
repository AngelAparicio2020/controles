package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;
import java.util.Objects;

public class RolPrivilegioPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idRol;
	private int idPrivilegio;

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public int getIdPrivilegio() {
		return idPrivilegio;
	}

	public void setIdPrivilegio(int idPrivilegio) {
		this.idPrivilegio = idPrivilegio;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.idRol);
		hash = 59 * hash + Objects.hashCode(this.idPrivilegio);
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
		final RolPrivilegioPK other = (RolPrivilegioPK) obj;
		if (!Objects.equals(this.idRol, other.idRol)) {
			return false;
		}
		if (!Objects.equals(this.idPrivilegio, other.idPrivilegio)) {
			return false;
		}
		return true;
	}

}
