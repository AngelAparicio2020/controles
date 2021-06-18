package com.co.comfaoriente.controles.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.co.comfaoriente.controles.dominio.repositorios.CompromisoRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.ControlRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.ControlVacunacionRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.IngresoRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.RemicionRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.RolRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.SeguimientoSaludRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.SesionRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.UsuarioRepositorio;
import com.co.comfaoriente.controles.dominio.servicios.CompromisoService;
import com.co.comfaoriente.controles.dominio.servicios.ControlService;
import com.co.comfaoriente.controles.dominio.servicios.ControlVacunacionService;
import com.co.comfaoriente.controles.dominio.servicios.IngresoInfanteService;
import com.co.comfaoriente.controles.dominio.servicios.IngresoMadreService;
import com.co.comfaoriente.controles.dominio.servicios.IngresoService;
import com.co.comfaoriente.controles.dominio.servicios.RemicionService;
import com.co.comfaoriente.controles.dominio.servicios.RolService;
import com.co.comfaoriente.controles.dominio.servicios.SeguimientoSaludService;
import com.co.comfaoriente.controles.dominio.servicios.SesionService;
import com.co.comfaoriente.controles.dominio.servicios.UsuarioService;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class BeanService {

	@Bean
	public SesionService servicioSesion(SesionRepositorio sesionRepositorio) {
		return new SesionService(sesionRepositorio);
	}

	@Bean
	public RolService servicioRol(RolRepositorio rolRepositorio, UsuarioRepositorio usuarioRepositorio) {
		return new RolService(rolRepositorio, usuarioRepositorio);
	}

	@Bean
	public UsuarioService servicioUsuario(UsuarioRepositorio usuarioRepositorio) {
		return new UsuarioService(usuarioRepositorio);
	}

	@Bean
	public ControlService controlService(ControlRepositorio controlRepositorio, UsuarioRepositorio usuarioRepositorio) {
		return new ControlService(controlRepositorio, usuarioRepositorio);
	}

	@Bean
	public ControlVacunacionService controlVacunacionService(ControlVacunacionRepositorio controlVacunacionRepositorio,
			UsuarioRepositorio usuarioRepositorio) {
		return new ControlVacunacionService(controlVacunacionRepositorio, usuarioRepositorio);
	}

	@Bean
	public CompromisoService compromisoService(CompromisoRepositorio compromisoRepositorio) {
		return new CompromisoService(compromisoRepositorio);
	}

	@Bean
	public IngresoService ingresoService(IngresoRepositorio ingresoRepositorio,
			SeguimientoSaludRepositorio seguimientoRepositorio) {
		return new IngresoService(ingresoRepositorio, seguimientoRepositorio);
	}

	@Bean
	public IngresoMadreService ingresoMadreService(IngresoRepositorio ingresoRepositorio) {
		return new IngresoMadreService(ingresoRepositorio);
	}

	@Bean
	public IngresoInfanteService ingresoInfanteService(IngresoRepositorio ingresoRepositorio) {
		return new IngresoInfanteService(ingresoRepositorio);
	}

	@Bean
	public RemicionService remicionService(RemicionRepositorio remicionRepositorio,
			SeguimientoSaludRepositorio seguimientoRepositorio) {
		return new RemicionService(remicionRepositorio, seguimientoRepositorio);
	}

	@Bean
	public SeguimientoSaludService seguimientoService(SeguimientoSaludRepositorio seguimientoRepositorio,
			UsuarioRepositorio usuarioRepositorio) {
		return new SeguimientoSaludService(seguimientoRepositorio, usuarioRepositorio);
	}

	@Bean
	public Docket buildDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("com.co.comfaoriente.controles.infraestructura.controladores"))
				.paths(PathSelectors.any()).build();
	}

}
