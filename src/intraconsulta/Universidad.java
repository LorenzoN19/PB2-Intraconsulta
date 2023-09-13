package intraconsulta;
import java.util.ArrayList;

public class Universidad {
	private ArrayList<Materia> materias;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Aula> aulas;
	private ArrayList<Comision> comisiones;
	private ArrayList<AsigComisionAlumno> asignacionesAlumno;
	
	public Universidad() {
		materias = new ArrayList<>();
		alumnos = new ArrayList<>();
		aulas = new ArrayList<>();
		comisiones = new ArrayList<>();
		asignacionesAlumno = new ArrayList<>();
	}
	
// MATERIA //
	
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
	
// ALUMNO //
	
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
	
// AULA //
	
	public boolean registrarAula(Aula aula) {
		if(aulas.contains(aula))
			return false;
		
		return aulas.add(aula);
	}


	public ArrayList<Aula> getAulas() {
		return aulas;
	}


	public void setAulas(ArrayList<Aula> aulas) {
		this.aulas = aulas;
	}
	
// COMISION //
	
	public boolean registrarComision(Comision comision) {
		if(comisiones.contains(comision))
			return false;
		
		return comisiones.add(comision);
	}

	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}

	public void setComisiones(ArrayList<Comision> comisiones) {
		this.comisiones = comisiones;
	}

// COMISION-ALUMNO //
	
	public boolean inscribirAlumno(AsigComisionAlumno asignacion) {
		if(asignacionesAlumno.contains(asignacion))
			return false;
		
		Materia materiaObtenida = asignacion.getComision().getMateria();
		if(materiaObtenida.getCorrelativas().isEmpty())
			return asignacionesAlumno.add(asignacion);			

		Integer contador = 0, numDeCorrelativas = materiaObtenida.getCorrelativas().size();
		Alumno alumno = asignacion.getAlumno();
		for(int i=0; i<numDeCorrelativas; i++) {
			Materia correlativa = materiaObtenida.getCorrelativas().get(i);
			if(aproboCorrelativa(alumno, correlativa))
				contador++;
		}
		
		if(contador.equals(numDeCorrelativas))
			return asignacionesAlumno.add(asignacion);
		
		return false;
	}

	private boolean aproboCorrelativa(Alumno alumnoRecibido, Materia correlativa) {
		Integer numDeAsignaciones = asignacionesAlumno.size();
		for(int i=0; i<numDeAsignaciones; i++) {
			AsigComisionAlumno asignacion = asignacionesAlumno.get(i);
			Alumno alumno = asignacion.getAlumno();
			Materia materia = asignacion.getComision().getMateria();
			Integer nota = asignacion.getNota();
			if(alumno.equals(alumnoRecibido) && materia.equals(correlativa) && nota >= 7)
				return true;
		}
		return false;
}

	public ArrayList<AsigComisionAlumno> getAsignacionesAlumno() {
		return asignacionesAlumno;
	}

	public void setAsignacionesAlumno(ArrayList<AsigComisionAlumno> asignacionesAlumno) {
		this.asignacionesAlumno = asignacionesAlumno;
	}

	public void asignarNota(AsigComisionAlumno asignacion, Integer nota) {
		asignacion.asignarNota(nota);
	}	

}
