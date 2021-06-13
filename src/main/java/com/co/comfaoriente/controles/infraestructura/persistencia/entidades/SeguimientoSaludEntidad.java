package com.co.comfaoriente.controles.infraestructura.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seguigestsalud", schema = "controles")
public class SeguimientoSaludEntidad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_segui_ges_salud", nullable = false)
	private int id;
	
	@Column(name = "id_usuario", nullable = false)
	private int idUsuario;

	@Column(name = "id_usuario_nutricionista", nullable = false)
	private int idUsuarioNutricionista;

	@Column(name = "nombre_acudiente", nullable = false)
	private String nombreAcudiente;

	@Column(name = "tipo_doc_acudiente", nullable = false)
	private String tipoDocAcudiente;

	@Column(name = "numero_doc_acudiente", nullable = false)
	private int numeroDocAcudiente;

	@Column(name = "fecha", nullable = false)
	private Date fecha;

	@Column(name = "vigente", columnDefinition = "tinyint(1) default 1", nullable = false)
	private boolean vigente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdUsuarioNutricionista() {
		return idUsuarioNutricionista;
	}

	public void setIdUsuarioNutricionista(int idUsuarioNutricionista) {
		this.idUsuarioNutricionista = idUsuarioNutricionista;
	}

	public String getNombreAcudiente() {
		return nombreAcudiente;
	}

	public void setNombreAcudiente(String nombreAcudiente) {
		this.nombreAcudiente = nombreAcudiente;
	}

	public String getTipoDocAcudiente() {
		return tipoDocAcudiente;
	}

	public void setTipoDocAcudiente(String tipoDocAcudiente) {
		this.tipoDocAcudiente = tipoDocAcudiente;
	}

	public int getNumeroDocAcudiente() {
		return numeroDocAcudiente;
	}

	public void setNumeroDocAcudiente(int numeroDocAcudiente) {
		this.numeroDocAcudiente = numeroDocAcudiente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}

}
