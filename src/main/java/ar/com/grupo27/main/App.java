package ar.com.grupo27.main;

import ar.com.grupo27.model.Calificacion;
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

        Calificacion calificacion1= new Calificacion();
        calificacion1.setPuntaje(5);
        calificacion1.setComentario("muy bueno");
        calificacion1.setViaje(viaje);
        calificacion1.setPasajero(pasajero1);
        
        Calificacion calificacion2= new Calificacion();
        calificacion2.setPuntaje(4);
        calificacion2.setComentario("bueno");
        calificacion2.setViaje(viaje);
        calificacion2.setPasajero(pasajero2);
        
        Calificacion calificacion3= new Calificacion();
        calificacion3.setPuntaje(4);
        calificacion3.setComentario("bueno");
        calificacion3.setViaje(viaje);
        calificacion3.setPasajero(pasajero3);
        
        viajeService.calificar(calificacion1);
        viajeService.calificar(calificacion2);
        viajeService.calificar(calificacion3);
        
        Conductor resultado = conductorService.obternerConductor(1);
		System.out.print("El promedio del conductor "+ resultado.getNombre()+" "+resultado.getApellido() +" es: " + resultado.promedioPuntajes().doubleValue());
        
    }

}
