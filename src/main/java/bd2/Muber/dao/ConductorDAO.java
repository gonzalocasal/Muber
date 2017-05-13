package bd2.Muber.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import bd2.Muber.dto.TopConductorDTO;
import bd2.Muber.model.Conductor;

@Component
public class ConductorDAO extends AbstractDAO {

	private static final int CONDUCTORES_TOP_SIZE = 10;

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
		return currentSession.createQuery("from Conductor ").list();
	}

	@SuppressWarnings("unchecked")
	public List<TopConductorDTO> obtenerConductoresTop(){
		Query query = currentSession.createQuery("SELECT distinct v.conductor.usuario as conductor ,  AVG(ca.puntaje) as promedio  FROM Calificacion as ca INNER JOIN  ca.viaje  AS v WHERE v.conductor.id NOT IN ( SELECT distinct v.conductor.id FROM Viaje as v WHERE v.abierto=true) GROUP BY v.conductor.usuario ORDER BY promedio DESC");
		query.setResultTransformer(Transformers.aliasToBean(TopConductorDTO.class));
		query.setMaxResults(CONDUCTORES_TOP_SIZE);
		return query.list();
	}
	
}


