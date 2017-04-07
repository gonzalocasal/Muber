package ar.com.gruponn.model;

public class Pasajero extends Usuario{

	private Integer saldo;

	public void qualify(String comment, Integer score, Viaje viaje ){
		Calificacion calificacion = new Calificacion();
		calificacion.setComentario(comment);
		calificacion.setPuntaje(score);
		calificacion.setPasajero(this);
		viaje.calificar(calificacion);
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}
	
	
	

}
