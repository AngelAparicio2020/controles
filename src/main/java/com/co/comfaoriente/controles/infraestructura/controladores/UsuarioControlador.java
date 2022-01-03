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

import com.co.comfaoriente.controles.aplicacion.entidades.BitacoraUsuarioEntidad;
import com.co.comfaoriente.controles.aplicacion.entidades.UsuarioEntidad;
import com.co.comfaoriente.controles.aplicacion.servicios.BitacoraServiceApl;
import com.co.comfaoriente.controles.aplicacion.servicios.UsuarioServiceApl;
import com.co.comfaoriente.controles.infraestructura.dtos.BitacoraUsuarioDto;
import com.co.comfaoriente.controles.infraestructura.dtos.UsuarioDto;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.BitacoraUsuarioMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.UsuarioMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/usuario")
@Api(tags = { "Controlador gestion de roles" })
public class UsuarioControlador {

	@Autowired
	private UsuarioServiceApl usuarioService;

	@Autowired
	private BitacoraServiceApl bitacoraService;

	private static final UsuarioMapper mapper = UsuarioMapper.getInstance();
	private static final BitacoraUsuarioMapper bitacoramapper = BitacoraUsuarioMapper.getInstance();

	@GetMapping(value = "/LISTAR_USUARIOS")
	@ApiOperation("lista de usuarios")
	public List<UsuarioDto> listarUsuarios() {
		List<UsuarioEntidad> usuarios = usuarioService.listarUsuarios();
		return usuarios.stream().map(mapper::toDto).collect(Collectors.toList());
	}

	@GetMapping(value = "/ELIMINAR_USUARIO/{documento}")
	@ApiOperation("Eliminar usuario")
	public boolean eliminarRol(@PathVariable int documento) {
		return usuarioService.eliminarUsuario(documento);
	}

	@GetMapping(value = "/CONSULTAR_USUARIO/{documento}")
	@ApiOperation("consultar usuario")
	public UsuarioDto consultarRol(@PathVariable int documento) {
		UsuarioEntidad usuario = usuarioService.consultarUsuario(documento);
		return mapper.toDto(usuario);
	}

	@PostMapping(value = "/REGISTRAR_USUARIO")
	@ApiOperation("Registro de usuario")
	public boolean registrarRol(@RequestBody UsuarioDto usuarioDto) {
		UsuarioEntidad usuario = mapper.toAplicacion(usuarioDto);
		return usuarioService.registrarUsuario(usuario);
	}

	@PostMapping(value = "/ACTUALIZAR_USUARIO")
	@ApiOperation("Actualizar usuario")
	public boolean actualizarRol(@RequestBody UsuarioDto usuarioDto) {
		UsuarioEntidad usuario = mapper.toAplicacion(usuarioDto);
		return usuarioService.actualizarUsuario(usuario);
	}

	@GetMapping(value = "/LISTAR_USUARIOS_ROL/{nombre}")
	@ApiOperation("lista de usuarios")
	public List<UsuarioDto> listarUsuariosxRol(@PathVariable String nombre) {
		List<UsuarioEntidad> usuarios = usuarioService.consultarUsuariosxRol(nombre);
		return usuarios.stream().map(mapper::toDto).collect(Collectors.toList());
	}

	@GetMapping(value = "/LISTAR_USUARIOS_INACTIVOS")
	@ApiOperation("lista de usuarios inactivos")
	public List<UsuarioDto> listarUsuariosInactivos() {
		List<UsuarioEntidad> usuarios = usuarioService.listarUsuariosInactivos();
		return usuarios.stream().map(mapper::toDto).collect(Collectors.toList());
	}

	@PostMapping(value = "/MODIFICAR_ESTADO_USUARIO")
	@ApiOperation("activar usuarios O desactivar")
	public boolean activarUsuario(@RequestBody BitacoraUsuarioDto bitacoraDto) {
		BitacoraUsuarioEntidad bitacora = bitacoramapper.toAplicacion(bitacoraDto);
		return bitacoraService.cambiarEstadoUsuario(bitacora);
	}

	@GetMapping(value = "/LISTAR_BITACORA_USUARIO/{documento}")
	@ApiOperation("lista de usuarios inactivos")
	public List<BitacoraUsuarioDto> listarBitacoraUsuario(@PathVariable int documento) {
		List<BitacoraUsuarioEntidad> bitacoras = bitacoraService.listarBitacoraUsuario(documento);
		return bitacoras.stream().map(bitacoramapper::toDto).collect(Collectors.toList());
	}

}
