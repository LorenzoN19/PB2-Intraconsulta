package intraconsulta;

import java.util.ArrayList;
import java.util.Objects;

public class Materia {
	private ArrayList<Materia> correlativas;
	private String nombre;
	private Integer id;

	public Materia(String nombre, Integer id) {
		this.nombre = nombre;
		this.id = id;
		correlativas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(ArrayList<Materia> correlativas) {
		this.correlativas = correlativas;
	}
	
	public boolean agregarCorrelativa(Materia correlativa) {
		if(correlativas.contains(correlativa))
			return false;			
		
		return correlativas.add(correlativa);
	}
	
	public boolean eliminarCorrelativa(Materia correlativa) {
		if(correlativas.contains(correlativa)) {
			return correlativas.remove(correlativa);
		}
		
		return false;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Materia other = (Materia) obj;
	    return Objects.equals(id, other.id) || Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public int hashCode() {
	    return Objects.hash(id, nombre);
	}

	
}
