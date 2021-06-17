package com.co.comfaoriente.controles.aplicacion.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.comfaoriente.controles.aplicacion.entidades.IngresoEntidad;
import com.co.comfaoriente.controles.aplicacion.entidades.IngresoInfanteEntidad;
import com.co.comfaoriente.controles.aplicacion.entidades.IngresoMadreEntidad;
import com.co.comfaoriente.controles.aplicacion.mapper.IngresoInfanteMapper;
import com.co.comfaoriente.controles.aplicacion.mapper.IngresoMadreMapper;
import com.co.comfaoriente.controles.aplicacion.mapper.IngresoMapper;
import com.co.comfaoriente.controles.dominio.servicios.IngresoInfanteService;
import com.co.comfaoriente.controles.dominio.servicios.IngresoMadreService;
import com.co.comfaoriente.controles.dominio.servicios.IngresoService;

@Component
public class IngresoServiceApl {

	@Autowired
	private IngresoService ingresoService;
	@Autowired
	private IngresoInfanteService ingresoInfanteService;
	@Autowired
	private IngresoMadreService ingresoMadreService;

	private static final IngresoMapper mapper = IngresoMapper.getInstance();
	private static final IngresoMadreMapper madreMapper = IngresoMadreMapper.getInstance();
	private static final IngresoInfanteMapper infanteMapper = IngresoInfanteMapper.getInstance();

	public boolean registrarIngresoInfante(IngresoInfanteEntidad infante, IngresoEntidad ingreso) {
		if (infante == null || ingreso == null) {
			return false;
		}
		com.co.comfaoriente.controles.dominio.entidades.IngresoInfanteEntidad infanteDom = infanteMapper
				.toDominio(infante);
		com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad ingresoDom = mapper.toDominio(ingreso);
		infanteDom.setIdIngreso(ingresoService.registrarIngreso(ingresoDom));
		return ingresoInfanteService.registrarIngresoInfante(infanteDom);
	}

	public boolean actualizarIngresoInfante(IngresoInfanteEntidad infante, IngresoEntidad ingreso) {
		if (infante == null || ingreso == null) {
			return false;
		}
		com.co.comfaoriente.controles.dominio.entidades.IngresoInfanteEntidad infanteDom = infanteMapper
				.toDominio(infante);
		com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad ingresoDom = mapper.toDominio(ingreso);
		infanteDom.setIdIngreso(ingresoDom.getId());
		return ingresoService.actualizarIngreso(ingresoDom)
				&& ingresoInfanteService.actualizarIngresoInfante(infanteDom);
	}

	public boolean registrarIngresoMadre(IngresoMadreEntidad madre, IngresoEntidad ingreso) {
		if (madre == null || ingreso == null) {
			return false;
		}
		com.co.comfaoriente.controles.dominio.entidades.IngresoMadreEntidad madreDom = madreMapper.toDominio(madre);
		com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad ingresoDom = mapper.toDominio(ingreso);
		madreDom.setIdIngreso(ingresoService.registrarIngreso(ingresoDom));
		return ingresoMadreService.registrarIngresoMadre(madreDom);
	}

	public boolean actualizarIngresoMadre(IngresoMadreEntidad madre, IngresoEntidad ingreso) {
		if (madre == null || ingreso == null) {
			return false;
		}
		com.co.comfaoriente.controles.dominio.entidades.IngresoMadreEntidad madreDom = madreMapper.toDominio(madre);
		com.co.comfaoriente.controles.dominio.entidades.IngresoEntidad ingresoDom = mapper.toDominio(ingreso);
		madreDom.setIdIngreso(ingresoDom.getId());
		return ingresoService.actualizarIngreso(ingresoDom) && ingresoMadreService.actualizarIngresoMadre(madreDom);
	}

	public boolean eliminarIngreso(int id) {
		return this.ingresoService.eliminarIngreso(id);
	}

	public IngresoEntidad consultarIngreso(int id) {
		return mapper.toAplicacion(ingresoService.consultarIngreso(id));
	}

	public IngresoInfanteEntidad consultarIngresoInfante(int id) {
		return infanteMapper.toAplicacion(ingresoInfanteService.consultarIngresoInfante(id));
	}

	public IngresoMadreEntidad consultarIngresoMadre(int id) {
		return madreMapper.toAplicacion(ingresoMadreService.consultarIngresoMadre(id));
	}

}
