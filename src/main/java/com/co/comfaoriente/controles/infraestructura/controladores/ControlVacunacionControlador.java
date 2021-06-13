package com.co.comfaoriente.controles.infraestructura.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/control_vacunacion")
@Api(tags = { "Controlador Control de vacunación" })
public class ControlVacunacionControlador {
	
	@GetMapping(value = "/REGISTRAR_CONTROL_VACUNACION")
	@ApiOperation("Registrar control vacunacion")
	public String get() {
		return "hola mundo";
	}
	
	@PostMapping(value = "/LISTAR_CONTROLES_VACUNACION")
	@ApiOperation("Listar controles de vacunacion")
	public String listar() {
		return "hola mundo";
	}
	
	@PostMapping(value = "/ELIMINAR_CONTROL_VACUNACION/{id}")
	@ApiOperation("Eliminar control vacunacion")
	public String eliminar() {
		return "hola mundo";
	}
	
	@PostMapping(value = "/ACTUALIZAR_CONTROL_VACUNACION")
	@ApiOperation("Actualizar control vacunacion")
	public String actualizar() {
		return "hola mundo";
	}
	
	@GetMapping(value = "/CONSULTAR_CONTROL_VACUNACION/{id}")
	@ApiOperation("Consultar control vacunacion")
	public String consultar() {
		return "hola mundo";
	}
}
