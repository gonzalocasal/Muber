package bd2.Muber.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import bd2.Muber.dto.PasajeroDTO;
import bd2.Muber.model.Pasajero;
import bd2.Muber.service.PasajeroService;

@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc
public class PasajerosController {

	@Autowired
	private PasajeroService service;
	
	@RequestMapping(value = "/pasajeros", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public Map<String, Object> pasajeros() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("pasajeros", service.obtenerTodosLosPasajerosDTO());
		return aMap;
	}
	
	@RequestMapping(value = "/pasajeros/cargarCredito", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public Map<String, Object> cargarCredito(	@RequestParam("pasajeroId") int pasajeroId,
												@RequestParam("monto") int monto) {
		
		Pasajero pasajero = service.obtenerPasajero(pasajeroId);
		pasajero = service.cargarCredito(pasajero, monto);
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("credito cargado", new PasajeroDTO(pasajero));
		return aMap;
	}

	
}
