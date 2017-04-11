package ar.com.grupo27.model;

public class Pasajero extends Usuario{

	private Double saldo;

	public Pasajero(){
		this.saldo=0.0;
	}
	
	public void calificar(String comment, Integer score, Viaje viaje ){
		Calificacion calificacion = new Calificacion();
		calificacion.setComentario(comment);
		calificacion.setPuntaje(score);
		calificacion.setPasajero(this);
		viaje.calificar(calificacion);
	}

	public void cobrar (Viaje viaje){
		this.saldo -= viaje.getCosto()/viaje.getPasajeros().size();
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
