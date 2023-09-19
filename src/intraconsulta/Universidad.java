package intraconsulta;
import java.util.ArrayList;

public class Universidad {
	private ArrayList<Materia> materias;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Aula> aulas;
	private ArrayList<Comision> comisiones;
	private ArrayList<AsigComisionAlumno> asignacionesAlumno;
	private ArrayList<Profesor> profesores;
	
	public Universidad() {
		materias = new ArrayList<>();
		alumnos = new ArrayList<>();
		aulas = new ArrayList<>();
		comisiones = new ArrayList<>();
		asignacionesAlumno = new ArrayList<>();
	}
	
// MATERIA //
	
	public boolean agregarMateria(Materia materia) {
		if(materias.contains(materia))
			return false;
		
		return materias.add(materia);
	}

	public Materia traerMateria(Integer id) {
		for(int i=0; i<=materias.size(); i++) {
			Materia materia = materias.get(i);
			if(materia.getId().equals(id))
				return materia;
		}
		return null;
	}
	
	public boolean agregarCorrelatividad(Integer idMateria, Integer idCorrelativa) {
		Materia materia = traerMateria(idMateria);
		Materia correlativa = traerMateria(idCorrelativa);
		
		return materia.agregarCorrelativa(correlativa);
	}
	
	public boolean eliminarCorrelativad(Integer idMateria, Integer idCorrelativaAEliminar) {
		Materia materia = traerMateria(idMateria);
		Materia correlativa = traerMateria(idCorrelativaAEliminar);
		
		return materia.eliminarCorrelativa(correlativa);
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}
	
// ALUMNO //
	
	public boolean agregarAlumno(Alumno alumno) {
		if(alumnos.contains(alumno))
			return false;
		
		return alumnos.add(alumno);
	}
	
	public Alumno traerAlumno(Integer dni) {
		for(int i=0; i<alumnos.size(); i++) {
			Alumno alumno = alumnos.get(i);
			if(alumno.getDni().equals(dni))
				return alumno;
		}
		return null;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
// AULA //
	
	public boolean agregarAula(Aula aula) {
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
	
	public boolean agregarComision(Comision comision) {
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

// PROFESOR //	
	
	public boolean agregarProfesor(Profesor profesor) {
		if(profesores.contains(profesor))
			return false;
		
		return profesores.add(profesor);
	}

	public Profesor traerProfesor(Integer dni) {
		for(int i=0; i<profesores.size(); i++) {
			Profesor profesor = profesores.get(i);
			if(profesor.getDni().equals(dni))
				return profesor;
		}
		return null;
	}
	
	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}	

}
