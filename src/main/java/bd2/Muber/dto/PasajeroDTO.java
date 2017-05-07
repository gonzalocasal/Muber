package bd2.Muber.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bd2.Muber.model.Pasajero;
import bd2.Muber.model.Viaje;

public class PasajeroDTO {

	private int id;
	private String usuario;
	private String nombre;
	private String apellido;
	private Date fechaAlta;
	private Double saldo;
	private List<ViajeDTO> viajes;
	
	public PasajeroDTO (Pasajero pasajero){
		this.id= pasajero.getId();
		this.usuario = pasajero.getUsuario();
		this.nombre = pasajero.getNombre();
		this.apellido = pasajero.getApellido();
		this.fechaAlta = pasajero.getFechaAlta();
		this.saldo = pasajero.getSaldo();
		this.viajes=new ArrayList<>();
		for (Viaje viaje : pasajero.getViajes()){
			this.viajes.add(new ViajeDTO(viaje));
		}
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<ViajeDTO> getViajes() {
		return viajes;
	}
	public void setViajes(List<ViajeDTO> viajes) {
		this.viajes = viajes;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
}
