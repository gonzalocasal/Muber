package bd2.Muber.model;

public class Calificacion {

	private int id;
	private Pasajero pasajero;
	private Viaje viaje;
	private Integer puntaje;
	private String comentario;

	public Calificacion() {
	}
	
	public Calificacion(Viaje viaje, Pasajero pasajero, int puntaje, String comentario) {
		this.viaje=viaje;
		this.pasajero=pasajero;
		this.puntaje=puntaje;
		this.comentario=comentario;
	}
	
	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pasajero == null) ? 0 : pasajero.hashCode());
		result = prime * result + ((viaje == null) ? 0 : viaje.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calificacion other = (Calificacion) obj;
		if (pasajero == null) {
			if (other.pasajero != null)
				return false;
		} else if (!pasajero.equals(other.pasajero))
			return false;
		if (viaje == null) {
			if (other.viaje != null)
				return false;
		} else if (!viaje.equals(other.viaje))
			return false;
		return true;
	}

	
}
