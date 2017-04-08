package ar.com.grupo27.model;

public class Pasajero extends Usuario{

	private Double saldo;

	public void calificar(String comment, Integer score, Viaje viaje ){
		Calificacion calificacion = new Calificacion();
		calificacion.setComentario(comment);
		calificacion.setPuntaje(score);
		calificacion.setPasajero(this);
		viaje.calificar(calificacion);
	}

	public void cobrar (Double monto){
		this.saldo -= monto;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
