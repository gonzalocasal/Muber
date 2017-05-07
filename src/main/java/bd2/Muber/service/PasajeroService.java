package bd2.Muber.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bd2.Muber.dao.PasajeroDAO;
import bd2.Muber.dto.PasajeroDTO;
import bd2.Muber.model.Pasajero;
import bd2.Muber.model.Viaje;

@Component
public class PasajeroService {

	
	@Autowired
	private PasajeroDAO dao;
	
	public PasajeroService(){
		this.dao= new PasajeroDAO();
	}
	
	public List<PasajeroDTO> obtenerTodosLosPasajerosDTO() {
		List<Pasajero> pasajeros = obtenerTodosLosPasajeros();
		List<PasajeroDTO>dtos = new ArrayList<>();
		for (Pasajero pasajero : pasajeros)
			dtos.add(new PasajeroDTO(pasajero));
		return dtos;
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
