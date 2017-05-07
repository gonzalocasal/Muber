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

import bd2.Muber.dto.ViajeDTO;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.Viaje;
import bd2.Muber.service.ConductorService;
import bd2.Muber.service.ViajeService;

@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc
public class ViajeController {

	@Autowired
	private ConductorService conductorService;
	
	@Autowired
	private ViajeService service;
	
	@RequestMapping(value = "/viajes/abiertos", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public Map<String, Object> viajesAbiertos() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("Viajes Abiertos", service.obtenerTodosLosViajesAbiertosDTO());
		return aMap;
	}
	
	@RequestMapping(value = "/viajes/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public Map<String, Object> nuevoViaje( @RequestParam("origen") String origen,
											 @RequestParam("destino") String destino,
											 @RequestParam("conductorId") int conductorId,
											 @RequestParam("costoTotal") Double costoTotal, 
											 @RequestParam("cantidadPasajeros") int cantidadPasajeros) {
		Conductor conductor = conductorService.obternerConductor(conductorId);
		Viaje nuevoViaje = new Viaje (origen,destino,conductor,costoTotal,cantidadPasajeros);
		service.registrarViaje(nuevoViaje);
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		aMap.put("Viajes Creado", new ViajeDTO(nuevoViaje));
		return aMap;
	}
}


