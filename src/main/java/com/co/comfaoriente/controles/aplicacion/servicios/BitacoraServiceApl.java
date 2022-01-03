package com.co.comfaoriente.controles.aplicacion.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.aplicacion.entidades.BitacoraUsuarioEntidad;
import com.co.comfaoriente.controles.aplicacion.mapper.BitacoraUsuarioMapper;
import com.co.comfaoriente.controles.dominio.servicios.BitacoraService;

@Component
public class BitacoraServiceApl {

	@Autowired(required=true)
	private BitacoraService bitacoraService;

	private static final BitacoraUsuarioMapper mapper = BitacoraUsuarioMapper.getInstance();

	public boolean cambiarEstadoUsuario(BitacoraUsuarioEntidad bitacora) {
		return bitacoraService.cambiarEstadoUsuario(mapper.toDominio(bitacora));
	}

	public List<BitacoraUsuarioEntidad> listarBitacoraUsuario(int documento) {
		return bitacoraService.listarBitacoraUsuario(documento).stream().map(mapper::toAplicacion)
				.collect(Collectors.toList());
	}

}
