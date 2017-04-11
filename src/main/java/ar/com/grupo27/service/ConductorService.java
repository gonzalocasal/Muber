package ar.com.grupo27.service;

import ar.com.grupo27.model.Conductor;
import ar.com.grupo27.persistence.ConductorDAO;

public class ConductorService {
	
	private ConductorDAO dao;

	public ConductorService(){
		this.dao=new ConductorDAO();
	}

	public void registrarConductor(Conductor conductor){
		dao.openCurrentSessionwithTransaction();
		dao.persist(conductor);
		dao.closeCurrentSessionwithTransaction();
	}
	
	public void actualizarConductor(Conductor conductor){
		dao.openCurrentSessionwithTransaction();
		dao.actualizarConductor(conductor);
		dao.closeCurrentSessionwithTransaction();
	}
	
	
	public Conductor obternerConductor (int id){
		dao.openCurrentSessionwithTransaction();
		Conductor conductor = dao.findOne(id);
		dao.closeCurrentSessionwithTransaction();
		return conductor;
	}
	
	
}


