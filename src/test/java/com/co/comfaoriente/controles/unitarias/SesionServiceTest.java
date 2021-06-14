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

import com.co.comfaoriente.controles.dominio.entidades.RolEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.UnauthorizedException;
import com.co.comfaoriente.controles.dominio.repositorios.SesionRepositorio;
import com.co.comfaoriente.controles.dominio.servicios.SesionService;

@SpringBootTest
public class SesionServiceTest {

	private SesionRepositorio sesionRepositorio;
	private SesionService sesionService;
	private static final int ID_ROL = 1;
	private static final int DOCUMENTO = 1093779211;

	@BeforeEach
	public void setUp() {
		this.sesionRepositorio = mock(SesionRepositorio.class);
	}

	@Test
	void build() {
		// act
		this.sesionService = new SesionService(this.sesionRepositorio);
		// assert
		assertNotNull(this.sesionRepositorio);
		assertNotNull(this.sesionService);
	}

	@Test
	void logearseOkTest() {
		// arrange
		List<String> privilegios = new ArrayList<String>();
		privilegios.add("ADMIN");
		when(this.sesionRepositorio.existeUsuario(DOCUMENTO, DOCUMENTO + "")).thenReturn(true);
		when(this.sesionRepositorio.consultarRolesUsuario(DOCUMENTO, ID_ROL)).thenReturn(true);
		when(this.sesionRepositorio.consultarPrivilegios(ID_ROL)).thenReturn(privilegios);
		this.sesionService = new SesionService(this.sesionRepositorio);

		// act
		List<String> listado = this.sesionService.iniciarSesion(DOCUMENTO, DOCUMENTO + "", ID_ROL);

		// assert
		assertEquals(privilegios, listado);

	}

	@Test
	void logearseConUsuarioInvalidoTest() {
		// arrange
		List<String> privilegios = new ArrayList<String>();
		privilegios.add("ADMIN");
		when(this.sesionRepositorio.existeUsuario(DOCUMENTO, DOCUMENTO + "")).thenReturn(false);
		when(this.sesionRepositorio.consultarRolesUsuario(DOCUMENTO, ID_ROL)).thenReturn(true);
		when(this.sesionRepositorio.consultarPrivilegios(ID_ROL)).thenReturn(privilegios);
		this.sesionService = new SesionService(this.sesionRepositorio);

		try {
			// act
			this.sesionService.iniciarSesion(DOCUMENTO, DOCUMENTO + "", ID_ROL);
			fail();
		} catch (UnauthorizedException e) {
			// assert
			assertEquals("LA CLAVE O EL USUARIO NO SON CORRECTOS", e.getMessage());
		}

	}

	@Test
	void logearseConRolInvalidoTest() {
		// arrange
		List<String> privilegios = new ArrayList<String>();
		privilegios.add("ADMIN");
		when(this.sesionRepositorio.existeUsuario(DOCUMENTO, DOCUMENTO + "")).thenReturn(true);
		when(this.sesionRepositorio.consultarRolesUsuario(DOCUMENTO, ID_ROL)).thenReturn(false);
		when(this.sesionRepositorio.consultarPrivilegios(ID_ROL)).thenReturn(privilegios);
		this.sesionService = new SesionService(this.sesionRepositorio);

		try {
			// act
			this.sesionService.iniciarSesion(DOCUMENTO, DOCUMENTO + "", ID_ROL);
			fail();
		} catch (UnauthorizedException e) {
			// assert
			assertEquals("NO TIENE PERMISOS PARA ESTE ROL", e.getMessage());
		}

	}

	@Test
	void listarRolesOkTest() {
		// arrange
		List<RolEntidad> roles = new ArrayList<RolEntidad>();
		roles.add(new RolEntidad(ID_ROL, "JOSE"));
		when(this.sesionRepositorio.listarRoles()).thenReturn(roles);
		this.sesionService = new SesionService(this.sesionRepositorio);

		// act
		List<RolEntidad> listado = this.sesionService.listarRoles();

		// assert
		assertEquals(roles, listado);
		assertEquals(1, listado.size());

	}

}
