package ar.com.grupo27.main;

import java.util.Date;

import ar.com.grupo27.model.Conductor;
import ar.com.grupo27.model.Pasajero;
import ar.com.grupo27.model.Viaje;
import ar.com.grupo27.service.ConductorService;
import ar.com.grupo27.service.PasajeroService;
import ar.com.grupo27.service.ViajeService;

public class App {
    
	public static void main( String[] args ){
        
		ConductorService conductorService = new ConductorService();
		PasajeroService pasajeroService = new PasajeroService();
		ViajeService viajeService = new ViajeService();

		Conductor conductor = new Conductor();
        conductor.setApellido("PEREZ");
        conductor.setNombre("JUAN");
        conductor.setFechaExipracionLicencia(new Date());
        conductor.setUsuario("jp@mail.com");
        
        conductorService.registrarConductor(conductor);
        
        Pasajero pasajero = new Pasajero();
        pasajero.setSaldo(100.00);
        pasajero.setApellido("GARCIA");
        pasajero.setNombre("DIEGO");
        
        pasajeroService.registrarPasajero(pasajero);
        
        Viaje viaje = new Viaje();
        viaje.registrarPasajero(pasajero);
        viaje.setConductor(conductor);
        viaje.setOrigen("Tres Arroyos");
        viaje.setDestino("La Plata");
        
        viajeService.registrarViaje(viaje);
                
    }

}
