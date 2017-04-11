package ar.com.grupo27.persistence;

import java.util.List;

import ar.com.grupo27.model.Conductor;

public class ConductorDAO extends AbstractDAO {

	public void persist(Conductor conductor) {
		currentSession.save(conductor);
	}

	public Conductor findOne(int id){
		return (Conductor) currentSession.get(Conductor.class, id);
	}

	public void actualizarConductor(Conductor conductor) {
		currentSession.update(conductor);
	}
	
	@SuppressWarnings("unchecked")
	public List<Conductor> obtenerTodosLosCondutores(){
		return currentSession.createCriteria(Conductor.class).list();
	}
	
}
