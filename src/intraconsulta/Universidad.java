package intraconsulta;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import enums.DiaDeCursada;
import enums.TipoDeNota;
import enums.Turno;

public class Universidad {
	private ArrayList<Materia> materias;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Aula> aulas;
	private ArrayList<Comision> comisiones;
	private ArrayList<AsigComisionAlumno> asignacionesAlumno;
	private ArrayList<Profesor> profesores;
	private ArrayList<CicloLectivo> ciclosLectivos;
	private ArrayList<AsigComisionProfesor> asignacionesProfesor;
	private static Integer idAsignacionAlumno, idAsignacionProfesor;

	public Universidad() {
		materias = new ArrayList<>();
		alumnos = new ArrayList<>();
		aulas = new ArrayList<>();
		comisiones = new ArrayList<>();
		asignacionesAlumno = new ArrayList<>();
		profesores = new ArrayList<>();
		ciclosLectivos = new ArrayList<>();
		asignacionesProfesor = new ArrayList<>();
		idAsignacionAlumno = 1;
		idAsignacionProfesor = 1;
	}

// MATERIA //

	public boolean agregarMateria(Materia materia) {
		if (materias.contains(materia))
			return false;

		return materias.add(materia);
	}

	public Materia traerMateria(Integer id) {
		for (int i = 0; i <= materias.size(); i++) {
			Materia materia = materias.get(i);
			if (materia.getId().equals(id))
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
		if (alumnos.contains(alumno))
			return false;

		return alumnos.add(alumno);
	}

	public Alumno traerAlumno(Integer dni) {
		for (int i = 0; i < alumnos.size(); i++) {
			Alumno alumno = alumnos.get(i);
			if (alumno.getDni().equals(dni))
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
		if (aulas.contains(aula))
			return false;

		return aulas.add(aula);
	}

	public Aula traerAula(Integer numero) {
		for (int i = 0; i < aulas.size(); i++) {
			Aula aula = aulas.get(i);
			if (aula.getNumero().equals(numero))
				return aula;
		}
		return null;
	}

	public ArrayList<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(ArrayList<Aula> aulas) {
		this.aulas = aulas;
	}

// COMISION //

	public boolean agregarComision(Comision comision) {
		Aula aula = traerAula(comision.getAula().getNumero());
		Materia materia = traerMateria(comision.getMateria().getId());
		CicloLectivo cicLec = traerCicloLectivo(comision.getCicloLectivo().getId());
		if (aula == null || materia == null || cicLec == null)
			return false;

		if (comisiones.contains(comision))
			return false;

		return comisiones.add(comision);
	}

	public Comision traerComision(Integer id) {
		for (int i = 0; i < comisiones.size(); i++) {
			Comision comision = comisiones.get(i);
			if (comision.getId().equals(id)) {
				return comision;
			}
		}
		return null;
	}

	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}

	public void setComisiones(ArrayList<Comision> comisiones) {
		this.comisiones = comisiones;
	}

// COMISION-ALUMNO //

	public boolean inscribirAlumnoAComision(Integer dniAlumno, Integer idComision, LocalDate fecha) {
		Alumno alumno = traerAlumno(dniAlumno);
		Comision comision = traerComision(idComision);
		Materia materia = comision.getMateria();
		boolean alumnoOComisionNoEstanRegistrados = alumno == null || comision == null;
		if (alumnoOComisionNoEstanRegistrados 
				|| aproboMateria(alumno, materia)
				|| inscripcionFueraDeFecha(fecha, comision) 
				|| comisionLlena(comision)
				|| !aproboOLLevaAFinalTodasLasCorrelativas(materia, alumno)
				|| cursaOtraComisionElMismoDiaYTurno(alumno, comision)) {
			return false;
		}
		AsigComisionAlumno asignacion = new AsigComisionAlumno(idAsignacionAlumno, comision, alumno);
		if (asignacionesAlumno.contains(asignacion)) {
			return false;
		}
		asignacionesAlumno.add(asignacion);
		idAsignacionAlumno++;
		return true;
	}

	private boolean cursaOtraComisionElMismoDiaYTurno(Alumno alumnoRecibido, Comision comisionRecibida) {
		CicloLectivo cicloRecibido = comisionRecibida.getCicloLectivo();
		DiaDeCursada diaRecibido = comisionRecibida.getDia();
		Turno turnoRecibido = comisionRecibida.getTurno();
		for (int i = 0; i < asignacionesAlumno.size(); i++) {
			AsigComisionAlumno asignacion = asignacionesAlumno.get(i);
			Alumno alumno = asignacion.getAlumno();
			CicloLectivo ciclo = asignacion.getComision().getCicloLectivo();
			Turno turno = asignacion.getComision().getTurno();
			DiaDeCursada dia = asignacion.getComision().getDia();
			if (alumno.equals(alumnoRecibido) && turno.equals(turnoRecibido) && ciclo.equals(cicloRecibido)
					&& dia.equals(diaRecibido)) {
				return true;
			}
		}
		return false;
	}

	private boolean inscripcionFueraDeFecha(LocalDate fecha, Comision comision) {
		CicloLectivo cl = comision.getCicloLectivo();
		LocalDate inicioInscripcion = cl.getInicioInscripcion();
		LocalDate finInscripcion = cl.getFinInscripcion();
		if (fecha.isBefore(inicioInscripcion) || fecha.isAfter(finInscripcion)) {
			return true;
		}
		return false;
	}

	private boolean comisionLlena(Comision comision) {
		Integer capacidad = comision.getAula().getCapacidadTotal();
		Integer inscriptos = devolverCantidadDeInscriptos(comision);
		if (inscriptos < capacidad) {
			return false;
		}
		return true;
	}

	private Integer devolverCantidadDeInscriptos(Comision comisionRecibida) {
		Integer contador = 0;
		for (int i = 0; i < asignacionesAlumno.size(); i++) {
			Comision comision = asignacionesAlumno.get(i).getComision();
			if (comision.equals(comisionRecibida)) {
				contador++;
			}
		}
		return contador;
	}

	private boolean aproboMateria(Alumno alumnoRecibido, Materia materiaRecibida) {
		Integer numDeAsignaciones = asignacionesAlumno.size();
		for (int i = 0; i < numDeAsignaciones; i++) {
			AsigComisionAlumno asignacion = asignacionesAlumno.get(i);
			Alumno alumno = asignacion.getAlumno();
			Materia materia = asignacion.getComision().getMateria();
			Integer nota = asignacion.getNotaFinal().getValor();
			boolean estaAprobado = nota >= 4;
			if (alumno.equals(alumnoRecibido) && materia.equals(materiaRecibida) && estaAprobado)
				return true;
		}
		return false;
	}
	
	private boolean llevaMateriaAFinal(Alumno alumnoRecibido, Materia materiaRecibida) {
		Integer numDeAsignaciones = asignacionesAlumno.size();
		for (int i = 0; i < numDeAsignaciones; i++) {
			AsigComisionAlumno asignacion = asignacionesAlumno.get(i);
			Alumno alumno = asignacion.getAlumno();
			Materia materia = asignacion.getComision().getMateria();
			boolean laLlevaAFinal = asignacion.isPendienteDeFinal();
			if (alumno.equals(alumnoRecibido) && materia.equals(materiaRecibida) && laLlevaAFinal)
				return true;
		}
		return false;
	}

	private boolean aproboTodasLasCorrelativas(Materia materia, Alumno alumno) {
		Integer contador = 0;
		Integer numDeCorrelativas = materia.getCorrelativas().size();
		for (int i = 0; i < numDeCorrelativas; i++) {
			Materia correlativa = materia.getCorrelativas().get(i);
			if (aproboMateria(alumno, correlativa))
				contador++;
		}
		if (contador != numDeCorrelativas)
			return false;

		return true;
	}
	
	private boolean aproboOLLevaAFinalTodasLasCorrelativas(Materia materia, Alumno alumno) {
		Integer contador = 0;
		Integer numDeCorrelativas = materia.getCorrelativas().size();
		for (int i = 0; i < numDeCorrelativas; i++) {
			Materia correlativa = materia.getCorrelativas().get(i);
			if (aproboMateria(alumno, correlativa) || llevaMateriaAFinal(alumno, correlativa))
				contador++;
		}
		if (contador != numDeCorrelativas)
			return false;
		
		return true;
	}

	public ArrayList<AsigComisionAlumno> getAsignacionesAlumno() {
		return asignacionesAlumno;
	}

	public void setAsignacionesAlumno(ArrayList<AsigComisionAlumno> asignacionesAlumno) {
		this.asignacionesAlumno = asignacionesAlumno;
	}

	public Integer getIdAsignacionAlumno() {
		return idAsignacionAlumno;
	}

	public void setIdAsignacionAlumno(Integer idAsignacionAlumno) {
		Universidad.idAsignacionAlumno = idAsignacionAlumno;
	}

	public boolean registrarNota(Integer idComision, Integer dniAlumno, Nota nota) {
		AsigComisionAlumno asignacion = buscarAsignacionAlumno(idComision, dniAlumno);
		if (asignacion == null) {
			return false;
		}
		Materia materia = asignacion.getComision().getMateria();
		Alumno alumno = asignacion.getAlumno();
		Integer valor = nota.getValor();
		TipoDeNota tipoDeNota = nota.getTipo();
		if(!aproboTodasLasCorrelativas(materia, alumno)) {
			if(tipoDeNota.equals(TipoDeNota.NOTA_FINAL))
				return false;
			if(valor >= 7)
				valor = 6;
		}
		return evaluar(asignacion, valor, tipoDeNota);
	}

	private boolean evaluar(AsigComisionAlumno asignacion, Integer valor, TipoDeNota tipoDeNota) {
		switch (tipoDeNota) {
		case PRIMER_PARCIAL:
			return asignacion.calificarPrimerParcial(valor);
		case SEGUNDO_PARCIAL:
			return asignacion.calificarSegundoParcial(valor);
		case REC_PRIMERO:
			return asignacion.calificarRecupPrimero(valor);
		case REC_SEGUNDO:
			return asignacion.calificarRecupSegundo(valor);
		case NOTA_FINAL:
			return asignacion.calificarNotaFinal(valor);
		default:
			return false;
		}
	}

	public AsigComisionAlumno buscarAsignacionAlumno(Integer idComision, Integer dniAlumno) {
		for (int i = 0; i < asignacionesAlumno.size(); i++) {
			Comision comision = asignacionesAlumno.get(i).getComision();
			Alumno alumno = asignacionesAlumno.get(i).getAlumno();
			if (comision.getId().equals(idComision) && alumno.getDni().equals(dniAlumno)) {
				return asignacionesAlumno.get(i);
			}
		}
		return null;
	}
	
	public Integer obtenerNota(Integer dniAlumno, Integer idMateria) {
		Integer nota = 0;
		for (int i = 0; i < asignacionesAlumno.size(); i++) {
			Materia materia = asignacionesAlumno.get(i).getComision().getMateria();
			Alumno alumno = asignacionesAlumno.get(i).getAlumno();
			if (materia.getId().equals(idMateria) && alumno.getDni().equals(dniAlumno)) {
				nota = asignacionesAlumno.get(i).getNotaFinal().getValor();
			}
		}
		return nota;
	}
	
	public Double calcularPromedio(Integer dni) {
		Double promedio = 0.0;
		Integer contador=0, suma=0;
		for(AsigComisionAlumno asignacion: asignacionesAlumno) {
			Alumno alumno = asignacion.getAlumno();
			Integer nota = asignacion.getNotaFinal().getValor();
			if(alumno.getDni().equals(dni) && nota >= 4) {
				suma += nota;
				contador++;
			}
		}
		if(contador > 0) {
			promedio = (double) suma / contador;			
		}
		return promedio;
	}
	
	public ArrayList<Materia> obtenerMateriasNoCursadas(Integer dniAlumno) {
		Alumno alumno = traerAlumno(dniAlumno);
		ArrayList<Materia> materiasNoCursadas = new ArrayList<>();
		for(int i=0; i<materias.size(); i++) {
			Materia materia = materias.get(i);
			Integer nota = obtenerNota(dniAlumno, materia.getId());
			imprimirInformacionSobreMateriasNoCursadas(alumno, materiasNoCursadas, materia, nota);
		}
		imprimir("");
		return materiasNoCursadas;
	}

	private void imprimirInformacionSobreMateriasNoCursadas(Alumno alumno, ArrayList<Materia> materiasNoCursadas,
			Materia materia, Integer nota) {
		if(nota.equals(0)) {
			materiasNoCursadas.add(materia);
			if(materiasNoCursadas.size()==1) {
				imprimir("Materias no cursadas de " + alumno.getNombre() + " " + alumno.getApellido() + 
						" DNI " + alumno.getDni());
			}
			imprimir("- " + materia.getNombre());
		}
	}
	
	public ArrayList<Materia> obtenerMateriasAprobadas(Integer dni) {
		ArrayList<Materia> materiasAprobadas = new ArrayList<>();
		for(int i=0; i<asignacionesAlumno.size(); i++) {
			AsigComisionAlumno asignacion = asignacionesAlumno.get(i);
			Alumno alumno = asignacion.getAlumno();
			Materia materia = asignacion.getComision().getMateria();
			boolean aprobado = asignacion.getNotaFinal().getValor()>=4;
			if(alumno.getDni().equals(dni) && aprobado) {
				materiasAprobadas.add(materia);
				if(materiasAprobadas.size()==1) {
					imprimir("Materias aprobadas de " + alumno.getNombre() + " " + alumno.getApellido() + 
							" DNI " + alumno.getDni());
				}
				mostrarInformacionSobreMateriasAprobadas(asignacion);
			}
		}
		imprimir("");
		return materiasAprobadas;
	}

	private void mostrarInformacionSobreMateriasAprobadas(AsigComisionAlumno asignacion) {
		Materia materia = asignacion.getComision().getMateria();
		CicloLectivo ciclo = asignacion.getComision().getCicloLectivo();
		Integer nota = asignacion.getNotaFinal().getValor();
		imprimir("- " + materia.getNombre() + " | Nota: " + nota + " | " + obtenerAñoDeCicloLectivo(ciclo) + 
				 " " +obtenerCuatrimestreDeCicloLectivo(ciclo) + "C");
		
	}
	
	private void imprimir(String mensaje) {
		System.out.println(mensaje);
	}

// COMISION-PROFESOR //
	
	public boolean asignarProfesorAComision(Integer dniProfesor, Integer idComision) {
		Profesor profesor = traerProfesor(dniProfesor);
		Comision comision = traerComision(idComision);
		if(profesor==null || comision==null) {
			return false;
		}
		if(!puedeAsignarseUnProfesorMas(comision)) {
			return false;
		}
		AsigComisionProfesor asignacion = new AsigComisionProfesor(idAsignacionProfesor, comision, profesor);
		if(asignacionesProfesor.contains(asignacion)) {
			return false;
		}
		asignacionesProfesor.add(asignacion);
		idAsignacionProfesor++;
		return true;
	}

	public boolean puedeAsignarseUnProfesorMas(Comision comision) {
		Integer numInscriptos = devolverCantidadDeInscriptos(comision);
		Integer numProfesoresAsignados = devolverCantidadDeProfesoresAsignados(comision);
		boolean puedeAsignarseOtroProfesor = numInscriptos - (numProfesoresAsignados*20) > 0;
		return puedeAsignarseOtroProfesor;
	}
	
	
	private Integer devolverCantidadDeProfesoresAsignados(Comision comisionRecibida) {
		Integer contador = 0;
		for(int i=0; i<asignacionesProfesor.size(); i++) {
			Comision comision = asignacionesProfesor.get(i).getComision();
			if(comision.equals(comisionRecibida)){
				contador++;
			}
		}
		return contador;
	}

// PROFESOR //	

	public boolean agregarProfesor(Profesor profesor) {
		if (profesores.contains(profesor))
			return false;

		return profesores.add(profesor);
	}

	public Profesor traerProfesor(Integer dni) {
		for (int i = 0; i < profesores.size(); i++) {
			Profesor profesor = profesores.get(i);
			if (profesor.getDni().equals(dni))
				return profesor;
		}
		return null;
	}

	public ArrayList<AsigComisionProfesor> getAsignacionesProfesor() {
		return asignacionesProfesor;
	}

	public void setAsignacionesProfesor(ArrayList<AsigComisionProfesor> asignacionesProfesor) {
		this.asignacionesProfesor = asignacionesProfesor;
	}

	public static Integer getIdAsignacionProfesor() {
		return idAsignacionProfesor;
	}

	public static void setIdAsignacionProfesor(Integer idAsignacionProfesor) {
		Universidad.idAsignacionProfesor = idAsignacionProfesor;
	}

	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}

// CICLO LECTIVO //

