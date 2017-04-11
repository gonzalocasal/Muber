package ar.com.grupo27.persistence;

import ar.com.grupo27.model.Pasajero;

public class PasajeroDAO extends AbstractDAO {

	public void persist (Pasajero pasajero) {
		currentSession.save(pasajero);
	}
	
	public Pasajero obtenerPasajero(int id){
		return (Pasajero) currentSession.get(Pasajero.class, id);
	}

	public void actualizarPasajero(Pasajero pasajero) {
		currentSession.update(pasajero);
	}
	
}
