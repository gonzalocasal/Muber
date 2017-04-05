package ar.com.gruponn.model;

public class Calificacion {
	
	private Pasajero passanger;
	private Integer score;
	private String comment;
	
	public Pasajero getPassanger() {
		return passanger;
	}
	public void setPassanger(Pasajero passanger) {
		this.passanger = passanger;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
