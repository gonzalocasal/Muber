package bd2.Muber.repositories;

import java.util.List;

import bd2.Muber.dtos.TopConductorDTO;
import bd2.Muber.model.Conductor;

public interface IConductorRepository {

	public void guardar(Conductor conductor);

	public void actualizar(Conductor conductor);
	
	public Conductor obtenerConductor(int id);

	public Conductor obtenerConductor(String usuario);
	
	public List<Conductor> obtenerTodosLosCondutores();

	public List<TopConductorDTO> obtenerConductoresTop();
	
}
