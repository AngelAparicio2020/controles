package com.co.comfaoriente.controles.dominio.servicios;

import com.co.comfaoriente.controles.dominio.repositorios.CompromisoRepositorio;

public class CompromisoService {

	private CompromisoRepositorio compromisoRepositorio;

	public CompromisoService(CompromisoRepositorio compromisoRepositorio) {
		this.compromisoRepositorio = compromisoRepositorio;
	}

}
