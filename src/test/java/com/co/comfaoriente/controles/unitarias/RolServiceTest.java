package com.co.comfaoriente.controles.unitarias;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.comfaoriente.controles.dominio.repositorios.RolRepositorio;
import com.co.comfaoriente.controles.dominio.servicios.RolService;

@SpringBootTest
public class RolServiceTest {

	private RolRepositorio rolRepositorio;
	private RolService rolService;
	// private static final String ROL_NO_ENCONTRADO = "NO EXISTE UN ROL CON ESTE
	// ID";

	@BeforeEach
	public void setUp() {
		this.rolRepositorio = mock(RolRepositorio.class);
	}

	@Test
	void build() {
		// act
		this.rolService = new RolService(this.rolRepositorio);
		// assert
		assertNotNull(this.rolRepositorio);
		assertNotNull(this.rolService);
	}

}
