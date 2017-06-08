package bd2.Muber.dtos;

import java.util.ArrayList;
import java.util.List;

import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Viaje;

public class ViajeDTO {

	private int id;
	private String origen;
	private String destino;
	private String conductor;
	private double costo;
	private int capacidad;
	private Boolean abierto;
	private List<CalificacionDTO> calificaciones;
	
	public ViajeDTO(Viaje viaje) {
		this.id = viaje.getId();
		this.origen = viaje.getOrigen();
		this.destino = viaje.getDestino();
		this.conductor = viaje.getConductor().getUsuario();
		this.costo = viaje.getCosto();
		this.capacidad = viaje.getCapacidad();
		this.abierto = viaje.getAbierto();
		this.calificaciones = new ArrayList<>();
		for (Calificacion calificacion : viaje.getCalificaciones()){
			this.calificaciones.add(new CalificacionDTO(calificacion));
		}
	}
	
	public List<CalificacionDTO> getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(List<CalificacionDTO> calificaciones) {
		this.calificaciones = calificaciones;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public Boolean getAbierto() {
		return abierto;
	}
	public void setAbierto(Boolean abierto) {
		this.abierto = abierto;
	}
	public String getConductor() {
		return conductor;
	}
	public void setConductor(String conductor) {
		this.conductor = conductor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
