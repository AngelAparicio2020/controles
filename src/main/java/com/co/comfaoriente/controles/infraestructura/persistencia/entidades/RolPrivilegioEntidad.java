package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "privilegios_rol", schema = "controles")
@IdClass(value = RolPrivilegioPK.class)
public class RolPrivilegioEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_rol", nullable = false)
	private int idRol;

	@Id
	@Column(name = "id_privilegio", nullable = false)
	private int idPrivilegio;
	
	@Column(name = "nombre")
	private String nombre;

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
