package bd2.Muber.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bd2.Muber.model.Conductor;
import bd2.Muber.model.Viaje;

public class ConductorDTO {

	private int id;
	private String usuario;
	private String nombre;
	private String apellido;
	private Date fechaAlta;
	private Date fechaExipracionLicencia;
	private List<ViajeDTO> viajes;
	
	public ConductorDTO (Conductor conductor){
		this.id = conductor.getId();
		this.usuario = conductor.getUsuario();
		this.nombre = conductor.getNombre();
		this.apellido = conductor.getApellido();
		this.fechaAlta = conductor.getFechaAlta();
		this.fechaExipracionLicencia = conductor.getFechaExipracionLicencia();
		this.viajes=new ArrayList<>();
		for (Viaje viaje : conductor.getViajes()){
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
	public Date getFechaExipracionLicencia() {
		return fechaExipracionLicencia;
	}
	public void setFechaExipracionLicencia(Date fechaExipracionLicencia) {
		this.fechaExipracionLicencia = fechaExipracionLicencia;
	}
	
}
