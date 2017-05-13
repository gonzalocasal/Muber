package bd2.Muber.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Conductor extends Usuario{
	
	private Date fechaExipracionLicencia;
	
	public Conductor(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 1);
		this.fechaExipracionLicencia = calendar.getTime();
	}
	
	public Double promedioPuntajes(){
		List<Viaje> viajesCerrados = this.viajes.stream().filter(viaje -> !viaje.getAbierto()).collect(Collectors.toList());
		return (viajesCerrados.stream().mapToDouble(v -> v.promedioPuntajes()).average()).getAsDouble();
	}
	
	public Boolean isVencida(){
		int result = this.fechaExipracionLicencia.compareTo(new Date());
		return result < 0;
	}

	public void registrarViaje(Viaje viaje){
		if(licenciaValida() ){
			viaje.setConductor(this);
			this.viajes.add(viaje);
		}
	}
	
	public void setExpiracionLicencia(String fecha) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.fechaExipracionLicencia = formatter.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
	
	public void setFechaExipracionLicencia(Date fechaExipracionLicencia) {
		this.fechaExipracionLicencia = fechaExipracionLicencia;
	}

	private boolean licenciaValida() {
		return fechaExipracionLicencia.compareTo(new Date()) >=0;
	}
	
	public Date getFechaExipracionLicencia() {
		return fechaExipracionLicencia;
	}

	
	
}
