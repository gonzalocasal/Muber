package bd2.Muber.repositories;

import java.util.List;

import org.springframework.stereotype.Component;

import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Viaje;

@Component
public class ViajeRepositoryImpl extends AbstractRepository implements IViajeRepository {

	public void guardar (Viaje viaje) {
		getCurrentSession().save(viaje);
	}
	
	public void actualizar(Viaje viaje) {
		getCurrentSession().update(viaje);
	}
	
	public Viaje obtenerViaje(int id){
		return (Viaje) getCurrentSession().get(Viaje.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Viaje> obtenerTodosLosViajesAbiertos() {
		return getCurrentSession().createQuery("from Viaje where abierto = true").list();
	}

	public void registrarCalificacion(Calificacion calificacion) {
		getCurrentSession().save(calificacion);
	}
	
}
