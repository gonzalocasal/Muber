package ar.com.grupo27.service;

import ar.com.grupo27.model.Pasajero;
import ar.com.grupo27.persistence.PasajeroDAO;

public class PasajeroService {

	private PasajeroDAO dao;
	
	public PasajeroService(){
		this.setDao(new PasajeroDAO());
	}
	
	public void registrarPasajero(Pasajero pasajero){
		dao.openCurrentSessionwithTransaction();
		dao.persist(pasajero);
		dao.closeCurrentSessionwithTransaction();
	}
	
	public Pasajero obtenerPasajero(int id){
		dao.openCurrentSessionwithTransaction();
		Pasajero pasajero = dao.findOne(id);
		dao.closeCurrentSessionwithTransaction();
		return pasajero;
	}
	public PasajeroDAO getDao() {
		return dao;
	}
	public void setDao(PasajeroDAO dao) {
		this.dao = dao;
	}
	
}
