package com.co.comfaoriente.controles.infraestructura.controladores;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.comfaoriente.controles.aplicacion.entidades.ControlAdicionalEntidad;
import com.co.comfaoriente.controles.aplicacion.servicios.ControlAdicionalServiceApl;
import com.co.comfaoriente.controles.infraestructura.dtos.ControlAdicionalDto;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.ControlAdicionalMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/control_adicional")
@Api(tags = { "Controlador Controles adicionales" })
public class ControlAdicionalControlador {

	@Autowired
	private ControlAdicionalServiceApl controlService;
	private static final ControlAdicionalMapper mapper = ControlAdicionalMapper.getInstance();

	@PostMapping(value = "/REGISTRAR_CONTROL")
	@ApiOperation("Registrar control adicional")
	public boolean registrarControl(@RequestBody ControlAdicionalDto controlDto) {
		ControlAdicionalEntidad control = mapper.toAplicacion(controlDto);
		return this.controlService.registrarControl(control);
	}

	@GetMapping(value = "/ELIMINAR_CONTROL/{id}")
	@ApiOperation("Eliminar control adicional")
	public boolean eliminarControl(@PathVariable int id) {
		return this.controlService.eliminarControl(id);
	}

	@PostMapping(value = "/ACTUALIZAR_CONTROL")
	@ApiOperation("Actualizar control adicional")
	public boolean actualizarControl(@RequestBody ControlAdicionalDto controlDto) {
		ControlAdicionalEntidad control = mapper.toAplicacion(controlDto);
		return this.controlService.actualizarControl(control);
	}

	@GetMapping(value = "/CONSULTAR_CONTROL/{id}")
	@ApiOperation("Consultar control adicional")
	public ControlAdicionalDto consultar(@PathVariable int id) {
		ControlAdicionalEntidad control = controlService.consultarControl(id);
		return mapper.toDto(control);
	}

	@GetMapping(value = "/LISTAR_CONTROLES/{id}")
	@ApiOperation("Listar controles adicionales")
	public List<ControlAdicionalDto> listarControlesNutricionales(@PathVariable int id) {
		return this.controlService.listadoControles(id).stream().map(mapper::toDto)
				.collect(Collectors.toList());
	}

}
