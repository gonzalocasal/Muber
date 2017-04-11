package ar.com.grupo27.service;

import java.util.List;

import ar.com.grupo27.model.Pasajero;
import ar.com.grupo27.model.Viaje;
import ar.com.grupo27.persistence.PasajeroDAO;

public class PasajeroService {

	private PasajeroDAO dao;
	
	public PasajeroService(){
		this.dao= new PasajeroDAO();
	}
	
	public void registrarPasajero(Pasajero pasajero){
		dao.openCurrentSessionwithTransaction();
		dao.persist(pasajero);
		dao.closeCurrentSessionwithTransaction();
	}
	
	public void actualizarPasajero(Pasajero pasajero){
		dao.openCurrentSessionwithTransaction();
		dao.actualizarPasajero(pasajero);
		dao.closeCurrentSessionwithTransaction();
	}
	
	public Pasajero obtenerPasajero(int id){
		dao.openCurrentSessionwithTransaction();
		Pasajero pasajero = dao.obtenerPasajero(id);
		dao.closeCurrentSessionwithTransaction();
		return pasajero;
	}
	
	public List<Pasajero> obtenerTodosLosPasajeros(){
		dao.openCurrentSessionwithTransaction();
		List<Pasajero> todosLosPasajeros = dao.obtenerTodosLosPasajeros();
		dao.closeCurrentSessionwithTransaction();
		return todosLosPasajeros;
	}
	
	public void cobrarViaje (Viaje viaje){
		for (Pasajero pasajero: viaje.getPasajeros()){
			pasajero.cobrar(viaje);
			actualizarPasajero(pasajero);
		}
	}

	
}
