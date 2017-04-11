package ar.com.grupo27.tests;

import org.junit.Test;

import ar.com.grupo27.model.Conductor;
import ar.com.grupo27.model.Pasajero;
import ar.com.grupo27.model.Viaje;
import ar.com.grupo27.service.ConductorService;
import ar.com.grupo27.service.PasajeroService;
import ar.com.grupo27.service.ViajeService;
import junit.framework.Assert;

public class DaoTest {
	
	@Test
	public void PasajeroDaoTest(){
		PasajeroService pasajeroService = new PasajeroService();
	    
	    Pasajero pasajero1 = new Pasajero();
	    pasajeroService.registrarPasajero(pasajero1);
	    Pasajero pasajero2 = new Pasajero();
	    pasajeroService.registrarPasajero(pasajero2);
	    Pasajero pasajero3 = new Pasajero();
	    pasajero3.setNombre("Juan");
	    pasajeroService.registrarPasajero(pasajero3);
	    
	    Assert.assertEquals(3, pasajeroService.obtenerTodosLosPasajeros().size());
	    Assert.assertEquals("Juan", pasajeroService.obtenerPasajero(3).getNombre());	
	}
	
	@Test
	public void ViajeDaoTest(){
		PasajeroService pasajeroService = new PasajeroService();
		ViajeService viajeService = new ViajeService();

		Viaje viaje = new Viaje();
		viaje.setCapacidad(2);
		viaje.setCosto(50.0);
	    viajeService.registrarViaje(viaje);

	    Pasajero pasajero1 = new Pasajero();
	    pasajeroService.registrarPasajero(pasajero1);
	    Pasajero pasajero2 = new Pasajero();
	    pasajeroService.registrarPasajero(pasajero2);
	    Pasajero pasajero3 = new Pasajero();
	    pasajeroService.registrarPasajero(pasajero3);
	    
	    viajeService.registrarPasajero(viaje,pasajero1);
	    viajeService.registrarPasajero(viaje,pasajero2);
	    viajeService.registrarPasajero(viaje,pasajero3);
	    
	    Assert.assertEquals(2, viajeService.obtenerViaje(1).getPasajeros().size());
	    
	    viajeService.finalizarViaje(viaje);
	    Assert.assertFalse(viajeService.obtenerViaje(1).getAbierto());
	    Assert.assertEquals(0,viajeService.obtenerTodosLosViajesAbiertos().size()); 
	    
	    viajeService.registrarViaje(new Viaje());
	    viajeService.obtenerTodosLosViajesAbiertos();
	    Assert.assertEquals(1,viajeService.obtenerTodosLosViajesAbiertos().size());
	}

	@Test
	public void CondutorDaoTest(){
		ConductorService conductorService = new ConductorService();
	    Conductor conductor = new Conductor();
	    conductor.setNombre("Pedro");
	    conductorService.registrarConductor(conductor);
	    Assert.assertEquals("Pedro", conductorService.obternerConductor(1).getNombre());
	}
	
}
