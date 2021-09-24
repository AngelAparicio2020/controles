package com.co.comfaoriente.controles.infraestructura.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

	@PostMapping(value = "/REGISTRAR_CONTROL/{nutricional}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Registrar control")
	public boolean registrarControl(@RequestBody ControlDto controlDto, @PathVariable boolean nutricional) {
		ControlEntidad control = mapper.toAplicacion(controlDto);
		return this.controlService.registrarControl(control, nutricional);
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

	@GetMapping(value = "/LISTAR_ULTIMOS_CONTROLES/{id}/{idNutricionista}")
	@ApiOperation("Listar ultimos controles de una nutricionista")
	public List<ControlDto> listarUltimosControles(@PathVariable int id, @PathVariable int idNutricionista) {
		List<ControlDto> ultimosControles = new ArrayList<>();
		ControlEntidad controlcyd = controlService.ultimoControlCyD(id, idNutricionista);
		ControlEntidad controlnutricional = controlService.ultimoControlNutricional(id, idNutricionista);
		if (controlcyd != null) {
			ultimosControles.add(mapper.toDto(controlcyd));
		}
		if (controlnutricional != null) {
			ultimosControles.add(mapper.toDto(controlnutricional));
		}
		return ultimosControles;
	}

	@GetMapping(value = "/LISTAR_CONTROLES_NUTRICIONALES/{id}")
	@ApiOperation("Listar ultimos controles de una nutricionista")
	public List<ControlDto> listarControlesNutricionales(@PathVariable int id) {
		return this.controlService.listadoControlesNutricionales(id).stream()
				.map(aplicacion -> mapper.toDto(aplicacion)).collect(Collectors.toList());
	}

	@GetMapping(value = "/LISTAR_CONTROLES_CYD/{id}")
	@ApiOperation("Listar ultimos controles de una nutricionista")
	public List<ControlDto> listarControlesCyD(@PathVariable int id) {
		return this.controlService.listadoControlesCyD(id).stream().map(aplicacion -> mapper.toDto(aplicacion))
				.collect(Collectors.toList());
	}

	@GetMapping(value = "/ULTIMO_CONTROL_CYD/{documento}")
	@ApiOperation("lleva el ultimo control CyD")
	public ControlDto fechasProximoCyD(@PathVariable int documento) {
		ControlEntidad controlcyd = controlService.ultimoControlCyDxDocumento(documento);
		return mapper.toDto(controlcyd);
	}

}
