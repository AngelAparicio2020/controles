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

import com.co.comfaoriente.controles.dominio.entidades.PrivilegioEntidad;
import com.co.comfaoriente.controles.dominio.entidades.RolEntidad;
import com.co.comfaoriente.controles.dominio.excepciones.EntityNotFoundException;
import com.co.comfaoriente.controles.dominio.repositorios.RolRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.UsuarioRepositorio;
import com.co.comfaoriente.controles.dominio.servicios.RolService;
import com.co.comfaoriente.controles.unitarias.dataBuilder.PrivilegioBuilder;
import com.co.comfaoriente.controles.unitarias.dataBuilder.RolBuilder;

@SpringBootTest
public class RolServiceTest {

	private RolRepositorio rolRepositorio;
	private UsuarioRepositorio usuarioRepositorio;
	private RolService rolService;
	private RolEntidad rol;
	private RolBuilder builder;
	private static final int ID_ROL = 1;
	private static final int DOCUMENTO = 1093779211;
	private static final String ROL_NO_ENCONTRADO = "NO EXISTE UN ROL CON ESTE ID";
	private static final String USUARIO_NO_ENCONTRADO = "NO EXISTE UN USUARIO CON ESTE DOCUMENTO";

	@BeforeEach
	public void setUp() {
		this.rolRepositorio = mock(RolRepositorio.class);
		this.usuarioRepositorio = mock(UsuarioRepositorio.class);
	}

