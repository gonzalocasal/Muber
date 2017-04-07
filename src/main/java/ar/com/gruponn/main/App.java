package ar.com.gruponn.main;

import org.hibernate.Session;

import ar.com.gruponn.model.Viaje;
import ar.com.gruponn.persistence.HibernateUtil;
import ar.com.gruponn.persistence.ViajeDAO;

public class App {
    
	public static void main( String[] args ){
        initDB();
        Viaje viaje = new Viaje();
        ViajeDAO  viajeDAO = new ViajeDAO();
        viajeDAO.persist(viaje);
    }

	private static void initDB() {
		@SuppressWarnings("unused")
		Session session = HibernateUtil.getSessionFactory().openSession();
	}
}
