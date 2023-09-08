package intraconsulta;
import java.util.ArrayList;
import java.util.Objects;

public class Universidad {
	ArrayList<Materia> materias = new ArrayList<>();

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



}
