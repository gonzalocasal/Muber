package bd2.Muber.repositories;

import java.util.List;

import bd2.Muber.model.Pasajero;

public interface IPasajeroRepository {

	public void guardar (Pasajero pasajero);
	
	public void actualizar(Pasajero pasajero);
	
	public Pasajero obtenerPasajero(int id);

	public Pasajero obtenerPasajero(String usuario);

	public List<Pasajero> obtenerTodosLosPasajeros();
	
}
