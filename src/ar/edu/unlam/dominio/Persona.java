package ar.edu.unlam.dominio;

import java.util.Objects;

public class Persona {

	private String nombre;
	private Integer dni;
	
	public Persona(String nombre, Integer dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	public Integer getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + "]";
	}

}
