package com.co.comfaoriente.controles.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.comfaoriente.controles.dominio.entidades.IngresoMadreEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.IngresoRepositorio;
import com.co.comfaoriente.controles.dominio.servicios.IngresoMadreService;

@SpringBootTest
class IngresoMadreServiceTest {

	private IngresoRepositorio ingresoRepositorio;
	private IngresoMadreService ingresoService;
	private static final int ID = 1;

	@BeforeEach
	public void setUp() {
		this.ingresoRepositorio = mock(IngresoRepositorio.class);
	}

	@Test
	void build() {
		// act
		this.ingresoService = new IngresoMadreService(this.ingresoRepositorio);
		// assert
		assertNotNull(this.ingresoRepositorio);
		assertNotNull(this.ingresoService);
	}

	@Test
	void registrarIngresoMadreOkTest() {
		// arrange
		IngresoMadreEntidad ingreso = new IngresoMadreEntidad();
		when(this.ingresoRepositorio.registrarIngresoMadre(ingreso)).thenReturn(true);
		this.ingresoService = new IngresoMadreService(this.ingresoRepositorio);
		// act
		boolean registrado = this.ingresoService.registrarIngresoMadre(ingreso);

		// assert
		assertEquals(true, registrado);
	}

	@Test
	void registrarIngresoMadreFailTest() {
		// arrange
		IngresoMadreEntidad ingreso = new IngresoMadreEntidad();
		when(this.ingresoRepositorio.registrarIngresoMadre(ingreso)).thenReturn(false);
		this.ingresoService = new IngresoMadreService(this.ingresoRepositorio);
		// act
		boolean registrado = this.ingresoService.registrarIngresoMadre(ingreso);

		// assert
		assertEquals(false, registrado);
	}

	@Test
	void actualizarIngresoMadreOkTest() {
		// arrange
		IngresoMadreEntidad ingreso = new IngresoMadreEntidad();
		when(this.ingresoRepositorio.actualizarIngresoMadre(ingreso)).thenReturn(true);
		this.ingresoService = new IngresoMadreService(this.ingresoRepositorio);
		// act
		boolean actualizado = this.ingresoService.actualizarIngresoMadre(ingreso);

		// assert
		assertEquals(true, actualizado);
	}

	@Test
	void actualizarIngresoMadreFailTest() {
		// arrange
		IngresoMadreEntidad ingreso = new IngresoMadreEntidad();
		when(this.ingresoRepositorio.actualizarIngresoMadre(ingreso)).thenReturn(false);
		this.ingresoService = new IngresoMadreService(this.ingresoRepositorio);
		// act
		boolean actualizado = this.ingresoService.actualizarIngresoMadre(ingreso);

		// assert
		assertEquals(false, actualizado);
	}

	@Test
	void consultarIngresoMadreOkTest() {
		// arrange
		IngresoMadreEntidad ingreso = new IngresoMadreEntidad();
		when(this.ingresoRepositorio.consultarIngresoMadre(ID)).thenReturn(ingreso);
		this.ingresoService = new IngresoMadreService(this.ingresoRepositorio);
		// act
		IngresoMadreEntidad consultado = this.ingresoService.consultarIngresoMadre(ID);

		// assert
		assertNotNull(consultado);
	}

	@Test
	void consultarIngresoMadreFailNuloTest() {
		// arrange
		when(this.ingresoRepositorio.consultarIngresoMadre(ID)).thenReturn(null);
		this.ingresoService = new IngresoMadreService(this.ingresoRepositorio);
		// act
		IngresoMadreEntidad consultado = this.ingresoService.consultarIngresoMadre(ID);

		// assert
		assertNull(consultado);
	}
}
