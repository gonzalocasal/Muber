package bd2.Muber.dto;

import bd2.Muber.model.Calificacion;

public class CalificacionDTO {

	private String pasajero;
	private Integer puntaje;
	private String comentario;
	
	public CalificacionDTO(Calificacion calificacion) {
		this.pasajero = calificacion.getPasajero().getUsuario();
		this.puntaje = calificacion.getPuntaje();
		this.comentario = calificacion.getComentario();
	}
	
	public String getPasajero() {
		return pasajero;
	}
	public void setPasajero(String pasajero) {
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
}
