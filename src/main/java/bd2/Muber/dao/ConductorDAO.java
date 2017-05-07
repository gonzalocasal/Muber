package bd2.Muber.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import bd2.Muber.model.Conductor;

@Component
public class ConductorDAO extends AbstractDAO {

	public void persist(Conductor conductor) {
		currentSession.save(conductor);
	}

	public Conductor obtenerConductor(int id){
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
