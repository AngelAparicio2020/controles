package com.co.comfaoriente.controles.dominio.servicios;

import java.util.Date;
import java.util.List;

import com.co.comfaoriente.controles.dominio.entidades.BitacoraUsuarioEntidad;
import com.co.comfaoriente.controles.dominio.entidades.UsuarioEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.BitacoraRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.UsuarioRepositorio;

public class BitacoraService {

	private BitacoraRepositorio bitacoraRepositorio;
	private UsuarioRepositorio usuarioRepositorio;

	private static final String USUARIO_NO_ENCONTRADO = "NO EXISTE UN USUARIO CON ESTE DOCUMENTO";

	public BitacoraService(BitacoraRepositorio bitacoraRepositorio, UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
		this.bitacoraRepositorio = bitacoraRepositorio;
	}

	public boolean cambiarEstadoUsuario(BitacoraUsuarioEntidad bitacora) {
		if (!usuarioRepositorio.existeDocumento(bitacora.getIdUsuario())) {
			throw new EntityNotFoundException(USUARIO_NO_ENCONTRADO);
		}
		UsuarioEntidad usuario = usuarioRepositorio.consultarUsuario(bitacora.getIdUsuario());
		if (bitacora.isAccion()) {
			usuario.setFechaIngresoPrograma(new Date());
		} else {
			usuario.setFechaIngresoPrograma(null);
		}

		if (usuarioRepositorio.actualizarUsuario(usuario)) {
			return bitacoraRepositorio.registrarBitacora(bitacora);
		} else {
			return false;
		}

	}

	public List<BitacoraUsuarioEntidad> listarBitacoraUsuario(int documento) {
		return bitacoraRepositorio.listarHistorialBitacora(documento);
	}

}
