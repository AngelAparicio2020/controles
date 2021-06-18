package com.co.comfaoriente.controles.infraestructura.persistencia.seguridad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Util {
	
	private Util() {
	}

	public static String getJWTToken(int documento, int rol, List<String> privilegios) {
		String secretKey = "conftesis";
		List<GrantedAuthority> grantedAuthorities = createAuthorityList(privilegios);

		String token = Jwts.builder().setId("controlMaterno").setSubject(documento + "-" + rol)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1900000000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}


	public static List<GrantedAuthority> createAuthorityList(List<String> privilegios) {
		if (privilegios == null) {
			privilegios = new ArrayList<>();
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(privilegios.size());
		for (String authority : privilegios) {
			grantedAuthorities.add(new SimpleGrantedAuthority(authority));
		}
		return grantedAuthorities;
	}

}
