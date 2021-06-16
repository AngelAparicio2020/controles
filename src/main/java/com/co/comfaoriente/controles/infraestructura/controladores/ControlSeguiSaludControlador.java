package com.co.comfaoriente.controles.infraestructura.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.comfaoriente.controles.aplicacion.entidades.SeguimientoSaludEntidad;
import com.co.comfaoriente.controles.aplicacion.servicios.SeguimientoSaludServiceApl;
import com.co.comfaoriente.controles.infraestructura.dtos.SeguimientoSaludDto;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.SeguimientoSaludMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/control_seguimiento")
@Api(tags = { "Controlador Control de ingresos, remiciones y compromisos" })
public class ControlSeguiSaludControlador {

	@Autowired
	private SeguimientoSaludServiceApl seguimientoService;
	private static final SeguimientoSaludMapper mapper = SeguimientoSaludMapper.getInstance();

	@PostMapping(value = "/REGISTRAR_SEGUIMIENTO")
	@ApiOperation("Registrar seguimiento")
	public boolean registrarSeguimiento(@RequestBody SeguimientoSaludDto seguimientoDto) {
		SeguimientoSaludEntidad seguimiento = mapper.toAplicacion(seguimientoDto);
		return this.seguimientoService.registrarSeguimiento(seguimiento);
	}

	@GetMapping(value = "/LISTAR_SEGUIMIENTOS")
	@ApiOperation("Listar seguimientos")
	public String listarSeguimientos() {
		return "hola mundo";
	}

	@GetMapping(value = "/ELIMINAR_SEGUIMIENTO/{id}")
	@ApiOperation("Eliminar seguimiento")
	public boolean eliminarSeguimiento(@PathVariable int id) {
		return this.seguimientoService.eliminarSeguimiento(id);
	}

	@PostMapping(value = "/ACTUALIZAR_SEGUIMIENTO")
	@ApiOperation("Actualizar seguimiento")
	public boolean actualizarSeguimiento(@RequestBody SeguimientoSaludDto seguimientoDto) {
		SeguimientoSaludEntidad seguimiento = mapper.toAplicacion(seguimientoDto);
		return this.seguimientoService.actualizarSeguimiento(seguimiento);
	}

	@GetMapping(value = "/CONSULTAR_SEGUIMIENTO/{id}")
	@ApiOperation("Consultar seguimiento")
	public SeguimientoSaludDto consultarSeguimiento(@PathVariable int id) {
		SeguimientoSaludEntidad seguimiento = seguimientoService.consultarSeguimiento(id);
		return mapper.toDto(seguimiento);
	}

}
