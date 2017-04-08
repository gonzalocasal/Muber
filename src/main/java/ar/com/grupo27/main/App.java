package ar.com.grupo27.main;

import org.hibernate.Session;

import ar.com.grupo27.model.Viaje;
import ar.com.grupo27.persistence.HibernateUtil;
import ar.com.grupo27.persistence.ViajeDAO;

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
