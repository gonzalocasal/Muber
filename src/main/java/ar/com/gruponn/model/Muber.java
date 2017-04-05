package ar.com.gruponn.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Muber {
	private List<Pasajero> passengers;
	private List<Conductor> drivers;
	private List<Viaje> travels;
	
	public Muber(){
		this.passengers = new ArrayList<Pasajero>();
		this.travels = new ArrayList<Viaje>();
		this.drivers = new ArrayList<Conductor>();
	}
	
	public List<Viaje> getOpenTravels() {
		return this.travels.stream().filter(travel -> !travel.getFinshed()).collect(Collectors.toList());
	}
	
	public List<Pasajero> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Pasajero> passengers) {
		this.passengers = passengers;
	}
	public List<Conductor> getDrivers() {
		return drivers;
	}
	public void setDrivers(List<Conductor> drivers) {
		this.drivers = drivers;
	}
	public List<Viaje> getTravels() {
		return travels;
	}
	public void setTravels(List<Viaje> travels) {
		this.travels = travels;
	}
	
}
