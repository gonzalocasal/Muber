package bd2.Muber.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import bd2.Muber.model.Pasajero;

@Component
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

	@SuppressWarnings("unchecked")
	public List<Pasajero> obtenerTodosLosPasajeros() {
		return currentSession.createCriteria(Pasajero.class).list();
	}
	
}
