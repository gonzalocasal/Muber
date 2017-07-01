package bd2.Muber.services;

import java.util.ArrayList;
import java.util.List;

import bd2.Muber.dtos.PasajeroDTO;
import bd2.Muber.model.Pasajero;
import bd2.Muber.repositories.PasajeroRepositoryImpl;

public class PasajeroService {

	private PasajeroRepositoryImpl repo;
	
	public PasajeroService(){
		this.repo= new PasajeroRepositoryImpl();
	}
	
	public void registrarPasajero(Pasajero pasajero){
		repo.guardar(pasajero);
	}
	
	public void actualizarPasajero(Pasajero pasajero){
		repo.actualizar(pasajero);
	}
	

	public Pasajero obtenerPasajero(int id){
		return repo.obtenerPasajero(id);
	}
	
	public Pasajero obtenerPasajero(String usuario){
		return repo.obtenerPasajero(usuario);
	}
	
	public List<PasajeroDTO> obtenerTodosLosPasajerosDTO() {
		List<Pasajero> pasajeros = obtenerTodosLosPasajeros();
		List<PasajeroDTO>dtos = new ArrayList<>();
		for (Pasajero pasajero : pasajeros)
			dtos.add(new PasajeroDTO(pasajero));
		return dtos;
	}
	
	public Pasajero cargarCredito(Pasajero pasajero, int monto) {
		pasajero.cargarCredito(monto);
		actualizarPasajero(pasajero);
		return pasajero;
	}
	
	public List<Pasajero> obtenerTodosLosPasajeros(){
		return  repo.obtenerTodosLosPasajeros();
	}
	
	public PasajeroRepositoryImpl getRepo() {
		return repo;
	}
	
	public void setRepo(PasajeroRepositoryImpl repo) {
		this.repo = repo;
	}
	
}
