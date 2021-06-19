package com.co.comfaoriente.controles.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.comfaoriente.controles.dominio.entidades.CompromisoEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.CompromisoRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.SeguimientoSaludRepositorio;
import com.co.comfaoriente.controles.dominio.servicios.CompromisoService;

@SpringBootTest
class CompromisoServiceTest {

	private CompromisoRepositorio compromisoRepositorio;
	private SeguimientoSaludRepositorio seguimientoRepositorio;
	private CompromisoService compromisoService;
	private static final int ID = 1;
	private static final String COMPROMISO_NO_ENCONTRADO = "NO EXISTE UN COMPROMISO CON ESTE ID";
	private static final String SEGUIMIENTO_NO_ENCONTRADO = "NO EXISTE UN SEGUIMIENTO CON ESTE ID";

	@BeforeEach
	public void setUp() {
		this.compromisoRepositorio = mock(CompromisoRepositorio.class);
		this.seguimientoRepositorio = mock(SeguimientoSaludRepositorio.class);
	}

	@Test
	void build() {
		// act
		this.compromisoService = new CompromisoService(this.compromisoRepositorio, this.seguimientoRepositorio);
		// assert
		assertNotNull(this.compromisoRepositorio);
		assertNotNull(this.seguimientoRepositorio);
		assertNotNull(this.compromisoService);
	}

	@Test
	void registrarCompromisoOkTest() {
		// arrange
		CompromisoEntidad compromiso = new CompromisoEntidad();
		compromiso.setIdSeguimientoSalud(ID);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(true);
		when(this.compromisoRepositorio.registrarCompromiso(compromiso)).thenReturn(true);
		this.compromisoService = new CompromisoService(this.compromisoRepositorio, this.seguimientoRepositorio);
		// act
		boolean registrado = this.compromisoService.registrarCompromiso(compromiso);

		// assert
		assertEquals(true, registrado);
	}

	@Test
	void registrarCompromisoFailTest() {
		// arrange
		CompromisoEntidad compromiso = new CompromisoEntidad();
		compromiso.setIdSeguimientoSalud(ID);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(false);
		when(this.compromisoRepositorio.registrarCompromiso(compromiso)).thenReturn(true);
		this.compromisoService = new CompromisoService(this.compromisoRepositorio, this.seguimientoRepositorio);

		try {
			// act
			this.compromisoService.registrarCompromiso(compromiso);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(SEGUIMIENTO_NO_ENCONTRADO, e.getMessage());
		}
	}

	@Test
	void actualizarCompromisoOkTest() {
		// arrange
		CompromisoEntidad compromiso = new CompromisoEntidad();
		compromiso.setId(ID);
		when(this.compromisoRepositorio.existeCompromiso(ID)).thenReturn(true);
		when(this.compromisoRepositorio.actualizarCompromiso(compromiso)).thenReturn(true);
		this.compromisoService = new CompromisoService(this.compromisoRepositorio, this.seguimientoRepositorio);
		// act
		boolean actualizado = this.compromisoService.actualizarCompromiso(compromiso);

		// assert
		assertEquals(true, actualizado);
	}

	@Test
	void actualizarCompromisoFailTest() {
		// arrange
		CompromisoEntidad compromiso = new CompromisoEntidad();
		compromiso.setId(ID);
		when(this.compromisoRepositorio.existeCompromiso(ID)).thenReturn(false);
		when(this.compromisoRepositorio.actualizarCompromiso(compromiso)).thenReturn(false);
		this.compromisoService = new CompromisoService(this.compromisoRepositorio, this.seguimientoRepositorio);

		try {
			// act
			this.compromisoService.actualizarCompromiso(compromiso);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(COMPROMISO_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void consultarCompromisoOkTest() {
		// arrange
		CompromisoEntidad compromiso = new CompromisoEntidad();
		compromiso.setId(ID);
		when(this.compromisoRepositorio.consultarCompromiso(ID)).thenReturn(compromiso);
		when(this.compromisoRepositorio.existeCompromiso(ID)).thenReturn(true);
		this.compromisoService = new CompromisoService(this.compromisoRepositorio, this.seguimientoRepositorio);
		// act
		CompromisoEntidad consultado = this.compromisoService.consultarCompromiso(ID);

		// assert
		assertNotNull(consultado);
	}

	@Test
	void consultarCompromisoFailNuloTest() {
		// arrange
		when(this.compromisoRepositorio.consultarCompromiso(ID)).thenReturn(null);
		when(this.compromisoRepositorio.existeCompromiso(ID)).thenReturn(false);
		this.compromisoService = new CompromisoService(this.compromisoRepositorio, this.seguimientoRepositorio);

		try {
			// act
			this.compromisoService.consultarCompromiso(ID);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(COMPROMISO_NO_ENCONTRADO, e.getMessage());
		}
	}

	@Test
	void eliminarCompromisoOkTest() {
		// arrange

		when(this.compromisoRepositorio.existeCompromiso(ID)).thenReturn(true);
		when(this.compromisoRepositorio.eliminarCompromiso(ID)).thenReturn(true);
		this.compromisoService = new CompromisoService(this.compromisoRepositorio, this.seguimientoRepositorio);
		// act
		boolean eliminado = this.compromisoService.eliminarCompromiso(ID);

		// assert
		assertEquals(true, eliminado);
	}

	@Test
	void eliminarCompromisoFailTest() {
		// arrange

		when(this.compromisoRepositorio.existeCompromiso(ID)).thenReturn(false);
		when(this.compromisoRepositorio.eliminarCompromiso(ID)).thenReturn(true);
		this.compromisoService = new CompromisoService(this.compromisoRepositorio, this.seguimientoRepositorio);

		try {
			// act
			this.compromisoService.eliminarCompromiso(ID);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(COMPROMISO_NO_ENCONTRADO, e.getMessage());
		}
	}

	@Test
	void consultarCompromisoxSeguimientoOkTest() {
		// arrange
		CompromisoEntidad compromiso = new CompromisoEntidad();
		compromiso.setId(ID);
		compromiso.setIdSeguimientoSalud(ID);
		when(this.compromisoRepositorio.consultarCompromisoxSeguimiento(ID)).thenReturn(compromiso);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(true);
		this.compromisoService = new CompromisoService(this.compromisoRepositorio, this.seguimientoRepositorio);
		// act
		CompromisoEntidad consultado = this.compromisoService.consultarCompromisoxSeguimiento(ID);

		// assert
		assertNotNull(consultado);
	}

	@Test
	void consultarCompromisoxSeguimientoFailNuloTest() {
		// arrange
		CompromisoEntidad compromiso = new CompromisoEntidad();
		compromiso.setId(ID);
		compromiso.setIdSeguimientoSalud(ID);
		when(this.compromisoRepositorio.consultarCompromisoxSeguimiento(ID)).thenReturn(compromiso);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(false);
		this.compromisoService = new CompromisoService(this.compromisoRepositorio, this.seguimientoRepositorio);

		try {
			// act
			this.compromisoService.consultarCompromisoxSeguimiento(ID);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(SEGUIMIENTO_NO_ENCONTRADO, e.getMessage());
		}
	}

}
