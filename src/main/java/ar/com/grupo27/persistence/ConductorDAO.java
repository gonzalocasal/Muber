package ar.com.grupo27.persistence;

import ar.com.grupo27.model.Conductor;

public class ConductorDAO extends AbstractDAO {

	public void persist(Conductor conductor) {
		currentSession.save(conductor);
	}

	public Conductor findOne(int id){
		return (Conductor) currentSession.get(Conductor.class, id);
	}
	
}
