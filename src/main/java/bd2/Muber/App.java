package bd2.Muber;

import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.Pasajero;
import bd2.Muber.model.Viaje;
import bd2.Muber.service.ConductorService;
import bd2.Muber.service.PasajeroService;
import bd2.Muber.service.ViajeService;

public class App {
	
	
	static ConductorService conductorService = new ConductorService();
	static PasajeroService pasajeroService = new PasajeroService();
	static ViajeService viajeService = new ViajeService();
	
    public static void main( String[] args ){
        
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
        
        
        Conductor resultado = conductorService.obternerConductor(1);
		System.out.print("El promedio del conductor "+ resultado.getNombre()+" "+resultado.getApellido() +" es: " + resultado.promedioPuntajes().doubleValue());
        
    }
}
