package bd2.Muber.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import bd2.Muber.dtos.TopConductorDTO;
import bd2.Muber.model.Conductor;

@Component
public class ConductorRepositoryImpl extends AbstractRepository implements IConductorRepository {

	private static final int CONDUCTORES_TOP_SIZE = 10;
	
	public void guardar(Conductor conductor) {
		getCurrentSession().save(conductor);
	}
	
	public void actualizar(Conductor conductor) {
		getCurrentSession().update(conductor);
	}

	public Conductor obtenerConductor(int id){
		return (Conductor) getCurrentSession().get(Conductor.class, id);
	}

	public Conductor obtenerConductor(String usuario){
		String hql = "from Conductor c where c.usuario = :usuario"; 
		return (Conductor) getCurrentSession().createQuery(hql).setParameter("usuario", usuario).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Conductor> obtenerTodosLosCondutores(){
		return getCurrentSession().createQuery("from Conductor ").list();
	}

	@SuppressWarnings("unchecked")
	public List<TopConductorDTO> obtenerConductoresTop(){
		Query query = getCurrentSession().createQuery("SELECT distinct v.conductor.usuario as conductor ,  AVG(ca.puntaje) as promedio  FROM Calificacion as ca INNER JOIN  ca.viaje  AS v WHERE v.conductor.id NOT IN ( SELECT distinct v.conductor.id FROM Viaje as v WHERE v.abierto=true) GROUP BY v.conductor.usuario ORDER BY promedio DESC");
		query.setResultTransformer(Transformers.aliasToBean(TopConductorDTO.class));
		query.setMaxResults(CONDUCTORES_TOP_SIZE);
		return query.list();
	}
	
}
