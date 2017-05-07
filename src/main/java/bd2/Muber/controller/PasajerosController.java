package bd2.Muber.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
}
