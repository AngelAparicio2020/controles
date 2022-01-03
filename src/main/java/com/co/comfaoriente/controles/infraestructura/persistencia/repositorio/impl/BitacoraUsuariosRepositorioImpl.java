package com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.dominio.entidades.BitacoraUsuarioEntidad;
import com.co.comfaoriente.controles.dominio.repositorios.BitacoraRepositorio;
import com.co.comfaoriente.controles.infraestructura.persistencia.mapper.BitacoraUsuarioMapper;
import com.co.comfaoriente.controles.infraestructura.persistencia.repositorio.jpa.BitacoraUsuariosRepositorioJpa;
@Component
public class BitacoraUsuariosRepositorioImpl implements BitacoraRepositorio {

	@Autowired
	private BitacoraUsuariosRepositorioJpa repositorioJpa;
	private static final BitacoraUsuarioMapper mapper = BitacoraUsuarioMapper.getInstance();

	@Override
	public boolean registrarBitacora(BitacoraUsuarioEntidad bitacora) {
		com.co.comfaoriente.controles.infraestructura.persistencia.entidades.BitacoraUsuarioEntidad entity = mapper
				.toEntity(bitacora);
		return repositorioJpa.save(entity) != null;
	}

	@Override
	public List<BitacoraUsuarioEntidad> listarHistorialBitacora(int documento) {
		List<com.co.comfaoriente.controles.infraestructura.persistencia.entidades.BitacoraUsuarioEntidad> entity = repositorioJpa
				.consultarHistorialUsuario(documento);
		return entity.stream().map(mapper::toDomain).collect(Collectors.toList());
	}

}
