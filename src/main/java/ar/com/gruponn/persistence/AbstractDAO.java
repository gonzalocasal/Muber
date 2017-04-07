package ar.com.gruponn.persistence;

import org.hibernate.SessionFactory;

public class AbstractDAO {
	
	protected SessionFactory getSessionFactory() {
		return HibernateUtil.getSessionFactory();
	}

	
}