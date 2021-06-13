package com.co.comfaoriente.controles.infraestructura.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/control")
@Api(tags = { "Controlador Control de crecimiento desarrollo y nutricional" })
public class ControlControlador {
	
	@GetMapping(value = "/REGISTRAR_CONTROL")
	@ApiOperation("Registrar control")
	public String get() {
		return "hola mundo";
	}
	
	@PostMapping(value = "/LISTAR_CONTROLES")
	@ApiOperation("Listar Controles")
	public String listar() {
		return "hola mundo";
	}
	
	@PostMapping(value = "/ELIMINAR_CONTROL/{id}")
	@ApiOperation("Eliminar control")
	public String eliminar() {
		return "hola mundo";
	}
	
	@PostMapping(value = "/ACTUALIZAR_CONTROL")
	@ApiOperation("Actualizar control")
	public String actualizar() {
		return "hola mundo";
	}
	
	@GetMapping(value = "/CONSULTAR_CONTROL/{id}")
	@ApiOperation("Consultar control")
	public String consultar() {
		return "hola mundo";
	}

}
