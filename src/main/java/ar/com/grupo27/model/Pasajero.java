package ar.com.grupo27.model;

public class Pasajero extends Usuario{

	private Double saldo;

	public Pasajero(){
		this.saldo=0.0;
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
