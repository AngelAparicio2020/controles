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

import com.co.comfaoriente.controles.dominio.entidades.SeguimientoSaludEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.SeguimientoSaludRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.UsuarioRepositorio;
import com.co.comfaoriente.controles.dominio.servicios.SeguimientoSaludService;
import com.co.comfaoriente.controles.unitarias.dataBuilder.SeguimientoSaludBuilder;

@SpringBootTest
public class SeguimientoSaludServiceTest {

	private SeguimientoSaludRepositorio seguimientoRepositorio;
	private UsuarioRepositorio usuarioRepositorio;
	private SeguimientoSaludService seguimientoService;
	private SeguimientoSaludBuilder builder;
	private SeguimientoSaludEntidad seguimiento;
	private static final int DOCUMENTO = 1093779222;
	private static final int DOCUMENTO_NUTRICIONISTA = 1093779223;
	private static final int ID = 1;
	private static final String USUARIO_NO_ENCONTRADO = "NO EXISTE UN USUARIO CON ESTE DOCUMENTO";
	private static final String NUTRICIONISTA_NO_ENCONTRADO = "NO EXISTE UN NUTRICIONISTA CON ESTE DOCUMENTO";
	private static final String SEGUIMIENTO_NO_ENCONTRADO = "NO EXISTE UN SEGUIMIENTO CON ESTE ID";

	@BeforeEach
	public void setUp() {
		this.seguimientoRepositorio = mock(SeguimientoSaludRepositorio.class);
		this.usuarioRepositorio = mock(UsuarioRepositorio.class);
	}

