package bd2.Muber.dtos;

import bd2.Muber.model.Calificacion;

public class CalificacionDTO {

	private int pasajeroId;
	private Integer puntaje;
	private String comentario;
	private int viajeId;
	
	public CalificacionDTO(Calificacion calificacion) {
		this.pasajeroId = calificacion.getPasajero().getId();
		this.puntaje = calificacion.getPuntaje();
		this.comentario = calificacion.getComentario();
		this.viajeId = calificacion.getViaje().getId();
	}

	public int getPasajero() {
		return pasajeroId;
	}
	public void setPasajero(int pasajero) {
		this.pasajeroId = pasajero;
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
	public Integer getViajeID() {
		return viajeId;
	}
	public void setViajeID(Integer viajeID) {
		this.viajeId = viajeID;
	}
}
