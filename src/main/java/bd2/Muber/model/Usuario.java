package bd2.Muber.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Usuario {

	protected List<Viaje> viajes;
	protected String usuario;
	protected String pass;
	protected String nombre;
	protected String apellido;
	protected Date fechaAlta;

	public Usuario() {
		this.fechaAlta = new Date();
		this.viajes = new ArrayList<Viaje>();
	}

	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
