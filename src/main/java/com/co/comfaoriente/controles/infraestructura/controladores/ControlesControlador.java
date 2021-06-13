package com.co.comfaoriente.controles.infraestructura.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/controles")
@Api(tags = { "Controlador Controles madres gestantes" })
public class ControlesControlador {
	
	@GetMapping(value = "/CONTROL_PARENTAL")
	@ApiOperation("hola mundo")
	public String get() {
		return "hola mundo";
	}

}
