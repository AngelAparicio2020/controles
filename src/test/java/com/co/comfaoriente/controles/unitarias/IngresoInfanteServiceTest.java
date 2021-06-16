package com.co.comfaoriente.controles.unitarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.comfaoriente.controles.dominio.entidades.IngresoInfanteEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.IngresoRepositorio;
import com.co.comfaoriente.controles.dominio.servicios.IngresoInfanteService;

@SpringBootTest
public class IngresoInfanteServiceTest {

	private IngresoRepositorio ingresoRepositorio;
	private IngresoInfanteService ingresoService;
	private static final int ID = 1;

	@BeforeEach
	public void setUp() {
		this.ingresoRepositorio = mock(IngresoRepositorio.class);
	}

	@Test
	void build() {
		// act
		this.ingresoService = new IngresoInfanteService(this.ingresoRepositorio);
		// assert
		assertNotNull(this.ingresoRepositorio);
		assertNotNull(this.ingresoService);
	}

	@Test
	void registrarIngresoInfanteOkTest() {
		// arrange
		IngresoInfanteEntidad ingreso = new IngresoInfanteEntidad();
		when(this.ingresoRepositorio.registrarIngresoInfante(ingreso)).thenReturn(true);

		this.ingresoService = new IngresoInfanteService(this.ingresoRepositorio);

		// act
		boolean registrado = this.ingresoService.registrarIngresoInfante(ingreso);

		// assert
		assertEquals(true, registrado);
	}

	@Test
	void registrarIngresoInfanteFailTest() {
		// arrange
		IngresoInfanteEntidad ingreso = new IngresoInfanteEntidad();
		when(this.ingresoRepositorio.registrarIngresoInfante(ingreso)).thenReturn(false);

		this.ingresoService = new IngresoInfanteService(this.ingresoRepositorio);

		// act
		boolean registrado = this.ingresoService.registrarIngresoInfante(ingreso);

		// assert
		assertEquals(false, registrado);
	}

	@Test
	void actualizarIngresoInfanteOkTest() {
		// arrange
		IngresoInfanteEntidad ingreso = new IngresoInfanteEntidad();
		when(this.ingresoRepositorio.actualizarIngresoInfante(ingreso)).thenReturn(true);

		this.ingresoService = new IngresoInfanteService(this.ingresoRepositorio);

		// act
		boolean actualizado = this.ingresoService.actualizarIngresoInfante(ingreso);

		// assert
		assertEquals(true, actualizado);
	}

	@Test
	void actualizarIngresoInfanteFailTest() {
		// arrange
		IngresoInfanteEntidad ingreso = new IngresoInfanteEntidad();
		when(this.ingresoRepositorio.actualizarIngresoInfante(ingreso)).thenReturn(false);

		this.ingresoService = new IngresoInfanteService(this.ingresoRepositorio);

		// act
		boolean actualizado = this.ingresoService.actualizarIngresoInfante(ingreso);

		// assert
		assertEquals(false, actualizado);
	}

	@Test
	void consultarIngresoInfanteOkTest() {
		// arrange
		IngresoInfanteEntidad ingreso = new IngresoInfanteEntidad();
		when(this.ingresoRepositorio.consultarIngresoInfante(ID)).thenReturn(ingreso);

		this.ingresoService = new IngresoInfanteService(this.ingresoRepositorio);

		// act
		IngresoInfanteEntidad consultado = this.ingresoService.consultarIngresoInfante(ID);

		// assert
		assertNotNull(consultado);
	}

	@Test
	void consultarIngresoInfanteFailNuloTest() {
		// arrange
		when(this.ingresoRepositorio.consultarIngresoInfante(ID)).thenReturn(null);

		this.ingresoService = new IngresoInfanteService(this.ingresoRepositorio);

		// act
		IngresoInfanteEntidad consultado = this.ingresoService.consultarIngresoInfante(ID);

		// assert
		assertNull(consultado);
	}

}
