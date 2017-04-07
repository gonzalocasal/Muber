package ar.com.gruponn.model;

import java.util.ArrayList;
import java.util.List;

public class Viaje {
	
	private int id;
	private List<Pasajero> pasajeros;
	private List<Calificacion> calificaciones;
	private Conductor conductor;
	private String origen;
	private String destino;
	private Integer costo;
	private Integer capacidad;
	private Boolean abierto;
	
	public Viaje(){
		this.pasajeros = new ArrayList<Pasajero>();
		this.calificaciones= new ArrayList<Calificacion>();
		this.origen="";
		this.destino="";
		this.costo=0;
		this.capacidad=0;
		this.abierto=true;
	}
	
	public void registrarPasajero(Pasajero pasajero){
		this.pasajeros.add(pasajero);
	}
	
	public Double promedioPuntajes(){
		return (calificaciones.stream().mapToDouble(c -> c.getPuntaje()).average()).getAsDouble();
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

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
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

	public void setAbierto(Boolean abierto) {
		this.abierto = abierto;
	}
	
	
	
}
