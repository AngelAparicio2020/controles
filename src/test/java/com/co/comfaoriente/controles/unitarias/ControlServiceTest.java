package com.co.comfaoriente.controles.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.comfaoriente.controles.dominio.entidades.ControlEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.ControlRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.UsuarioRepositorio;
import com.co.comfaoriente.controles.dominio.servicios.ControlService;
import com.co.comfaoriente.controles.unitarias.dataBuilder.ControlBuilder;

@SpringBootTest
class ControlServiceTest {

	private ControlRepositorio controlRepositorio;
	private UsuarioRepositorio usuarioRepositorio;
	private ControlService controlService;
	private ControlBuilder builder;
	private ControlEntidad control;
	private static final int DOCUMENTO = 1093779222;
	private static final int DOCUMENTO_NUTRICIONISTA = 1093779223;
	private static final int ID = 1;
	private static final String USUARIO_NO_ENCONTRADO = "NO EXISTE UN USUARIO CON ESTE DOCUMENTO";
	private static final String NUTRICIONISTA_NO_ENCONTRADO = "NO EXISTE UN NUTRICIONISTA CON ESTE DOCUMENTO";
	private static final String CONTROL_NO_ENCONTRADO = "NO EXISTE UN CONTROL CON ESTE ID";

	@BeforeEach
	public void setUp() {
		this.controlRepositorio = mock(ControlRepositorio.class);
		this.usuarioRepositorio = mock(UsuarioRepositorio.class);
	}

	@Test
	void build() {
		// act
		this.controlService = new ControlService(this.controlRepositorio, usuarioRepositorio);
		// assert
		assertNotNull(this.controlRepositorio);
		assertNotNull(this.usuarioRepositorio);
		assertNotNull(this.controlService);
	}

	@Test
	void registrarControlOkTest() {
		// arrange
		this.builder = new ControlBuilder();
		this.control = builder.build();
		when(this.controlRepositorio.registrarControl(control)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.controlRepositorio.cantidadDeControlesDePersona(DOCUMENTO)).thenReturn(0);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(true);
		this.controlService = new ControlService(this.controlRepositorio, usuarioRepositorio);

		// act
		boolean registrado = this.controlService.registrarControl(control);

		// assert
		assertEquals(true, registrado);

	}

