package com.co.comfaoriente.controles.infraestructura.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.comfaoriente.controles.aplicacion.entidades.IngresoEntidad;
import com.co.comfaoriente.controles.aplicacion.entidades.IngresoInfanteEntidad;
import com.co.comfaoriente.controles.aplicacion.entidades.IngresoMadreEntidad;
import com.co.comfaoriente.controles.aplicacion.entidades.RemicionEntidad;
import com.co.comfaoriente.controles.aplicacion.entidades.SeguimientoSaludEntidad;
import com.co.comfaoriente.controles.aplicacion.servicios.IngresoServiceApl;
import com.co.comfaoriente.controles.aplicacion.servicios.RemicionServiceApl;
import com.co.comfaoriente.controles.aplicacion.servicios.SeguimientoSaludServiceApl;
import com.co.comfaoriente.controles.infraestructura.dtos.IngresoCompletoDto;
import com.co.comfaoriente.controles.infraestructura.dtos.RemicionDto;
import com.co.comfaoriente.controles.infraestructura.dtos.SeguimientoSaludDto;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.IngresoInfanteMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.IngresoMadreMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.IngresoMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.RemicionMapper;
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
	@Autowired
	private IngresoServiceApl ingresoService;
	@Autowired
	private RemicionServiceApl remicionService;
	private static final IngresoMapper ingresoMapper = IngresoMapper.getInstance();
	private static final IngresoMadreMapper madreMapper = IngresoMadreMapper.getInstance();
	private static final IngresoInfanteMapper infanteMapper = IngresoInfanteMapper.getInstance();
	private static final RemicionMapper remicionMapper = RemicionMapper.getInstance();

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

	@GetMapping(value = "/ELIMINAR_INGRESO/{id}")
	@ApiOperation("Eliminar ingreso")
	public boolean eliminarIngreso(@PathVariable int id) {
		return this.ingresoService.eliminarIngreso(id);
	}

	@PostMapping(value = "/REGISTRAR_INGRESO_INFANTE")
	@ApiOperation("Registrar ingreso infante")
	public boolean registrarIngresoInfante(@RequestBody IngresoCompletoDto ingresoDto) {
		IngresoInfanteEntidad infante = infanteMapper.toAplicacion(ingresoDto.getIngresoInfante(), true);
		IngresoEntidad ingreso = ingresoMapper.toAplicacion(ingresoDto.getIngreso(), true);
		return this.ingresoService.registrarIngresoInfante(infante, ingreso);
	}

	@PostMapping(value = "/ACTUALIZAR_INGRESO_INFANTE")
	@ApiOperation("Actualizar ingreso infante")
	public boolean actualizarIngresoInfante(@RequestBody IngresoCompletoDto ingresoDto) {
		IngresoInfanteEntidad infante = infanteMapper.toAplicacion(ingresoDto.getIngresoInfante(), false);
		IngresoEntidad ingreso = ingresoMapper.toAplicacion(ingresoDto.getIngreso(), false);
		return this.ingresoService.actualizarIngresoInfante(infante, ingreso);
	}

	@GetMapping(value = "/CONSULTAR_INGRESO_INFANTE/{id}")
	@ApiOperation("Consultar ingreso infante")
	public IngresoCompletoDto consultarIngresoInfante(@PathVariable int id) {
		IngresoEntidad ingreso = ingresoService.consultarIngreso(id);
		IngresoInfanteEntidad infante = ingresoService.consultarIngresoInfante(id);
		IngresoCompletoDto consulta = new IngresoCompletoDto();
		consulta.setIngreso(ingresoMapper.toDto(ingreso));
		consulta.setIngresoInfante(infanteMapper.toDto(infante));
		return consulta;
	}

	@PostMapping(value = "/REGISTRAR_INGRESO_MADRE")
	@ApiOperation("Registrar ingreso madre")
	public boolean registrarIngresoMadre(@RequestBody IngresoCompletoDto ingresoDto) {
		IngresoMadreEntidad madre = madreMapper.toAplicacion(ingresoDto.getIngresoMadre(), true);
		IngresoEntidad ingreso = ingresoMapper.toAplicacion(ingresoDto.getIngreso(), true);
		return this.ingresoService.registrarIngresoMadre(madre, ingreso);
	}

	@PostMapping(value = "/ACTUALIZAR_INGRESO_MADRE")
	@ApiOperation("Actualizar ingreso madre")
	public boolean actualizarIngresoMadre(@RequestBody IngresoCompletoDto ingresoDto) {
		IngresoMadreEntidad madre = madreMapper.toAplicacion(ingresoDto.getIngresoMadre(), false);
		IngresoEntidad ingreso = ingresoMapper.toAplicacion(ingresoDto.getIngreso(), false);
		return this.ingresoService.actualizarIngresoMadre(madre, ingreso);
	}

	@GetMapping(value = "/CONSULTAR_INGRESO_MADRE/{id}")
	@ApiOperation("Consultar ingreso madre")
	public IngresoCompletoDto consultarIngresoMadre(@PathVariable int id) {
		IngresoEntidad ingreso = ingresoService.consultarIngreso(id);
		IngresoMadreEntidad madre = ingresoService.consultarIngresoMadre(id);
		IngresoCompletoDto consulta = new IngresoCompletoDto();
		consulta.setIngreso(ingresoMapper.toDto(ingreso));
		consulta.setIngresoMadre(madreMapper.toDto(madre));
		return consulta;
	}

	@PostMapping(value = "/REGISTRAR_REMICION")
	@ApiOperation("Registrar remicion")
	public boolean registrarRemicion(@RequestBody RemicionDto remicionDto) {
		RemicionEntidad remicion = remicionMapper.toAplicacion(remicionDto);
		return this.remicionService.registrarRemicion(remicion);
	}

	@GetMapping(value = "/ELIMINAR_REMICION/{id}")
	@ApiOperation("Eliminar remicion")
	public boolean eliminarRemicion(@PathVariable int id) {
		return this.remicionService.eliminarRemicion(id);
	}

	@PostMapping(value = "/ACTUALIZAR_REMICION")
	@ApiOperation("Actualizar remicion")
	public boolean actualizarRemicion(@RequestBody RemicionDto remicionDto) {
		RemicionEntidad remicion = remicionMapper.toAplicacion(remicionDto);
		return this.remicionService.actualizarRemicion(remicion);
	}

	@GetMapping(value = "/CONSULTAR_REMICION/{id}")
	@ApiOperation("Consultar remicion")
	public RemicionDto consultarRemicion(@PathVariable int id) {
		RemicionEntidad remicion = remicionService.consultarRemicion(id);
		return remicionMapper.toDto(remicion);
	}

}
