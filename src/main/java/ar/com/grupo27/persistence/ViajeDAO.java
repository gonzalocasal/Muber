package ar.com.grupo27.persistence;

import org.hibernate.Session;

import ar.com.grupo27.model.Viaje;

public class ViajeDAO extends AbstractDAO {

	public void persist (Viaje viaje) {
		Session dbSession = getSessionFactory().openSession();
		dbSession.beginTransaction();
		dbSession.save(viaje);
		dbSession.getTransaction().commit();
		dbSession.close();
	}
	
	
}
