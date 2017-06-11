package bd2.Muber.services;

import java.util.ArrayList;
import java.util.List;

import bd2.Muber.dtos.ConductorDTO;
import bd2.Muber.dtos.TopConductorDTO;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.Viaje;
import bd2.Muber.repositories.ConductorRepositoryImpl;

public class ConductorService {
	
	private ConductorRepositoryImpl repo;

	private ViajeService viajeService;
	
	public ConductorService(){
		this.repo=new ConductorRepositoryImpl();
		this.setViajeService(new ViajeService());
	}
	
	public void registrarConductor(Conductor conductor){
		repo.guardar(conductor);
	}
	
	public void actualizarConductor(Conductor conductor){
		repo.actualizar(conductor);
	}
	
	public Conductor obternerConductor (int id){
		return repo.obtenerConductor(id);
	}
	
	public Conductor obternerConductor (String usuario){
		return repo.obtenerConductor(usuario);
	}
	
	public ConductorDTO obternerConductorDTO (int id){
		return new ConductorDTO(obternerConductor(id));
	}
	
	public List<Conductor> obtenerTodosLosCondutores(){
		return repo.obtenerTodosLosCondutores();
	}
	
	public Object obtenerTodosLosCondutoresDTO() {
		List<Conductor> conductores = obtenerTodosLosCondutores();
		List<ConductorDTO> dtos = new ArrayList<>();
		for (Conductor conductor : conductores)
			dtos.add(new ConductorDTO(conductor));
		return dtos;
	}

	public List<TopConductorDTO> obternerConductoresTopDTO() {
		return repo.obtenerConductoresTop();
	}
	
	public Boolean finalizarViaje(int id) {
		Viaje viaje = getViajeService().obtenerViaje(id);
		if(viaje.getAbierto()){
			viaje.getConductor().finalizarViaje(viaje);
			getViajeService().actualizarViaje(viaje);
			return true;
		}
		return false;
	}
	
	public ConductorRepositoryImpl getRepo() {
		return repo;
	}
	
	public void setRepo(ConductorRepositoryImpl repo) {
		this.repo = repo;
	}

	public ViajeService getViajeService() {
		return viajeService;
	}

	public void setViajeService(ViajeService viajeService) {
		this.viajeService = viajeService;
	}

}
