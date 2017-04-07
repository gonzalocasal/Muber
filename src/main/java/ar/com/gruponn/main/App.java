package ar.com.gruponn.main;

import org.hibernate.Session;
import ar.com.gruponn.persistence.HibernateUtil;

public class App {
    
	public static void main( String[] args ){
        initDB();
    }

	private static void initDB() {
		Session session = HibernateUtil.getSessionFactory().openSession();
	}
}
