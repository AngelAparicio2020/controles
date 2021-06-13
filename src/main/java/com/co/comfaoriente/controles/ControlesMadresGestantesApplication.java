package com.co.comfaoriente.controles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.co.comfaoriente.controles.infraestructura.persistencia.seguridad.JWTAuthorizationFilter;

@SpringBootApplication
public class ControlesMadresGestantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlesMadresGestantesApplication.class, args);
	}
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/sesion/{documento}/{clave}/{rol}").permitAll()
				.antMatchers(HttpMethod.GET, "/api/sesion/LISTAR_ROLES").permitAll()
				.anyRequest().authenticated();
		}
	}

}
