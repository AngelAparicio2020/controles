package com.co.comfaoriente.controles.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.IngresoRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.SeguimientoSaludRepositorio;
import com.co.comfaoriente.controles.dominio.servicios.IngresoService;

@SpringBootTest
class IngresoServiceTest {

	private IngresoRepositorio ingresoRepositorio;
	private SeguimientoSaludRepositorio seguimientoRepositorio;
	private IngresoService ingresoService;
	private static final int ID = 1;
	private static final String INGRESO_NO_ENCONTRADO = "NO EXISTE UN INGRESO CON ESTE ID";
	private static final String SEGUIMIENTO_NO_ENCONTRADO = "NO EXISTE UN SEGUIMIENTO CON ESTE ID";

	@BeforeEach
	public void setUp() {
		this.ingresoRepositorio = mock(IngresoRepositorio.class);
		this.seguimientoRepositorio = mock(SeguimientoSaludRepositorio.class);
	}

	@Test
	void build() {
		// act
		this.ingresoService = new IngresoService(this.ingresoRepositorio, this.seguimientoRepositorio);
		// assert
		assertNotNull(this.ingresoRepositorio);
		assertNotNull(this.seguimientoRepositorio);
		assertNotNull(this.ingresoService);
	}

	@Test
	void registrarIngresoOkTest() {
		// arrange
		IngresoEntidad ingreso = new IngresoEntidad();
		ingreso.setIdSeguimiento(ID);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(true);
		when(this.ingresoRepositorio.registrarIngreso(ingreso)).thenReturn(ID);
		this.ingresoService = new IngresoService(this.ingresoRepositorio, this.seguimientoRepositorio);
		// act
		int registrado = this.ingresoService.registrarIngreso(ingreso);

		// assert
		assertEquals(ID, registrado);
	}

	@Test
	void registrarIngresoFailTest() {
		// arrange
		IngresoEntidad ingreso = new IngresoEntidad();
		ingreso.setIdSeguimiento(ID);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(false);
		when(this.ingresoRepositorio.registrarIngreso(ingreso)).thenReturn(0);
		this.ingresoService = new IngresoService(this.ingresoRepositorio, this.seguimientoRepositorio);

		try {
			// act
			this.ingresoService.registrarIngreso(ingreso);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(SEGUIMIENTO_NO_ENCONTRADO, e.getMessage());
		}
	}

	@Test
	void actualizarIngresoOkTest() {
		// arrange
		IngresoEntidad ingreso = new IngresoEntidad();
		ingreso.setId(ID);
		when(this.ingresoRepositorio.existeIngreso(ID)).thenReturn(true);
		when(this.ingresoRepositorio.actualizarIngreso(ingreso)).thenReturn(true);
		this.ingresoService = new IngresoService(this.ingresoRepositorio, this.seguimientoRepositorio);
		// act
		boolean actualizado = this.ingresoService.actualizarIngreso(ingreso);

		// assert
		assertEquals(true, actualizado);
	}

	@Test
	void actualizarIngresoFailTest() {
		// arrange
		IngresoEntidad ingreso = new IngresoEntidad();
		ingreso.setId(ID);
		when(this.ingresoRepositorio.existeIngreso(ID)).thenReturn(false);
		when(this.ingresoRepositorio.actualizarIngreso(ingreso)).thenReturn(false);
		this.ingresoService = new IngresoService(this.ingresoRepositorio, this.seguimientoRepositorio);

		try {
			// act
			this.ingresoService.actualizarIngreso(ingreso);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(INGRESO_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void consultarIngresoOkTest() {
		// arrange
		IngresoEntidad ingreso = new IngresoEntidad();
		when(this.ingresoRepositorio.consultarIngreso(ID)).thenReturn(ingreso);
		when(this.ingresoRepositorio.existeIngreso(ID)).thenReturn(true);
		this.ingresoService = new IngresoService(this.ingresoRepositorio, this.seguimientoRepositorio);
		// act
		IngresoEntidad consultado = this.ingresoService.consultarIngreso(ID);

		// assert
		assertNotNull(consultado);
	}

	@Test
	void consultarIngresoFailNuloTest() {
		// arrange
		when(this.ingresoRepositorio.consultarIngreso(ID)).thenReturn(null);
		when(this.ingresoRepositorio.existeIngreso(ID)).thenReturn(false);
		this.ingresoService = new IngresoService(this.ingresoRepositorio, this.seguimientoRepositorio);

		try {
			// act
			this.ingresoService.consultarIngreso(ID);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(INGRESO_NO_ENCONTRADO, e.getMessage());
		}
	}

	@Test
	void eliminarIngresoOkTest() {
		// arrange

		when(this.ingresoRepositorio.existeIngreso(ID)).thenReturn(true);
		when(this.ingresoRepositorio.eliminarIngreso(ID)).thenReturn(true);
		this.ingresoService = new IngresoService(this.ingresoRepositorio, this.seguimientoRepositorio);
		// act
		boolean eliminado = this.ingresoService.eliminarIngreso(ID);

		// assert
		assertEquals(true, eliminado);
	}

	@Test
	void eliminarIngresoFailTest() {
		// arrange

		when(this.ingresoRepositorio.existeIngreso(ID)).thenReturn(false);
		when(this.ingresoRepositorio.eliminarIngreso(ID)).thenReturn(true);
		this.ingresoService = new IngresoService(this.ingresoRepositorio, this.seguimientoRepositorio);

		try {
			// act
			this.ingresoService.eliminarIngreso(ID);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(INGRESO_NO_ENCONTRADO, e.getMessage());
		}
	}

	@Test
	void consultarIngresoxSeguimientoOkTest() {
		// arrange
		IngresoEntidad ingreso = new IngresoEntidad();
		ingreso.setId(ID);
		ingreso.setIdSeguimiento(ID);
		when(this.ingresoRepositorio.consultarIngresoxSeguimiento(ID)).thenReturn(ingreso);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(true);
		this.ingresoService = new IngresoService(this.ingresoRepositorio, this.seguimientoRepositorio);

		// act
		IngresoEntidad consultado = this.ingresoService.consultarIngresoxSeguimiento(ID);

		// assert
		assertNotNull(consultado);
	}

	@Test
	void consultarIngresoxSeguimientoFailNuloTest() {
		// arrange
		IngresoEntidad ingreso = new IngresoEntidad();
		ingreso.setId(ID);
		ingreso.setIdSeguimiento(ID);
		when(this.ingresoRepositorio.consultarIngresoxSeguimiento(ID)).thenReturn(ingreso);
		when(this.seguimientoRepositorio.existeSeguimiento(ID)).thenReturn(false);
		this.ingresoService = new IngresoService(this.ingresoRepositorio, this.seguimientoRepositorio);

		try {
			// act
			this.ingresoService.consultarIngresoxSeguimiento(ID);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(SEGUIMIENTO_NO_ENCONTRADO, e.getMessage());
		}
	}

}
