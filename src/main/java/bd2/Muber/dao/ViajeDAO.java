package bd2.Muber.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Viaje;

@Component
public class ViajeDAO extends AbstractDAO {

	public void persist (Viaje viaje) {
		currentSession.save(viaje);
	}
	
	public Viaje obtenerViaje(int id){
		return (Viaje) currentSession.get(Viaje.class, id);
	}

	public void actualizarViaje(Viaje viaje) {
		currentSession.update(viaje);
	}

	@SuppressWarnings("unchecked")
	public List<Viaje> obtenerTodosLosViajesAbiertos() {
		return currentSession.createCriteria(Viaje.class).add(Restrictions.eq("abierto", true)).list(); 
	}

	public void registrarCalificacion(Calificacion calificacion) {
		currentSession.save(calificacion);
		
	}
	
}
