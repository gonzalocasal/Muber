package ar.com.grupo27.tests;

import org.junit.Assert;
import org.junit.Test;

import ar.com.grupo27.model.Calificacion;
import ar.com.grupo27.model.Conductor;
import ar.com.grupo27.model.Viaje;

public class ConductorTest {

	
	@Test
	public void condutorTest(){
		
		Conductor conductor = new Conductor();
		conductor.setNombre("Juan");
		conductor.setApellido("Lopez");
		conductor.setPass("123456");
		conductor.setUsuario("jlopez@gmail.com");
		conductor.setExpiracionLicencia("23-09-2029");
		
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
