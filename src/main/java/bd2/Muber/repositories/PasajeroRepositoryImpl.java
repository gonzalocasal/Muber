package bd2.Muber.repositories;

import java.util.List;

import bd2.Muber.model.Pasajero;

public class PasajeroRepositoryImpl extends AbstractRepository implements IPasajeroRepository {

	public void guardar (Pasajero pasajero) {
		getCurrentSession().save(pasajero);
	}
	
	public Pasajero obtenerPasajero(int id){
		return (Pasajero) getCurrentSession().get(Pasajero.class, id);
	}

	public Pasajero obtenerPasajero(String usuario){
		String hql = "from Pasajero p where p.usuario = :usuario"; 
		return (Pasajero) getCurrentSession().createQuery(hql).setParameter("usuario", usuario).uniqueResult();
	}
	
	public void actualizar(Pasajero pasajero) {
		getCurrentSession().update(pasajero);
	}

	@SuppressWarnings("unchecked")
	public List<Pasajero> obtenerTodosLosPasajeros() {
		return getCurrentSession().createQuery("from Pasajero ").list();
	}

	
}
