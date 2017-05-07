package bd2.Muber.model;

public class Pasajero extends Usuario{

	
	private int id;
	private Double saldo;

	public Pasajero(){
		this.saldo=0.0;
	}
	
	public void cobrar (Viaje viaje){
		this.saldo -= viaje.getCosto()/viaje.getPasajeros().size();
	}
	
	public void cargarCredito (int monto){
		this.saldo += monto;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		if (id != other.id)
			return false;
		return true;
	}

}
