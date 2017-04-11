package ar.com.grupo27.service;

import java.util.List;

import ar.com.grupo27.model.Calificacion;
import ar.com.grupo27.model.Pasajero;
import ar.com.grupo27.model.Viaje;
import ar.com.grupo27.persistence.ViajeDAO;

public class ViajeService {

	private PasajeroService pasajeroService;
	private ViajeDAO dao;
	
	public ViajeService(){
		this.dao = new ViajeDAO();
		this.pasajeroService = new PasajeroService();
	}
	
	public void registrarViaje(Viaje viaje){
		dao.openCurrentSessionwithTransaction();
		dao.persist(viaje);
		dao.closeCurrentSessionwithTransaction();
	}

	public void actualizarViaje(Viaje viaje){
		dao.openCurrentSessionwithTransaction();
		dao.actualizarViaje(viaje);
		dao.closeCurrentSessionwithTransaction();
	}
	
	public List<Viaje> obtenerTodosLosViajesAbiertos(){
		dao.openCurrentSessionwithTransaction();
		List<Viaje> todosLosViajesAbiertos = dao.obtenerTodosLosViajesAbiertos();
		dao.closeCurrentSessionwithTransaction();
		return todosLosViajesAbiertos;
	}
	
	public Viaje obtenerViaje (int id){
		dao.openCurrentSessionwithTransaction();
		Viaje viaje = dao.obtenerViaje(id);
		dao.closeCurrentSessionwithTransaction();
		return viaje;
	}
	
	public void registrarPasajero(Viaje viajeParam, Pasajero pasajero) {
		viajeParam.registrarPasajero(pasajero);
		actualizarViaje(viajeParam);
	}

	public void finalizarViaje(Viaje viajerParam) {
		Viaje viaje = obtenerViaje(viajerParam.getId());
		if(viaje.finalizarViaje()){
			pasajeroService.cobrarViaje(viaje);
			actualizarViaje(viaje);
		}
	}

	public void calificar(Calificacion calificacion) {
		dao.openCurrentSessionwithTransaction();
		dao.registrarCalificacion(calificacion);
		dao.closeCurrentSessionwithTransaction();
	}
	
}
