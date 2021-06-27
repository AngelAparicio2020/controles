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

import com.co.comfaoriente.controles.aplicacion.entidades.ControlVacunacionEntidad;
import com.co.comfaoriente.controles.aplicacion.servicios.ControlVacunacionServiceApl;
import com.co.comfaoriente.controles.dominio.entidades.VacunaEntidad;
import com.co.comfaoriente.controles.infraestructura.dtos.ControlVacunacionDto;
import com.co.comfaoriente.controles.infraestructura.persistencia.entidades.VacunaControlEntidad;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.ControlVacunacionMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/control_vacunacion")
@Api(tags = { "Controlador Control de vacunacion" })
public class ControlVacunacionControlador {

	@Autowired
	private ControlVacunacionServiceApl controlService;
	private static final ControlVacunacionMapper mapper = ControlVacunacionMapper.getInstance();

	@PostMapping(value = "/REGISTRAR_CONTROL_VACUNACION")
	@ApiOperation("Registrar control vacunacion")
	public boolean registrarControl(@RequestBody ControlVacunacionDto controlDto) {
		ControlVacunacionEntidad control = mapper.toAplicacion(controlDto);
		return this.controlService.registrarControl(control, controlDto.getVacunas());
	}

	@GetMapping(value = "/ELIMINAR_CONTROL_VACUNACION/{id}")
	@ApiOperation("Eliminar control vacunacion")
	public boolean eliminarControl(@PathVariable int id) {
		return this.controlService.eliminarControl(id);
	}

	@PostMapping(value = "/ACTUALIZAR_CONTROL_VACUNACION")
	@ApiOperation("Actualizar control vacunacion")
	public boolean actualizarControl(@RequestBody ControlVacunacionDto controlDto) {
		ControlVacunacionEntidad control = mapper.toAplicacion(controlDto);
		return this.controlService.actualizarControl(control);
	}

	@GetMapping(value = "/CONSULTAR_CONTROL_VACUNACION/{id}")
	@ApiOperation("Consultar control vacunacion")
	public ControlVacunacionDto consultar(@PathVariable int id) {
		ControlVacunacionEntidad control = controlService.consultarControl(id);
		return mapper.toDto(control);
	}

	@GetMapping(value = "/LISTAR_CONTROLES_VACUNACION/{id}")
	@ApiOperation("Listar controles de vacunacion x documento")
	public List<ControlVacunacionDto> listarControlesVacunacion(@PathVariable int id) {
		return this.controlService.listadoControlesVacunacion(id).stream().map(aplicacion -> mapper.toDto(aplicacion))
				.collect(Collectors.toList());
	}

	@GetMapping(value = "/LISTAR_VACUNAS_EDAD/{meses}")
	@ApiOperation("Listar vacunas x meses")
	public List<VacunaEntidad> listarVacunas(@PathVariable int meses) {
		return this.controlService.consultarVacunasXedad(meses);
	}

	@GetMapping(value = "/LISTAR_VACUNACION_DOCUMENTO/{documento}")
	@ApiOperation("Listar vacunas x meses")
	public List<VacunaControlEntidad> listarVacunasControlesxDocumento(@PathVariable int documento) {
		return this.controlService.listarControlesxDocumento(documento);
	}

	@GetMapping(value = "/ELIMINAR_VACUNA_CONTROL/{control}/{vacuna}")
	@ApiOperation("Eliminar vacuna de un control")
	public boolean eliminarVacuna(@PathVariable int control, @PathVariable int vacuna) {
		return this.controlService.eliminarVacuna(control, vacuna);
	}
}
