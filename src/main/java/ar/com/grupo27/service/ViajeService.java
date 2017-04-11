package ar.com.grupo27.service;

import ar.com.grupo27.model.Viaje;
import ar.com.grupo27.persistence.ViajeDAO;

public class ViajeService {

	private ViajeDAO dao;
	
	public ViajeService(){
		this.dao = new ViajeDAO();
	}
	
	public void registrarViaje(Viaje viaje){
		dao.openCurrentSessionwithTransaction();
		dao.persist(viaje);
		dao.closeCurrentSessionwithTransaction();
	}
	
	
}
