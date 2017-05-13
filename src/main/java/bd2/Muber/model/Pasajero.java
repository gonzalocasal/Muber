package bd2.Muber.model;

public class Pasajero extends Usuario{

	
	private double saldo;

	public Pasajero(){
		this.saldo=0.0;
	}
	
	public void cobrar (Viaje viaje){
		this.saldo -= viaje.getCosto()/viaje.getPasajeros().size();
	}
	
	public void cargarCredito (int monto){
		this.saldo += monto;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasajero other = (Pasajero) obj;
		if (getId() != other.getId())
			return false;
		return true;
	}

}
