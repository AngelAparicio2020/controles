package com.co.comfaoriente.controles.unitarias;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.comfaoriente.controles.dominio.repositorios.UsuarioRepositorio;
import com.co.comfaoriente.controles.dominio.servicios.UsuarioService;

@SpringBootTest
public class UsuarioServiceTest {

	private UsuarioRepositorio usuarioRepositorio;
	private UsuarioService usuarioService;
	// private static final String ROL_NO_ENCONTRADO = "NO EXISTE UN ROL CON ESTE
	// ID";

	@BeforeEach
	public void setUp() {
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

}
