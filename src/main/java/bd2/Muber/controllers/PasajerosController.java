package bd2.Muber.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import bd2.Muber.dtos.CargaCreditoDTO;
import bd2.Muber.dtos.PasajeroDTO;
import bd2.Muber.model.Pasajero;
import bd2.Muber.services.PasajeroService;

@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc
public class PasajerosController {

	@Autowired
	@Qualifier("PasajeroServiceTransactional")
	private PasajeroService service;
	
	@RequestMapping(value = "/pasajeros", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public Map<String, Object> pasajeros() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("pasajeros", service.obtenerTodosLosPasajerosDTO());
		return aMap;
	}
	
	@RequestMapping(value = "/pasajeros/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public Map<String, Object> nuevoPasajero(	@RequestBody Pasajero paramPasajero) {
		service.registrarPasajero(paramPasajero);
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("credito cargado", new PasajeroDTO(service.obtenerPasajero(paramPasajero.getUsuario())));
		return aMap;
	}
	
	@RequestMapping(value = "/pasajeros/cargarCredito", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public Map<String, Object> cargarCredito(	@RequestBody CargaCreditoDTO carga) {
		Pasajero pasajero = service.obtenerPasajero(carga.getIdUsuario());
		pasajero = service.cargarCredito(pasajero, carga.getCredito());
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("credito cargado", new PasajeroDTO(pasajero));
		return aMap;
	}

}
