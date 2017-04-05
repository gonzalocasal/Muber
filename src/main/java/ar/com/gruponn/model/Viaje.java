package ar.com.gruponn.model;

import java.util.ArrayList;
import java.util.List;

public class Viaje {
	
	
	private List<Pasajero> passengers;
	private List<Calificacion> qualifications;
	private String origin;
	private String destiny;
	private Integer value;
	private Integer maxPassengers;
	private Boolean finshed;

	
	public Viaje(){
		this.passengers = new ArrayList<Pasajero>();
		this.qualifications= new ArrayList<Calificacion>();
		this.origin="";
		this.destiny="";
		this.value=0;
		this.maxPassengers=0;
		this.finshed=false;
	}
	
	public Double average(){
		Double result= 0.0;
		for (Calificacion qualification : qualifications) {
			result = result + qualification.getScore(); 
		}
		return result/qualifications.size();
	}
	
	public void qualify (Calificacion calification){
		this.qualifications.add(calification);
	}
	
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestiny() {
		return destiny;
	}
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Integer getMaxPassengers() {
		return maxPassengers;
	}
	public void setMaxPassengers(Integer maxPassengers) {
		this.maxPassengers = maxPassengers;
	}
	public Boolean getFinshed() {
		return finshed;
	}
	public void setFinshed(Boolean finshed) {
		this.finshed = finshed;
	}
	public List<Pasajero> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Pasajero> passengers) {
		this.passengers = passengers;
	}
	public List<Calificacion> getQualifications() {
		return qualifications;
	}
	public void setQualifications(List<Calificacion> qualifications) {
		this.qualifications = qualifications;
	}
	
	
}
