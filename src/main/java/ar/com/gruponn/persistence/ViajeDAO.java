package ar.com.gruponn.persistence;

import org.hibernate.Session;
import ar.com.gruponn.model.Viaje;

public class ViajeDAO extends AbstractDAO {

	public void persist (Viaje viaje) {
		Session dbSession = getSessionFactory().openSession();
		dbSession.beginTransaction();
		dbSession.save(viaje);
		dbSession.getTransaction().commit();
		dbSession.close();
	}
	
	
}
