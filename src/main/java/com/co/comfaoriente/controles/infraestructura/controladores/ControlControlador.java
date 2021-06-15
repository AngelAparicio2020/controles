package com.co.comfaoriente.controles.infraestructura.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.comfaoriente.controles.aplicacion.entidades.ControlEntidad;
import com.co.comfaoriente.controles.aplicacion.servicios.ControlServiceApl;
import com.co.comfaoriente.controles.infraestructura.dtos.ControlDto;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.ControlMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/control")
@Api(tags = { "Controlador Control de crecimiento desarrollo y nutricional" })
public class ControlControlador {

	@Autowired
	private ControlServiceApl controlService;
	private static final ControlMapper mapper = ControlMapper.getInstance();

	@PostMapping(value = "/REGISTRAR_CONTROL")
	@ApiOperation("Registrar control")
	public boolean registrarControl(@RequestBody ControlDto controlDto) {
		ControlEntidad control = mapper.toAplicacion(controlDto);
		return this.controlService.registrarControl(control);
	}

	@GetMapping(value = "/LISTAR_CONTROLES")
	@ApiOperation("Listar Controles")
	public String listarControles() {
		return "hola mundo";
	}

	@GetMapping(value = "/ELIMINAR_CONTROL/{id}")
	@ApiOperation("Eliminar control")
	public boolean eliminarControl(@PathVariable int id) {
		return this.controlService.eliminarControl(id);
	}

	@PostMapping(value = "/ACTUALIZAR_CONTROL")
	@ApiOperation("Actualizar control")
	public boolean actualizarControl(@RequestBody ControlDto controlDto) {
		ControlEntidad control = mapper.toAplicacion(controlDto);
		return this.controlService.actualizarControl(control);
	}

	@GetMapping(value = "/CONSULTAR_CONTROL/{id}")
	@ApiOperation("Consultar control")
	public ControlDto consultar(@PathVariable int id) {
		ControlEntidad control = controlService.consultarControl(id);
		return mapper.toDto(control);
	}

}
