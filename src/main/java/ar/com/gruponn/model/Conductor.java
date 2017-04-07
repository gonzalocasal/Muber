package ar.com.gruponn.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Conductor extends Usuario{
	
	private Date fechaExipracionLicencia;
	
	public Double promedioPuntajes(){
		List<Viaje> viajesCerrados = this.viajes.stream().filter(viaje -> !viaje.getAbierto()).collect(Collectors.toList());
		return (viajesCerrados.stream().mapToDouble(v -> v.promedioPuntajes()).average()).getAsDouble();
	}
	
	public Boolean isVencida(){
		int result = this.fechaExipracionLicencia.compareTo(new Date());
		return result > 0;
	}

	public void registrarViaje(Viaje viaje){
		this.viajes.add(viaje);
	}
	
	public Date getFechaExipracionLicencia() {
		return fechaExipracionLicencia;
	}
	public void setFechaExipracionLicencia(Date fechaExipracionLicencia) {
		this.fechaExipracionLicencia = fechaExipracionLicencia;
	}
	
}
