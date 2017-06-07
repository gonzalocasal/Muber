package bd2.Muber.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bd2.Muber.dao.ConductorDAO;
import bd2.Muber.dto.ConductorDTO;
import bd2.Muber.dto.TopConductorDTO;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.Viaje;


@Component
public class ConductorService {
	
	@Autowired
	private ConductorDAO dao;

	@Autowired
	private ViajeService viajeService;
	
	
	public ConductorService(){
		this.dao=new ConductorDAO();
		this.viajeService = new ViajeService();
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

	public List<TopConductorDTO> obternerConductoresTopDTO() {
		dao.openCurrentSessionwithTransaction();
		List<TopConductorDTO> conductoresTop = dao.obtenerConductoresTop();
		dao.closeCurrentSessionwithTransaction();
		return conductoresTop;
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
	

	public Conductor obternerConductor (String usuario){
		dao.openCurrentSessionwithTransaction();
		Conductor conductor = dao.obtenerConductor(usuario);
		dao.closeCurrentSessionwithTransaction();
		return conductor;
	}
	
	public Boolean finalizarViaje(Viaje viaje) {
		
		if(viaje.getAbierto()){
			viaje.getConductor().finalizarViaje(viaje);
			viajeService.actualizarViaje(viaje);
			return true;
		}
		return false;
	}
	
	public List<Conductor> obtenerTodosLosCondutores(){
		dao.openCurrentSessionwithTransaction();
		List<Conductor> todosLosConductores = dao.obtenerTodosLosCondutores();
		dao.closeCurrentSessionwithTransaction();
		return todosLosConductores;
	}

}


