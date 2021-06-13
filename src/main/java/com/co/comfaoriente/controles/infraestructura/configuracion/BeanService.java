package com.co.comfaoriente.controles.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.co.comfaoriente.controles.dominio.repositorios.RolRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.SesionRepositorio;
import com.co.comfaoriente.controles.dominio.repositorios.UsuarioRepositorio;
import com.co.comfaoriente.controles.dominio.servicios.RolService;
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
	public RolService servicioRol(RolRepositorio rolRepositorio) {
		return new RolService(rolRepositorio);
	}

	@Bean
	public UsuarioService servicioUsuario(UsuarioRepositorio usuarioRepositorio) {
		return new UsuarioService(usuarioRepositorio);
	}

	@Bean
	public Docket buildDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("com.co.comfaoriente.controles.infraestructura.controladores"))
				.paths(PathSelectors.any()).build();
	}

}