	public boolean agregarCicloLectivo(CicloLectivo cicloLectivo) {
		if (ciclosLectivos.contains(cicloLectivo))
			return false;

		if (seSuperponeAUnCicloLectivo(cicloLectivo))
			return false;

		return ciclosLectivos.add(cicloLectivo);
	}

	public CicloLectivo traerCicloLectivo(Integer id) {
		for (int i = 0; i < ciclosLectivos.size(); i++) {
			CicloLectivo cicloLectivo = ciclosLectivos.get(i);
			if (cicloLectivo.getId().equals(id))
				return cicloLectivo;
		}
		return null;
	}

	private boolean seSuperponeAUnCicloLectivo(CicloLectivo cicloLectivo) {
		for (int i = 0; i < ciclosLectivos.size(); i++) {
			CicloLectivo cicloActual = ciclosLectivos.get(i);
			boolean inscripcionSuperpuesta = (cicloActual.getInicioInscripcion()
					.isBefore(cicloLectivo.getInicioInscripcion())
					&& cicloActual.getFinCicloLec().isAfter(cicloLectivo.getInicioInscripcion())
					|| cicloActual.getInicioInscripcion().isBefore(cicloLectivo.getFinInscripcion())
							&& cicloActual.getFinCicloLec().isAfter(cicloLectivo.getFinInscripcion()));

			boolean cicloLectivoSuperpuesto = (cicloActual.getInicioInscripcion()
					.isBefore(cicloLectivo.getInicioCicloLec())
					&& cicloActual.getFinCicloLec().isAfter(cicloLectivo.getInicioCicloLec())
					|| cicloActual.getInicioInscripcion().isBefore(cicloLectivo.getFinCicloLec())
							&& cicloActual.getFinCicloLec().isAfter(cicloLectivo.getFinCicloLec()));
			if (inscripcionSuperpuesta || cicloLectivoSuperpuesto) {
				return true;
			}
		}
		return false;
	}
	
	public Integer obtenerAñoDeCicloLectivo(CicloLectivo ciclo) {
		return ciclo.getInicioCicloLec().getYear();
	}
	
	public Integer obtenerCuatrimestreDeCicloLectivo(CicloLectivo ciclo) {
		Month mesDeInicio = ciclo.getInicioCicloLec().getMonth();
		if(mesDeInicio.getValue()<7) {
			return 1;
		} else {
			return 2;			
		}
	}

	public ArrayList<CicloLectivo> getCiclosLectivos() {
		return ciclosLectivos;
	}

	public void setCiclosLectivos(ArrayList<CicloLectivo> ciclosLectivos) {
		this.ciclosLectivos = ciclosLectivos;
	}

	

}
