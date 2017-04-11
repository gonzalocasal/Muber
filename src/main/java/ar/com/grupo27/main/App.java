package ar.com.grupo27.main;

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

		Viaje viaje = new Viaje();
        viaje.setOrigen("La Plata");
        viaje.setDestino("Tres Arroyos");
        viaje.setCosto(900.00);
        viaje.setCapacidad(3);
		
        viajeService.registrarViaje(viaje);
		
		Conductor conductor = new Conductor();
		conductor.setUsuario("rp@gmail.com");
		conductor.setPass("123");
        conductor.setApellido("PEREZ");
        conductor.setNombre("ROBERTO");
        conductor.setExpiracionLicencia("25-05-2019");
        conductor.registrarViaje(viaje);
        
        conductorService.registrarConductor(conductor);
      
        Pasajero pasajero1 = new Pasajero();
        pasajero1.setUsuario("gg@gmail.com");
        pasajero1.setPass("12345");
        pasajero1.setApellido("GARCIA");
        pasajero1.setNombre("GERMAN");
        pasajero1.setSaldo(1500.00);
        pasajeroService.registrarPasajero(pasajero1);
        
        Pasajero pasajero2 = new Pasajero();
        pasajero2.setUsuario("al@gmail.com");
        pasajero2.setPass("12345");
        pasajero2.setApellido("LOPEZ");
        pasajero2.setNombre("ALICIA");
        pasajero2.setSaldo(1500.00);
        pasajeroService.registrarPasajero(pasajero2);
        
        Pasajero pasajero3 = new Pasajero();
        pasajero3.setUsuario("md@gmail.com");
        pasajero3.setPass("12345");
        pasajero3.setApellido("DOMINGUEZ");
        pasajero3.setNombre("MARGARITA");
        pasajero3.setSaldo(1500.00);
        pasajeroService.registrarPasajero(pasajero3);
        
        viajeService.registrarPasajero(viaje,pasajero1);
        viajeService.registrarPasajero(viaje,pasajero2);
        viajeService.registrarPasajero(viaje,pasajero3);
        
        viajeService.finalizarViaje(viaje);

    }

}
