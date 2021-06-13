package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol", schema = "controles")
public class RolEntidad {
	
	@Id
	@Column(name = "id_rol", nullable = false)
	private int idRol;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}
