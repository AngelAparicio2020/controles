package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;
import java.util.Objects;

public class RolUsuarioPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idRol;
	private int documento;

	public RolUsuarioPK(int idRol, int documento) {
		this.idRol = idRol;
		this.documento = documento;
	}
	
	public RolUsuarioPK() {
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.idRol);
		hash = 59 * hash + Objects.hashCode(this.documento);
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
		final RolUsuarioPK other = (RolUsuarioPK) obj;
		if (!Objects.equals(this.idRol, other.idRol)) {
			return false;
		}
		if (!Objects.equals(this.documento, other.documento)) {
			return false;
		}
		return true;
	}

}
