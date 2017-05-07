package bd2.Muber.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bd2.Muber.dao.ConductorDAO;
import bd2.Muber.dto.ConductorDTO;
import bd2.Muber.model.Conductor;

@Component
public class ConductorService {
	
	@Autowired
	private ConductorDAO dao;

	public ConductorService(){
		this.dao=new ConductorDAO();
	}
	
	public ConductorDTO obternerConductorDTO (int id){
		return new ConductorDTO(obternerConductor(id));
	}
	
	public Object obtenerTodosLosCondutoresDTO() {
		List<Conductor> conductores = obtenerTodosLosCondutores();
		List<ConductorDTO> dtos = new ArrayList<>();
		for (Conductor conductor : conductores)
			dtos.add(new ConductorDTO(conductor));
		return dtos;
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
		Conductor conductor = dao.obtenerConductor(id);
		dao.closeCurrentSessionwithTransaction();
		return conductor;
	}
	
	
	public List<Conductor> obtenerTodosLosCondutores(){
		dao.openCurrentSessionwithTransaction();
		List<Conductor> todosLosConductores = dao.obtenerTodosLosCondutores();
		dao.closeCurrentSessionwithTransaction();
		return todosLosConductores;
	}
	
}