	@Test
	void build() {
		// act
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);
		// assert
		assertNotNull(this.seguimientoRepositorio);
		assertNotNull(this.usuarioRepositorio);
		assertNotNull(this.seguimientoService);
	}

	@Test
	void registrarControlOkTest() {
		// arrange
		this.builder = new SeguimientoSaludBuilder();
		this.seguimiento = builder.build();
		when(this.seguimientoRepositorio.registrarSeguimiento(seguimiento)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.seguimientoRepositorio.cantidadDeSeguimientosDePersona(DOCUMENTO)).thenReturn(0);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(true);
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);

		// act
		boolean registrado = this.seguimientoService.registrarSeguimiento(this.seguimiento);

		// assert
		assertEquals(true, registrado);

	}

	@Test
	void registrarControlNoExisteUsuarioTest() {
		// arrange
		this.builder = new SeguimientoSaludBuilder();
		this.seguimiento = builder.build();
		when(this.seguimientoRepositorio.registrarSeguimiento(seguimiento)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(false);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(true);
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);

		try {
			// act
			this.seguimientoService.registrarSeguimiento(seguimiento);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(USUARIO_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void registrarControlNoExisteUsuarioNutricionistaTest() {
		// arrange
		this.builder = new SeguimientoSaludBuilder();
		this.seguimiento = builder.build();
		when(this.seguimientoRepositorio.registrarSeguimiento(seguimiento)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(false);
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);

		try {
			// act
			this.seguimientoService.registrarSeguimiento(seguimiento);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(NUTRICIONISTA_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void registrarControlConVigenteExistenteOkTest() {
		// arrange
		this.builder = new SeguimientoSaludBuilder();
		this.seguimiento = builder.build();
		when(this.seguimientoRepositorio.registrarSeguimiento(seguimiento)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.seguimientoRepositorio.cantidadDeSeguimientosDePersona(DOCUMENTO)).thenReturn(1);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(true);
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);

		// act
		boolean registrado = this.seguimientoService.registrarSeguimiento(seguimiento);

		// assert
		assertEquals(true, registrado);

	}

	@Test
	void actualizarControlOkTest() {
		// arrange
		this.builder = new SeguimientoSaludBuilder();
		this.seguimiento = builder.build();
		when(this.seguimientoRepositorio.actualizarSeguimiento(seguimiento)).thenReturn(true);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.seguimientoRepositorio.cantidadDeSeguimientosDePersona(DOCUMENTO)).thenReturn(0);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(true);
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);

		// act
		boolean actualizado = this.seguimientoService.actualizarSeguimiento(seguimiento);

		// assert
		assertEquals(true, actualizado);

	}

	@Test
	void actualizarControlFalloTest() {
		// arrange
		this.builder = new SeguimientoSaludBuilder();
		this.seguimiento = builder.build();
		when(this.seguimientoRepositorio.actualizarSeguimiento(seguimiento)).thenReturn(true);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(false);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.seguimientoRepositorio.cantidadDeSeguimientosDePersona(DOCUMENTO)).thenReturn(0);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(true);
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);

		try {
			// act
			this.seguimientoService.actualizarSeguimiento(seguimiento);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(SEGUIMIENTO_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void actualizarControlNuloTest() {
		// arrange
		this.builder = new SeguimientoSaludBuilder();
		this.seguimiento = builder.build();
		when(this.seguimientoRepositorio.actualizarSeguimiento(seguimiento)).thenReturn(true);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(false);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.seguimientoRepositorio.cantidadDeSeguimientosDePersona(DOCUMENTO)).thenReturn(0);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(true);
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);

		try {
			// act
			this.seguimientoService.actualizarSeguimiento(seguimiento);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(SEGUIMIENTO_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void actualizarControlSinUsuarioTest() {
		// arrange
		this.builder = new SeguimientoSaludBuilder();
		this.seguimiento = builder.build();
		when(this.seguimientoRepositorio.actualizarSeguimiento(seguimiento)).thenReturn(true);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(true);
		when(this.seguimientoRepositorio.cantidadDeSeguimientosDePersona(DOCUMENTO)).thenReturn(0);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(false);
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);

		try {
			// act
			this.seguimientoService.actualizarSeguimiento(seguimiento);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(NUTRICIONISTA_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void eliminarControlConVigenteExistenteOkTest() {
		// arrange
		this.builder = new SeguimientoSaludBuilder();
		this.seguimiento = builder.build();
		when(this.seguimientoRepositorio.consultarSeguimiento(ID)).thenReturn(this.seguimiento);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(true);
		when(this.seguimientoRepositorio.eliminarSeguimiento(ID)).thenReturn(true);
		when(this.seguimientoRepositorio.esVigente(ID)).thenReturn(true);
		when(this.seguimientoRepositorio.cantidadDeSeguimientosNoVigentesDePersona(DOCUMENTO)).thenReturn(1);
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);

		// act
		boolean eliminado = this.seguimientoService.eliminarSeguimiento(ID);

		// assert
		assertEquals(true, eliminado);
	}

	@Test
	void eliminarControlSinVigenteExistenteOkTest() {
		// arrange
		this.builder = new SeguimientoSaludBuilder();
		this.seguimiento = builder.build();
		when(this.seguimientoRepositorio.consultarSeguimiento(ID)).thenReturn(this.seguimiento);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(true);
		when(this.seguimientoRepositorio.eliminarSeguimiento(ID)).thenReturn(true);
		when(this.seguimientoRepositorio.esVigente(ID)).thenReturn(true);
		when(this.seguimientoRepositorio.cantidadDeSeguimientosNoVigentesDePersona(DOCUMENTO)).thenReturn(0);
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);

		// act
		boolean eliminado = this.seguimientoService.eliminarSeguimiento(ID);

		// assert
		assertEquals(true, eliminado);
	}

	@Test
	void eliminarControlOkTest() {
		// arrange
		this.builder = new SeguimientoSaludBuilder();
		this.seguimiento = builder.build();
		when(this.seguimientoRepositorio.consultarSeguimiento(ID)).thenReturn(this.seguimiento);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(true);
		when(this.seguimientoRepositorio.eliminarSeguimiento(ID)).thenReturn(true);
		when(this.seguimientoRepositorio.esVigente(ID)).thenReturn(false);
		when(this.seguimientoRepositorio.cantidadDeSeguimientosNoVigentesDePersona(DOCUMENTO)).thenReturn(0);
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);

		// act
		boolean eliminado = this.seguimientoService.eliminarSeguimiento(ID);

		// assert
		assertEquals(true, eliminado);
	}

	@Test
	void eliminarControlFalloTest() {
		// arrange
		this.builder = new SeguimientoSaludBuilder();
		this.seguimiento = builder.build();
		when(this.seguimientoRepositorio.consultarSeguimiento(ID)).thenReturn(this.seguimiento);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(false);
		when(this.seguimientoRepositorio.eliminarSeguimiento(ID)).thenReturn(true);
		when(this.seguimientoRepositorio.cantidadDeSeguimientosNoVigentesDePersona(DOCUMENTO)).thenReturn(0);
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);

		try {
			// act
			this.seguimientoService.eliminarSeguimiento(ID);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(SEGUIMIENTO_NO_ENCONTRADO, e.getMessage());
		}
	}

	@Test
	void consultarControlOkTest() {
		// arrange
		this.builder = new SeguimientoSaludBuilder();
		this.seguimiento = builder.build();
		when(this.seguimientoRepositorio.consultarSeguimiento(ID)).thenReturn(this.seguimiento);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(true);
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);

		// act
		SeguimientoSaludEntidad consultado = this.seguimientoService.consultarSeguimiento(ID);

		// assert
		assertEquals(this.seguimiento, consultado);
	}

	@Test
	void consultarControlFalloTest() {
		// arrange
		this.builder = new SeguimientoSaludBuilder();
		this.seguimiento = builder.build();
		when(this.seguimientoRepositorio.consultarSeguimiento(ID)).thenReturn(this.seguimiento);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(false);
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);

		try {
			// act
			this.seguimientoService.consultarSeguimiento(ID);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(SEGUIMIENTO_NO_ENCONTRADO, e.getMessage());
		}
	}

	@Test
	void consultarSeguimientosxDocumentoOkTest() {
		// arrange
		List<Integer> seguimientos = new ArrayList<>();
		seguimientos.add(ID);
		when(this.seguimientoRepositorio.listadoSeguimientosSaludxDocumento(DOCUMENTO)).thenReturn(seguimientos);
		this.seguimientoService = new SeguimientoSaludService(this.seguimientoRepositorio, usuarioRepositorio);

		// act
		List<Integer> consultados = this.seguimientoService.listarSeguimientosxDocumento(DOCUMENTO);

		// assert
		assertEquals(seguimientos, consultados);

	}

}
