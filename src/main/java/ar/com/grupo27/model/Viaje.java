package ar.com.grupo27.model;

import java.util.ArrayList;
import java.util.List;

public class Viaje {
	
	private int id;
	private List<Pasajero> pasajeros;
	private List<Calificacion> calificaciones;
	private Conductor conductor;
	private String origen;
	private String destino;
	private Double costo;
	private Integer capacidad;
	private Boolean abierto;
	
	public Viaje(){
		this.pasajeros = new ArrayList<Pasajero>();
		this.calificaciones= new ArrayList<Calificacion>();
		this.origen="";
		this.destino="";
		this.costo=0.00;
		this.capacidad=0;
		this.abierto=true;
	}
	
	public void registrarPasajero(Pasajero pasajero){
		if (capacidad >= pasajeros.size() +1 && abierto ){
			this.pasajeros.add(pasajero);
		}
	}
	
	public Double promedioPuntajes(){
		return (calificaciones.stream().mapToDouble(c -> c.getPuntaje()).average()).getAsDouble();
	}
	
	public boolean finalizarViaje(){
		if(abierto){
			this.abierto=false;
			return true;
		}
		return false;
	}
	
	public void setAbierto(Boolean abierto) {
		if (!abierto){
			this.abierto = abierto;
		}
	}
	
	public void calificar (Calificacion calificacion){
		this.calificaciones.add(calificacion);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(List<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
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

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Boolean getAbierto() {
		return abierto;
	}

	
	
	
	
}
