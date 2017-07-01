package bd2.Muber.repositories;

import java.util.List;

import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Viaje;

public interface IViajeRepository {
	
	public void guardar (Viaje viaje);
	
	public void actualizar(Viaje viaje);
	
	public Viaje obtenerViaje(int id);

	public List<Viaje> obtenerTodosLosViajesAbiertos();
	
	public void registrarCalificacion(Calificacion calificacion) ;

}
