package bd2.Muber.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bd2.Muber.dao.ViajeDAO;
import bd2.Muber.dto.ViajeDTO;
import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Pasajero;
import bd2.Muber.model.Viaje;

@Component
public class ViajeService {

	
	@Autowired
	private ViajeDAO dao;
	
	public ViajeService(){
		this.dao = new ViajeDAO();
	}
	
	public List<ViajeDTO> obtenerTodosLosViajesAbiertosDTO() {
		List<Viaje> viajesAbiertos = obtenerTodosLosViajesAbiertos();
		List<ViajeDTO> dtos = new ArrayList<>();
		for (Viaje viaje : viajesAbiertos)
			dtos.add(new ViajeDTO(viaje));
		return dtos;
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

	public void calificar(Calificacion calificacion) {
		if (!calificacion.getViaje().getCalificaciones().contains(calificacion)){
			dao.openCurrentSessionwithTransaction();
			dao.registrarCalificacion(calificacion);
			dao.closeCurrentSessionwithTransaction();
		}
	}

	
	
}
