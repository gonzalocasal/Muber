package ar.com.grupo27.persistence;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import ar.com.grupo27.model.Viaje;

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
	
}
