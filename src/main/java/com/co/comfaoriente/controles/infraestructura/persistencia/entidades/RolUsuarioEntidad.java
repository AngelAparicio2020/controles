package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_rol", schema = "controles")
@IdClass(value = RolUsuarioPK.class)
public class RolUsuarioEntidad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_rol", nullable = false)
	private int idRol;

	@Id
	@Column(name = "documento", nullable = false)
	private int documento;

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
	
	

}
