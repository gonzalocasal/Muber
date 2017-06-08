package bd2.Muber.services;

import java.util.ArrayList;
import java.util.List;

import bd2.Muber.dtos.ViajeDTO;
import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Pasajero;
import bd2.Muber.model.Viaje;
import bd2.Muber.repositories.ViajeRepositoryImpl;

public class ViajeService {
	
	private ViajeRepositoryImpl repo;
	
	public ViajeService(){
		this.repo = new ViajeRepositoryImpl();
	}
	
	public List<ViajeDTO> obtenerTodosLosViajesAbiertosDTO() {
		List<Viaje> viajesAbiertos = obtenerTodosLosViajesAbiertos();
		List<ViajeDTO> dtos = new ArrayList<>();
		for (Viaje viaje : viajesAbiertos)
			dtos.add(new ViajeDTO(viaje));
		return dtos;
	}
	
	public void registrarViaje(Viaje viaje){
		repo.guardar(viaje);
	}

	public void actualizarViaje(Viaje viaje){
		repo.actualizar(viaje);
	}
	
	public List<Viaje> obtenerTodosLosViajesAbiertos(){
		return repo.obtenerTodosLosViajesAbiertos();
	}
	
	public Viaje obtenerViaje (int id){
		return repo.obtenerViaje(id);
	}
	
	public void registrarPasajero(Viaje viajeParam, Pasajero pasajero) {
		viajeParam.registrarPasajero(pasajero);
		actualizarViaje(viajeParam);
	}

	public void calificar(Calificacion calificacion) {
		if (!calificacion.getViaje().getCalificaciones().contains(calificacion)){
			repo.registrarCalificacion(calificacion);
		}
	}
	
	public ViajeRepositoryImpl getRepo() {
		return repo;
	}
	
	public void setRepo(ViajeRepositoryImpl repo) {
		this.repo = repo;
	}
}