	@Test
	void registrarControlNoExisteUsuarioTest() {
		// arrange
		this.builder = new ControlBuilder();
		this.control = builder.build();
		when(this.controlRepositorio.registrarControl(control)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(false);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(true);
		this.controlService = new ControlService(this.controlRepositorio, usuarioRepositorio);

		try {
			// act
			this.controlService.registrarControl(control);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(USUARIO_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void registrarControlNoExisteUsuarioNutricionistaTest() {
		// arrange
		this.builder = new ControlBuilder();
		this.control = builder.build();
		when(this.controlRepositorio.registrarControl(control)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(false);
		this.controlService = new ControlService(this.controlRepositorio, usuarioRepositorio);

		try {
			// act
			this.controlService.registrarControl(control);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(NUTRICIONISTA_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void registrarControlConVigenteExistenteOkTest() {
		// arrange
		this.builder = new ControlBuilder();
		this.control = builder.build();
		when(this.controlRepositorio.registrarControl(control)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.controlRepositorio.cantidadDeControlesDePersona(DOCUMENTO)).thenReturn(1);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(true);
		this.controlService = new ControlService(this.controlRepositorio, usuarioRepositorio);

		// act
		boolean registrado = this.controlService.registrarControl(control);

		// assert
		assertEquals(true, registrado);

	}

	@Test
	void actualizarControlOkTest() {
		// arrange
		this.builder = new ControlBuilder();
		this.control = builder.build();
		when(this.controlRepositorio.actualizarControl(control)).thenReturn(true);
		when(this.controlRepositorio.existeControl(ID)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.controlRepositorio.cantidadDeControlesDePersona(DOCUMENTO)).thenReturn(0);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(true);
		this.controlService = new ControlService(this.controlRepositorio, usuarioRepositorio);

		// act
		boolean actualizado = this.controlService.actualizarControl(control);

		// assert
		assertEquals(true, actualizado);

	}

	@Test
	void actualizarControlFalloTest() {
		// arrange
		this.builder = new ControlBuilder();
		this.control = builder.build();
		when(this.controlRepositorio.actualizarControl(control)).thenReturn(true);
		when(this.controlRepositorio.existeControl(ID)).thenReturn(false);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.controlRepositorio.cantidadDeControlesDePersona(DOCUMENTO)).thenReturn(0);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(true);
		this.controlService = new ControlService(this.controlRepositorio, usuarioRepositorio);

		try {
			// act
			this.controlService.actualizarControl(control);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(CONTROL_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void actualizarControlNuloTest() {
		// arrange
		this.builder = new ControlBuilder();
		this.control = builder.build();
		when(this.controlRepositorio.actualizarControl(control)).thenReturn(true);
		when(this.controlRepositorio.existeControl(ID)).thenReturn(false);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.controlRepositorio.cantidadDeControlesDePersona(DOCUMENTO)).thenReturn(0);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(true);
		this.controlService = new ControlService(this.controlRepositorio, usuarioRepositorio);

		try {
			// act
			this.controlService.actualizarControl(control);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(CONTROL_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void actualizarControlSinUsuarioTest() {
		// arrange
		this.builder = new ControlBuilder();
		this.control = builder.build();
		when(this.controlRepositorio.actualizarControl(control)).thenReturn(true);
		when(this.controlRepositorio.existeControl(ID)).thenReturn(true);
		when(this.controlRepositorio.cantidadDeControlesDePersona(DOCUMENTO)).thenReturn(0);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO_NUTRICIONISTA)).thenReturn(false);
		this.controlService = new ControlService(this.controlRepositorio, usuarioRepositorio);

		try {
			// act
			this.controlService.actualizarControl(control);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(NUTRICIONISTA_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void eliminarControlConVigenteExistenteOkTest() {
		// arrange
		this.builder = new ControlBuilder();
		this.control = builder.build();
		when(this.controlRepositorio.consultarControl(ID)).thenReturn(this.control);
		when(this.controlRepositorio.existeControl(ID)).thenReturn(true);
		when(this.controlRepositorio.eliminarControl(ID)).thenReturn(true);
		when(this.controlRepositorio.esVigente(ID)).thenReturn(true);
		when(this.controlRepositorio.cantidadDeControlesNoVigentesDePersona(DOCUMENTO)).thenReturn(1);
		this.controlService = new ControlService(this.controlRepositorio, usuarioRepositorio);

		// act
		boolean eliminado = this.controlService.eliminarControl(ID);

		// assert
		assertEquals(true, eliminado);
	}
	
	@Test
	void eliminarControlSinVigenteExistenteOkTest() {
		// arrange
		this.builder = new ControlBuilder();
		this.control = builder.build();
		when(this.controlRepositorio.consultarControl(ID)).thenReturn(this.control);
		when(this.controlRepositorio.existeControl(ID)).thenReturn(true);
		when(this.controlRepositorio.eliminarControl(ID)).thenReturn(true);
		when(this.controlRepositorio.esVigente(ID)).thenReturn(true);
		when(this.controlRepositorio.cantidadDeControlesNoVigentesDePersona(DOCUMENTO)).thenReturn(0);
		this.controlService = new ControlService(this.controlRepositorio, usuarioRepositorio);

		// act
		boolean eliminado = this.controlService.eliminarControl(ID);

		// assert
		assertEquals(true, eliminado);
	}

	@Test
	void eliminarControlOkTest() {
		// arrange
		this.builder = new ControlBuilder();
		this.control = builder.build();
		when(this.controlRepositorio.consultarControl(ID)).thenReturn(this.control);
		when(this.controlRepositorio.existeControl(ID)).thenReturn(true);
		when(this.controlRepositorio.eliminarControl(ID)).thenReturn(true);
		when(this.controlRepositorio.esVigente(ID)).thenReturn(false);
		when(this.controlRepositorio.cantidadDeControlesDePersona(DOCUMENTO)).thenReturn(0);
		this.controlService = new ControlService(this.controlRepositorio, usuarioRepositorio);

		// act
		boolean eliminado = this.controlService.eliminarControl(ID);

		// assert
		assertEquals(true, eliminado);
	}

	@Test
	void eliminarControlFalloTest() {
		// arrange
		this.builder = new ControlBuilder();
		this.control = builder.build();
		when(this.controlRepositorio.consultarControl(ID)).thenReturn(this.control);
		when(this.controlRepositorio.existeControl(ID)).thenReturn(false);
		when(this.controlRepositorio.eliminarControl(ID)).thenReturn(true);
		when(this.controlRepositorio.cantidadDeControlesDePersona(DOCUMENTO)).thenReturn(0);
		this.controlService = new ControlService(this.controlRepositorio, usuarioRepositorio);

		try {
			// act
			this.controlService.eliminarControl(ID);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(CONTROL_NO_ENCONTRADO, e.getMessage());
		}
	}

	@Test
	void consultarControlOkTest() {
		// arrange
		this.builder = new ControlBuilder();
		this.control = builder.build();
		when(this.controlRepositorio.consultarControl(ID)).thenReturn(this.control);
		when(this.controlRepositorio.existeControl(ID)).thenReturn(true);
		this.controlService = new ControlService(this.controlRepositorio, usuarioRepositorio);

		// act
		ControlEntidad consultado = this.controlService.consultarControl(ID);

		// assert
		assertEquals(this.control, consultado);
	}

	@Test
	void consultarControlFalloTest() {
		// arrange
		this.builder = new ControlBuilder();
		this.control = builder.build();
		when(this.controlRepositorio.consultarControl(ID)).thenReturn(this.control);
		when(this.controlRepositorio.existeControl(ID)).thenReturn(false);
		this.controlService = new ControlService(this.controlRepositorio, usuarioRepositorio);

		try {
			// act
			this.controlService.consultarControl(ID);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(CONTROL_NO_ENCONTRADO, e.getMessage());
		}
	}

}
