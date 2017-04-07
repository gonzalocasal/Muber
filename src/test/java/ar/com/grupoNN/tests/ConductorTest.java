package ar.com.grupoNN.tests;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.gruponn.model.Calificacion;
import ar.com.gruponn.model.Conductor;
import ar.com.gruponn.model.Viaje;

public class ConductorTest {

	
	@Test
	public void condutorTest(){
		
		Conductor conductor = new Conductor();
		conductor.setNombre("Juan");
		conductor.setApellido("Lopez");
		conductor.setContraseña("123456");
		conductor.setUsuario("jlopez@gmail.com");
		conductor.setFechaExipracionLicencia(new Date());
		
		Calificacion calificacion1 = new Calificacion();
		Calificacion calificacion2 = new Calificacion();
		Calificacion calificacion3 = new Calificacion();
		calificacion1.setPuntaje(4);
		calificacion2.setPuntaje(3);
		calificacion3.setPuntaje(5);
		Viaje viaje1 = new Viaje();
		viaje1.calificar(calificacion1);
		viaje1.calificar(calificacion2);
		viaje1.calificar(calificacion3);
		viaje1.setAbierto(false);
		
		conductor.registrarViaje(viaje1);
		
		Assert.assertEquals((Double)4.00, conductor.promedioPuntajes());
		
		Calificacion calificacion4 = new Calificacion();
		Calificacion calificacion5 = new Calificacion();
		Calificacion calificacion6 = new Calificacion();
		calificacion4.setPuntaje(5);
		calificacion5.setPuntaje(5);
		calificacion6.setPuntaje(5);
		Viaje viaje2 = new Viaje();
		viaje2.calificar(calificacion4);
		viaje2.calificar(calificacion5);
		viaje2.calificar(calificacion6);
		viaje2.setAbierto(false);
		
		conductor.registrarViaje(viaje2);
		
		Assert.assertEquals((Double)4.5, conductor.promedioPuntajes());
		
	}
}
