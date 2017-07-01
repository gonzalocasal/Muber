package bd2.Muber.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import bd2.Muber.model.Conductor;
import bd2.Muber.services.ConductorService;

@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc
public class ConductorController {
	
	@Autowired
	@Qualifier("ConductorServiceTransactional")
	private ConductorService service;
	
	@RequestMapping(value = "/conductores", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public Map<String, Object> conductores() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("conductores", service.obtenerTodosLosCondutoresDTO());
		return aMap;
	}
	
	@RequestMapping(value = "/conductores/detalle/{id}", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public Map<String, Object> detalleConductor( @PathVariable("id") int id)  {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("conductor", service.obternerConductorDTO(id));
		return aMap;
	}
	
	@RequestMapping(value = "/conductores/top10", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public Map<String, Object> obetenerConductoresTop()  {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("conductor", service.obternerConductoresTopDTO());
		return aMap;
	}
	
	@RequestMapping(value = "/conductores/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public Map<String, Object> nuevoConductor(	@RequestBody Conductor paramConductor) {
		service.registrarConductor(paramConductor);
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("pasajero creado", service.obternerConductor(paramConductor.getUsuario()));
		return aMap;
	}
	
}
