package ar.com.gruponn.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Conductor extends Usuario{
	
	private Date fechaExipracionLicencia;
	
	public Double promedioCalificiaciones(){
		List<Viaje> pasajeros = this.viajes.stream().filter(viaje -> viaje.getAbierto()).collect(Collectors.toList());
		Double resultado= 0.0;
		for (Viaje viaje : pasajeros) {
			resultado = resultado + viaje.average(); 
		}
		return resultado/pasajeros.size();
	}
	
	
	public Boolean isVencida(){
		Date today = new Date();
		int result = this.fechaExipracionLicencia.compareTo(today);
		return result > 0;
	}

	public Date getFechaExipracionLicencia() {
		return fechaExipracionLicencia;
	}
	public void setFechaExipracionLicencia(Date fechaExipracionLicencia) {
		this.fechaExipracionLicencia = fechaExipracionLicencia;
	}
	
}
