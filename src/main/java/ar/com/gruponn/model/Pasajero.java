package ar.com.gruponn.model;

public class Pasajero extends Usuario{

	private Integer credit;

	public void qualify(String comment, Integer score, Viaje viaje ){
		Calificacion calification = new Calificacion();
		calification.setComment(comment);
		calification.setScore(score);
		viaje.qualify(calification);
	}
	
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	

}
