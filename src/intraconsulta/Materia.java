package intraconsulta;

import java.util.ArrayList;
import java.util.Objects;

public class Materia {
	private ArrayList<Materia> correlativas;
	private String nombre;
	private Integer codigo;

	public Materia(String nombre, Integer codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
		correlativas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Materia other = (Materia) obj;
	    return Objects.equals(codigo, other.codigo) || Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public int hashCode() {
	    return Objects.hash(codigo, nombre);
	}

}
