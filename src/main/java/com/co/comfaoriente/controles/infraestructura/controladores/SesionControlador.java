package com.co.comfaoriente.controles.infraestructura.controladores;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.comfaoriente.controles.aplicacion.entidades.RolEntidad;
import com.co.comfaoriente.controles.aplicacion.servicios.SesionServiceApl;
import com.co.comfaoriente.controles.infraestructura.dtos.RolDto;
import com.co.comfaoriente.controles.infraestructura.dtos.SesionEntidadRespuesta;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.RolMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.seguridad.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RestController
@RequestMapping("/api/sesion")
@Api(tags = { "Controlador generador de sesion" })
public class SesionControlador {

	@Autowired
	private SesionServiceApl sesionService;

	private static final RolMapper mapper = RolMapper.getInstance();

	@GetMapping(value = "/{documento}/{clave}/{rol}")
	@ApiOperation("inicio sesion")
	public SesionEntidadRespuesta iniciarSesion(@PathVariable int documento, @PathVariable String clave,
			@PathVariable int rol) {
		List<String> privilegios = sesionService.iniciarSesion(documento, clave, rol);
		String tokenJWT = Util.getJWTToken(documento, rol, privilegios);
		return new SesionEntidadRespuesta(tokenJWT, privilegios);
	}

	@GetMapping(value = "/LISTAR_ROLES")
	@ApiOperation("lista de roles")
	public List<RolDto> listarRoles() {
		List<RolEntidad> roles = sesionService.listarRoles();
		return roles.stream().map(aplicacion -> mapper.toDto(aplicacion)).collect(Collectors.toList());
	}

}
