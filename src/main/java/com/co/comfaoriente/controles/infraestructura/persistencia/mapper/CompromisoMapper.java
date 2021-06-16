package com.co.comfaoriente.controles.infraestructura.persistencia.mapper;

public class CompromisoMapper {

	private CompromisoMapper() {
	}

	private static final CompromisoMapper INSTANCE = new CompromisoMapper();

	public static CompromisoMapper getInstance() {
		return INSTANCE;
	}

}
