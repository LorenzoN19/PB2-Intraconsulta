package intraconsulta;
import java.util.ArrayList;
import java.util.Objects;

public class Universidad {
	private ArrayList<Materia> materias;
	private ArrayList<Alumno> alumnos;
	
	public Universidad() {
		materias = new ArrayList<>();
		alumnos = new ArrayList<>();
	}
	
	// MATERIAS //
	
	public boolean registrarMateria(Materia materia) {
		if(materias.contains(materia))
			return false;
		
		return materias.add(materia);
	}

	public boolean agregarMateriaCorrelativa(Materia materia, Materia correlativa) {
		return materia.agregarCorrelativa(correlativa);
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}

	// ALUMNOS //
	
	public boolean registrarAlumno(Alumno alumno) {
		if(alumnos.contains(alumno))
			return false;
		
		return alumnos.add(alumno);
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	

}
