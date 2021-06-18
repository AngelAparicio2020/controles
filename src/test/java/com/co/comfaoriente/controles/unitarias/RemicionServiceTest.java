package com.co.comfaoriente.controles.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.comfaoriente.controles.dominio.entidades.RemicionEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.RemicionRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.SeguimientoSaludRepositorio;
import com.co.comfaoriente.controles.dominio.servicios.RemicionService;

@SpringBootTest
public class RemicionServiceTest {

	private RemicionRepositorio remicionRepositorio;
	private SeguimientoSaludRepositorio seguimientoRepositorio;
	private RemicionService remicionService;
	private static final int ID = 1;
	private static final String REMICION_NO_ENCONTRADA = "NO EXISTE UNA REMICION CON ESTE ID";
	private static final String SEGUIMIENTO_NO_ENCONTRADO = "NO EXISTE UN SEGUIMIENTO CON ESTE ID";

	@BeforeEach
	public void setUp() {
		this.remicionRepositorio = mock(RemicionRepositorio.class);
		this.seguimientoRepositorio = mock(SeguimientoSaludRepositorio.class);
	}

	@Test
	void build() {
		// act
		this.remicionService = new RemicionService(this.remicionRepositorio, this.seguimientoRepositorio);
		// assert
		assertNotNull(this.remicionRepositorio);
		assertNotNull(this.seguimientoRepositorio);
		assertNotNull(this.remicionService);
	}

	@Test
	void registrarIngresoOkTest() {
		// arrange
		RemicionEntidad remicion = new RemicionEntidad();
		remicion.setIdSeguimiento(ID);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(true);
		when(this.remicionRepositorio.registrarRemicion(remicion)).thenReturn(true);
		this.remicionService = new RemicionService(this.remicionRepositorio, this.seguimientoRepositorio);
		// act
		boolean registrado = this.remicionService.registrarRemicion(remicion);

		// assert
		assertEquals(true, registrado);
	}

	@Test
	void registrarIngresoFailTest() {
		// arrange
		RemicionEntidad remicion = new RemicionEntidad();
		remicion.setIdSeguimiento(ID);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(false);
		when(this.remicionRepositorio.registrarRemicion(remicion)).thenReturn(true);
		this.remicionService = new RemicionService(this.remicionRepositorio, this.seguimientoRepositorio);

		try {
			// act
			this.remicionService.registrarRemicion(remicion);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(SEGUIMIENTO_NO_ENCONTRADO, e.getMessage());
		}
	}

	@Test
	void actualizarIngresoOkTest() {
		// arrange
		RemicionEntidad remicion = new RemicionEntidad();
		remicion.setId(ID);
		when(this.remicionRepositorio.existeRemicion(ID)).thenReturn(true);
		when(this.remicionRepositorio.actualizarRemicion(remicion)).thenReturn(true);
		this.remicionService = new RemicionService(this.remicionRepositorio, this.seguimientoRepositorio);
		// act
		boolean actualizado = this.remicionService.actualizarRemicion(remicion);

		// assert
		assertEquals(true, actualizado);
	}

	@Test
	void actualizarIngresoFailTest() {
		// arrange
		RemicionEntidad remicion = new RemicionEntidad();
		remicion.setId(ID);
		when(this.remicionRepositorio.existeRemicion(ID)).thenReturn(false);
		when(this.remicionRepositorio.actualizarRemicion(remicion)).thenReturn(false);
		this.remicionService = new RemicionService(this.remicionRepositorio, this.seguimientoRepositorio);

		try {
			// act
			this.remicionService.actualizarRemicion(remicion);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(REMICION_NO_ENCONTRADA, e.getMessage());
		}

	}

	@Test
	void consultarIngresoOkTest() {
		// arrange
		RemicionEntidad remicion = new RemicionEntidad();
		remicion.setId(ID);
		when(this.remicionRepositorio.consultarRemicion(ID)).thenReturn(remicion);
		when(this.remicionRepositorio.existeRemicion(ID)).thenReturn(true);
		this.remicionService = new RemicionService(this.remicionRepositorio, this.seguimientoRepositorio);
		// act
		RemicionEntidad consultado = this.remicionService.consultarRemicion(ID);

		// assert
		assertNotNull(consultado);
	}

	@Test
	void consultarIngresoFailNuloTest() {
		// arrange
		when(this.remicionRepositorio.consultarRemicion(ID)).thenReturn(null);
		when(this.remicionRepositorio.existeRemicion(ID)).thenReturn(false);
		this.remicionService = new RemicionService(this.remicionRepositorio, this.seguimientoRepositorio);

		try {
			// act
			this.remicionService.consultarRemicion(ID);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(REMICION_NO_ENCONTRADA, e.getMessage());
		}
	}

	@Test
	void eliminarIngresoOkTest() {
		// arrange

		when(this.remicionRepositorio.existeRemicion(ID)).thenReturn(true);
		when(this.remicionRepositorio.eliminarRemicion(ID)).thenReturn(true);
		this.remicionService = new RemicionService(this.remicionRepositorio, this.seguimientoRepositorio);
		// act
		boolean eliminado = this.remicionService.eliminarRemicion(ID);

		// assert
		assertEquals(true, eliminado);
	}

	@Test
	void eliminarIngresoFailTest() {
		// arrange

		when(this.remicionRepositorio.existeRemicion(ID)).thenReturn(false);
		when(this.remicionRepositorio.eliminarRemicion(ID)).thenReturn(true);
		this.remicionService = new RemicionService(this.remicionRepositorio, this.seguimientoRepositorio);

		try {
			// act
			this.remicionService.eliminarRemicion(ID);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(REMICION_NO_ENCONTRADA, e.getMessage());
		}
	}

}
