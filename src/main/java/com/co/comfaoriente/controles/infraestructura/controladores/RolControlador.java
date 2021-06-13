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

import com.co.comfaoriente.controles.aplicacion.entidades.PrivilegioAsociadoEntidad;
import com.co.comfaoriente.controles.aplicacion.entidades.RolEntidad;
import com.co.comfaoriente.controles.aplicacion.servicios.RolServiceApl;
import com.co.comfaoriente.controles.aplicacion.servicios.SesionServiceApl;
import com.co.comfaoriente.controles.infraestructura.dtos.PrivilegioAsociadoDto;
import com.co.comfaoriente.controles.infraestructura.dtos.PrivilegioDto;
import com.co.comfaoriente.controles.infraestructura.dtos.RolDto;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.RolMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/rol")
@Api(tags = { "Controlador gestion de roles" })
public class RolControlador {

	@Autowired
	private SesionServiceApl sesionService;

	@Autowired
	private RolServiceApl rolService;

	private static final RolMapper mapper = RolMapper.getInstance();

	@GetMapping(value = "/LISTAR_ROLES")
	@ApiOperation("lista de roles")
	public List<RolDto> listarRoles() {
		List<RolEntidad> roles = sesionService.listarRoles();
		return roles.stream().map(aplicacion -> mapper.toDto(aplicacion)).collect(Collectors.toList());
	}

	@GetMapping(value = "/ELIMINAR_ROL/{rol}")
	@ApiOperation("Eliminar rol")
	public boolean eliminarRol(@PathVariable int rol) {
		return rolService.eliminarRol(rol);
	}

	@GetMapping(value = "/CONSULTAR_ROL/{rol}")
	@ApiOperation("consultar rol")
	public PrivilegioAsociadoDto consultarRol(@PathVariable int rol) {
		PrivilegioAsociadoEntidad datos = rolService.consultarRol(rol);
		return mapper.privilegioRolToDto(datos);
	}

	@GetMapping(value = "/CONSULTAR_PRIVILEGIOS")
	@ApiOperation("Consultar privilegios")
	public List<PrivilegioDto> consultarPrivilegios() {
		return rolService.consultarPrivilegios().stream().map(aplicacion -> mapper.privilegioToDto(aplicacion))
				.collect(Collectors.toList());
	}

	@GetMapping(value = "/ASIGNAR_ROL/{rol}/{documento}")
	@ApiOperation("Consultar privilegios")
	public boolean asignarRol(@PathVariable int rol, @PathVariable int documento) {
		return rolService.asignarRol(documento, rol);
	}
	
	@GetMapping(value = "/RETIRAR_ROL/{rol}/{documento}")
	@ApiOperation("Consultar privilegios")
	public boolean retirarRol(@PathVariable int rol, @PathVariable int documento) {
		return rolService.retirarRol(documento, rol);
	}

	@PostMapping(value = "/REGISTRAR_ROL")
	@ApiOperation("Registro de roles")
	public boolean registrarRol(@RequestBody PrivilegioAsociadoDto rol) {
		PrivilegioAsociadoEntidad datos = mapper.privilegioRolToAplicacion(rol);
		return rolService.registrarRol(datos);
	}

	@PostMapping(value = "/ACTUALIZAR_ROL")
	@ApiOperation("Actualizar rol")
	public boolean actualizarRol(@RequestBody PrivilegioAsociadoDto rol) {
		PrivilegioAsociadoEntidad datos = mapper.privilegioRolToAplicacion(rol);
		return rolService.actualizarRol(datos);
	}

}
