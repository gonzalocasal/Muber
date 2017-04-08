package ar.com.grupo27.persistence;

import org.hibernate.SessionFactory;

public class AbstractDAO {
	
	protected SessionFactory getSessionFactory() {
		return HibernateUtil.getSessionFactory();
	}

	
}