	@Test
	void build() {
		// act
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);
		// assert
		assertNotNull(this.rolRepositorio);
		assertNotNull(this.rolService);
	}

	@Test
	void registrarRolOkTest() {
		// arrange
		this.builder = new RolBuilder();
		this.rol = builder.build();
		when(this.rolRepositorio.registrarRol(rol)).thenReturn(true);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		// act
		boolean registrado = this.rolService.registrarRol(rol);

		// assert
		assertEquals(true, registrado);

	}

	@Test
	void registrarRolErrorTest() {
		// arrange
		this.builder = new RolBuilder();
		this.rol = builder.build();
		when(this.rolRepositorio.registrarRol(rol)).thenReturn(false);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		// act
		boolean registrado = this.rolService.registrarRol(rol);

		// assert
		assertEquals(false, registrado);
	}

	@Test
	void asignarRolOkTest() {
		// arrange
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.rolRepositorio.asignarRol(DOCUMENTO, ID_ROL)).thenReturn(true);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		// act
		boolean asignado = this.rolService.asignarRol(DOCUMENTO, ID_ROL);

		// assert
		assertEquals(true, asignado);
	}

	@Test
	void asignarRolNoExistenteTest() {
		// arrange
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(false);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		try {
			// act
			this.rolService.asignarRol(DOCUMENTO, ID_ROL);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(ROL_NO_ENCONTRADO, e.getMessage());
		}
	}

	@Test
	void asignarRolDOCUMENTONoExistenteTest() {
		// arrange
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(false);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		try {
			// act
			this.rolService.asignarRol(DOCUMENTO, ID_ROL);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(USUARIO_NO_ENCONTRADO, e.getMessage());
		}
	}

	@Test
	void retirarRolOkTest() {
		// arrange
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		when(this.rolRepositorio.retirarRol(DOCUMENTO, ID_ROL)).thenReturn(true);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		// act
		boolean asignado = this.rolService.retirarRol(DOCUMENTO, ID_ROL);

		// assert
		assertEquals(true, asignado);
	}

	@Test
	void retirarRolNoExistenteTest() {
		// arrange
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(false);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(true);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		try {
			// act
			this.rolService.retirarRol(DOCUMENTO, ID_ROL);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(ROL_NO_ENCONTRADO, e.getMessage());
		}
	}

	@Test
	void retirarRolDOCUMENTONoExistenteTest() {
		// arrange
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(true);
		when(this.usuarioRepositorio.existeDocumento(DOCUMENTO)).thenReturn(false);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		try {
			// act
			this.rolService.retirarRol(DOCUMENTO, ID_ROL);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(USUARIO_NO_ENCONTRADO, e.getMessage());
		}
	}

	@Test
	void actualizarRolOkTest() {
		// arrange
		this.builder = new RolBuilder().conId(ID_ROL);
		this.rol = builder.build();
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(true);
		when(this.rolRepositorio.actualizarRol(rol)).thenReturn(true);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		// act
		boolean actualizado = this.rolService.actualizarRol(rol);

		// assert
		assertEquals(true, actualizado);

	}

	@Test
	void actualizarRolFalloTest() {
		// arrange
		this.builder = new RolBuilder();
		this.rol = builder.build();
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(false);
		when(this.rolRepositorio.actualizarRol(rol)).thenReturn(true);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		try {
			// act
			this.rolService.actualizarRol(rol);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(ROL_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void actualizarRolNuloTest() {
		// arrange
		this.builder = new RolBuilder();
		this.rol = builder.build();
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(false);
		when(this.rolRepositorio.actualizarRol(rol)).thenReturn(true);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		try {
			// act
			this.rolService.actualizarRol(null);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(ROL_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void eliminarRolOkTest() {
		// arrange
		this.builder = new RolBuilder().conId(ID_ROL);
		this.rol = builder.build();
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(true);
		when(this.rolRepositorio.eliminarRol(ID_ROL)).thenReturn(true);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		// act
		boolean eliminado = this.rolService.eliminarRol(ID_ROL);

		// assert
		assertEquals(true, eliminado);

	}

	@Test
	void eliminarRolFalloTest() {
		// arrange
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(false);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		try {
			// act
			this.rolService.eliminarRol(ID_ROL);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(ROL_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void consultarRolOkTest() {
		// arrange
		this.builder = new RolBuilder().conId(ID_ROL);
		this.rol = builder.build();
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(true);
		when(this.rolRepositorio.consultarRol(ID_ROL)).thenReturn(this.rol);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		// act
		RolEntidad consultado = this.rolService.consultarRol(ID_ROL);

		// assert
		assertEquals(consultado, this.rol);

	}

	@Test
	void consultarRolFalloTest() {
		// arrange
		this.builder = new RolBuilder().conId(ID_ROL);
		this.rol = builder.build();
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(false);
		when(this.rolRepositorio.consultarRol(ID_ROL)).thenReturn(this.rol);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		try {
			// act
			this.rolService.consultarRol(ID_ROL);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(ROL_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void consultarPrivilegiosNullOkTest() {
		// arrange

		when(this.rolRepositorio.consultarPrivilegios()).thenReturn(null);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		// act
		List<PrivilegioEntidad> privilegios = this.rolService.consultarPrivilegios();

		// assert
		assertEquals(null, privilegios);

	}

	@Test
	void consultarPrivilegiosxRolOkTest() {
		// arrange
		PrivilegioBuilder builder = new PrivilegioBuilder();
		PrivilegioEntidad privilegioUno = builder.build();
		PrivilegioEntidad privilegioDos = builder.build();
		List<PrivilegioEntidad> privilegios = new ArrayList<>();
		privilegios.add(privilegioUno);
		privilegios.add(privilegioDos);
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(true);
		when(this.rolRepositorio.consultarPrivilegiosxRol(ID_ROL)).thenReturn(privilegios);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		// act
		List<PrivilegioEntidad> privilegiosXRol = this.rolService.consultarPrivilegiosxRol(ID_ROL);

		// assert
		assertEquals(privilegios, privilegiosXRol);

	}

	@Test
	void consultarPrivilegiosxRolFalloTest() {
		// arrange
		PrivilegioBuilder builder = new PrivilegioBuilder();
		PrivilegioEntidad privilegioUno = builder.build();
		PrivilegioEntidad privilegioDos = builder.build();
		List<PrivilegioEntidad> privilegios = new ArrayList<>();
		privilegios.add(privilegioUno);
		privilegios.add(privilegioDos);
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(false);
		when(this.rolRepositorio.consultarPrivilegiosxRol(ID_ROL)).thenReturn(privilegios);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		try {
			// act
			this.rolService.consultarPrivilegiosxRol(ID_ROL);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(ROL_NO_ENCONTRADO, e.getMessage());
		}

	}

	@Test
	void asignarPrivilegiosxRolOkTest() {
		// arrange
		PrivilegioBuilder builder = new PrivilegioBuilder();
		PrivilegioEntidad privilegioUno = builder.build();
		PrivilegioEntidad privilegioDos = builder.build();
		List<PrivilegioEntidad> privilegios = new ArrayList<>();
		privilegios.add(privilegioUno);
		privilegios.add(privilegioDos);
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(true);
		when(this.rolRepositorio.asignarPrivilegio(privilegios, ID_ROL)).thenReturn(true);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		// act
		boolean privilegiosAsignados = this.rolService.asignarPrivilegios(privilegios, ID_ROL);

		// assert
		assertEquals(true, privilegiosAsignados);

	}

	@Test
	void asignarPrivilegiosxRolNuloOkTest() {
		// arrange
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(true);
		when(this.rolRepositorio.asignarPrivilegio(null, ID_ROL)).thenReturn(true);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		// act
		boolean privilegiosAsignados = this.rolService.asignarPrivilegios(null, ID_ROL);

		// assert
		assertEquals(true, privilegiosAsignados);

	}

	@Test
	void asignarPrivilegiosxRolVacioOkTest() {
		// arrange
		List<PrivilegioEntidad> privilegios = new ArrayList<>();
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(true);
		when(this.rolRepositorio.asignarPrivilegio(privilegios, ID_ROL)).thenReturn(true);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		// act
		boolean privilegiosAsignados = this.rolService.asignarPrivilegios(privilegios, ID_ROL);

		// assert
		assertEquals(true, privilegiosAsignados);
	}

	@Test
	void asignarPrivilegiosxRolFalloTest() {
		// arrange
		PrivilegioBuilder builder = new PrivilegioBuilder();
		PrivilegioEntidad privilegioUno = builder.build();
		PrivilegioEntidad privilegioDos = builder.build();
		List<PrivilegioEntidad> privilegios = new ArrayList<>();
		privilegios.add(privilegioUno);
		privilegios.add(privilegioDos);
		when(this.rolRepositorio.existeRol(ID_ROL)).thenReturn(false);
		when(this.rolRepositorio.asignarPrivilegio(privilegios, ID_ROL)).thenReturn(true);
		this.rolService = new RolService(this.rolRepositorio, usuarioRepositorio);

		try {
			// act
			this.rolService.asignarPrivilegios(privilegios, ID_ROL);
			fail();
		} catch (EntityNotFoundException e) {
			// assert
			assertEquals(ROL_NO_ENCONTRADO, e.getMessage());
		}

	}

}
