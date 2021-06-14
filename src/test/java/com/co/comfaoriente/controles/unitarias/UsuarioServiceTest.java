package com.co.comfaoriente.controles.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.comfaoriente.controles.dominio.entidades.UsuarioEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.UsuarioRepositorio;
import com.co.comfaoriente.controles.dominio.servicios.UsuarioService;
import com.co.comfaoriente.controles.unitarias.dataBuilder.UsuarioBuilder;

@SpringBootTest
class UsuarioServiceTest {

	private UsuarioRepositorio usuarioRepositorio;
	private UsuarioService usuarioService;
	private UsuarioEntidad usuario;
	private UsuarioBuilder builder;
	private static final int DOCUMENTO = 1093779232;
	private static final String USUARIO_NO_ENCONTRADO = "NO EXISTE UN USUARIO CON ESTE DOCUMENTO";
	private static final String USUARIO_EXISTE = "ESTE USUARIO YA SE ENCONTRABA REGISTRADO";

	@BeforeEach
	void setUp() {
		this.usuarioRepositorio = mock(UsuarioRepositorio.class);
	}

	@Test
	void build() {
		// act
		this.usuarioService = new UsuarioService(this.usuarioRepositorio);
		// assert
		assertNotNull(this.usuarioRepositorio);
		assertNotNull(this.usuarioService);
	}

	@Test
	void registrarUsuarioOkTest() {
		// arrange
		this.builder = new UsuarioBuilder();
		this.usuario = builder.build();
		when(this.usuarioRepositorio.registrarUsuario(this.usuario)).thenReturn(true);
		this.usuarioService = new UsuarioService(this.usuarioRepositorio);

		// act
		boolean registrado = this.usuarioService.registrarUsuario(this.usuario);

		// assert
		assertEquals(true, registrado);

	}

	@Test
	void registrarUsuarioFalloTest() {
		// arrange
		this.builder = new UsuarioBuilder();
		this.usuario = builder.build();
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.usuarioRepositorio.registrarUsuario(usuario)).thenReturn(true);
		this.usuarioService = new UsuarioService(this.usuarioRepositorio);

		try {
			// act
			this.usuarioService.registrarUsuario(this.usuario);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(USUARIO_EXISTE, e.getMessage());
		}

	}

	@Test
	void actualizarUsuarioOkTest() {
		// arrange
		this.builder = new UsuarioBuilder();
		this.usuario = builder.build();
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.usuarioRepositorio.actualizarUsuario(this.usuario)).thenReturn(true);
		this.usuarioService = new UsuarioService(this.usuarioRepositorio);

		// act
		boolean actualizado = this.usuarioService.actualizarUsuario(this.usuario);

		// assert
		assertEquals(true, actualizado);

	}

	@Test
	void actualizarUsuarioFalloTest() {
		// arrange
		this.builder = new UsuarioBuilder();
		this.usuario = builder.build();
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(false);
		when(this.usuarioRepositorio.actualizarUsuario(this.usuario)).thenReturn(true);
		this.usuarioService = new UsuarioService(this.usuarioRepositorio);

		try {
			// act
			this.usuarioService.actualizarUsuario(this.usuario);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(USUARIO_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void eliminarUsuarioOkTest() {
		// arrange
		this.builder = new UsuarioBuilder();
		this.usuario = builder.build();
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.usuarioRepositorio.eliminarUsuario(DOCUMENTO)).thenReturn(true);
		this.usuarioService = new UsuarioService(this.usuarioRepositorio);

		// act
		boolean eliminado = this.usuarioService.eliminarUsuario(DOCUMENTO);

		// assert
		assertEquals(true, eliminado);

	}

	@Test
	void EliminarUsuarioFalloTest() {
		// arrange
		this.builder = new UsuarioBuilder();
		this.usuario = builder.build();
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(false);
		when(this.usuarioRepositorio.eliminarUsuario(DOCUMENTO)).thenReturn(true);
		this.usuarioService = new UsuarioService(this.usuarioRepositorio);

		try {
			// act
			this.usuarioService.eliminarUsuario(DOCUMENTO);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(USUARIO_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void consultarUsuarioOkTest() {
		// arrange
		this.builder = new UsuarioBuilder();
		this.usuario = builder.build();
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.usuarioRepositorio.consultarUsuario(DOCUMENTO)).thenReturn(this.usuario);
		this.usuarioService = new UsuarioService(this.usuarioRepositorio);

		// act
		UsuarioEntidad consultado = this.usuarioService.consultarUsuario(DOCUMENTO);

		// assert
		assertEquals(this.usuario, consultado);
		assertEquals("JOSE SUAREZ", consultado.getNombre());

	}

	@Test
	void consultarUsuarioFalloTest() {
		// arrange
		this.builder = new UsuarioBuilder();
		this.usuario = builder.build();
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(false);
		when(this.usuarioRepositorio.consultarUsuario(DOCUMENTO)).thenReturn(this.usuario);
		this.usuarioService = new UsuarioService(this.usuarioRepositorio);

		try {
			// act
			this.usuarioService.consultarUsuario(DOCUMENTO);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(USUARIO_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void consultarUsuariosNullOkTest() {
		// arrange

		when(this.usuarioRepositorio.listarUsuarios()).thenReturn(null);
		this.usuarioService = new UsuarioService(this.usuarioRepositorio);

		// act
		List<UsuarioEntidad> consultados = this.usuarioService.listarUsuarios();

		// assert
		assertEquals(null, consultados);

	}

	@Test
	void consultarUsuariosOkTest() {
		// arrange
		List<UsuarioEntidad> usuarios = new ArrayList<UsuarioEntidad>();
		this.builder = new UsuarioBuilder();
		this.usuario = builder.build();
		usuarios.add(this.usuario);
		when(this.usuarioRepositorio.listarUsuarios()).thenReturn(usuarios);
		this.usuarioService = new UsuarioService(this.usuarioRepositorio);

		// act
		List<UsuarioEntidad> consultados = this.usuarioService.listarUsuarios();

		// assert
		assertEquals(usuarios, consultados);
		assertEquals(1, usuarios.size());

	}

}
