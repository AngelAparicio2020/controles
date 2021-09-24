package com.co.comfaoriente.controles.aplicacion.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.aplicacion.entidades.CompromisoEntidad;
import com.co.comfaoriente.controles.aplicacion.entidades.IngresoEntidad;
import com.co.comfaoriente.controles.aplicacion.entidades.RemicionEntidad;
import com.co.comfaoriente.controles.aplicacion.entidades.SeguimientoSaludEntidad;
import com.co.comfaoriente.controles.aplicacion.mapper.CompromisoMapper;
import com.co.comfaoriente.controles.aplicacion.mapper.IngresoMapper;
import com.co.comfaoriente.controles.aplicacion.mapper.RemicionMapper;
import com.co.comfaoriente.controles.aplicacion.mapper.SeguimientoSaludMapper;
import com.co.comfaoriente.controles.dominio.servicios.CompromisoService;
import com.co.comfaoriente.controles.dominio.servicios.IngresoService;
import com.co.comfaoriente.controles.dominio.servicios.RemicionService;
import com.co.comfaoriente.controles.dominio.servicios.SeguimientoSaludService;

@Component
public class SeguimientoSaludServiceApl {

	@Autowired
	private SeguimientoSaludService seguimientoService;
	private static final SeguimientoSaludMapper mapper = SeguimientoSaludMapper.getInstance();
	@Autowired
	private RemicionService remicionService;
	private static final RemicionMapper remicionMapper = RemicionMapper.getInstance();

	@Autowired
	private IngresoService ingresoService;
	private static final IngresoMapper ingresoMapper = IngresoMapper.getInstance();

	@Autowired
	private CompromisoService compromisoService;
	private static final CompromisoMapper compromisoMapper = CompromisoMapper.getInstance();

	public boolean registrarSeguimiento(SeguimientoSaludEntidad seguimiento) {
		return seguimientoService.registrarSeguimiento(mapper.toDominio(seguimiento, true));
	}

	public SeguimientoSaludEntidad consultarSeguimiento(int id) {
		return mapper.toAplicacion(this.seguimientoService.consultarSeguimiento(id));
	}

	public boolean actualizarSeguimiento(SeguimientoSaludEntidad seguimiento) {
		com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad seguimientoDom = mapper
				.toDominio(seguimiento, false);
		return this.seguimientoService.actualizarSeguimiento(seguimientoDom);
	}

	public boolean eliminarSeguimiento(int id) {
		return this.seguimientoService.eliminarSeguimiento(id);
	}

	public List<CompromisoEntidad> listarCompromisosSeguimientoxDocumento(int documento) {
		List<com.co.comfaoriente.controles.dominio.entidades.CompromisoEntidad> compromisos = new ArrayList<>();
		this.seguimientoService.listarSeguimientosxDocumento(documento).stream().forEach(idSeguimiento -> compromisos
				.addAll(this.compromisoService.consultarCompromisoxSeguimiento(idSeguimiento)));

		return compromisos.stream().map(dominio -> dominio == null ? null : compromisoMapper.toAplicacion(dominio))
				.filter(Objects::nonNull).collect(Collectors.toList());

	}

	public List<RemicionEntidad> listarRemicionesSeguimientoxDocumento(int documento) {
		List<com.co.comfaoriente.controles.dominio.entidades.RemicionEntidad> remiciones = new ArrayList<>();
		this.seguimientoService.listarSeguimientosxDocumento(documento).stream().forEach(
				idSeguimiento -> remiciones.addAll(this.remicionService.consultarRemicionxSeguimiento(idSeguimiento)));

		return remiciones.stream().map(dominio -> dominio == null ? null : remicionMapper.toAplicacion(dominio))
				.filter(Objects::nonNull).collect(Collectors.toList());
	}

	public List<IngresoEntidad> listarIngresoSeguimientoxDocumento(int documento) {
		return this.seguimientoService.listarSeguimientosxDocumento(documento).stream()
				.map(idSeguimiento -> this.ingresoService.consultarIngresoxSeguimiento(idSeguimiento))
				.map(dominio -> dominio == null ? null : ingresoMapper.toAplicacion(dominio))
				.filter(remicion -> remicion != null).collect(Collectors.toList());
	}

	public List<SeguimientoSaludEntidad> listarSeguimientosxDocumentoCompletos(int documento) {
		return seguimientoService.listarSeguimientosxDocumentoCompletos(documento).stream().map(mapper::toAplicacion)
				.collect(Collectors.toList());
	}

}
