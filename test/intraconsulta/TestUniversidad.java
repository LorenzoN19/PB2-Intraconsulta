package intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;
import enums.*;

public class TestUniversidad {
	
// MATERIA //
	
	@Test
	public void queSePuedaRegistrarUnaMateria() {
		Universidad unlam = new Universidad();
		String nombre = "pb2";
		Integer codigo = 2331;
		Materia pb2 = new Materia(nombre, codigo);
		
		unlam.agregarMateria(pb2);
		Materia materiaObtenida = unlam.getMaterias().get(0);
		
		assertEquals(pb2, materiaObtenida);	
	}
	
	@Test
	public void queNoSePuedaRegistrarUnaMateriaYaExistente() {
		Universidad unlam = new Universidad();
		String nombre = "pb2";
		Integer codigo = 2331;
		Materia pb2 = new Materia(nombre, codigo);
		Materia repetidaPorNombre = new Materia(nombre, Integer.valueOf(335));
		Materia repetidaPorCodigo = new Materia("bdd", codigo);
		unlam.agregarMateria(pb2);
		
		boolean resultado = unlam.agregarMateria(repetidaPorNombre);
		assertFalse(resultado);

		resultado = unlam.agregarMateria(repetidaPorCodigo);
		assertFalse(resultado);
	}
	
	@Test
	public void queSePuedaAgregarUnaMateriaCorrelativa() {
		Universidad unlam = new Universidad();
		Materia pb1 = new Materia("pb1", Integer.valueOf(1332));
		Materia pb2 = new Materia("pb2", Integer.valueOf(2331));
		unlam.agregarMateria(pb1);
		unlam.agregarMateria(pb2);
		
		unlam.agregarCorrelatividad(pb2.getId(), pb1.getId());
		Materia materiaObtenida = unlam.traerMateria(pb2.getId());
		Materia correlativaObtenida = materiaObtenida.getCorrelativas().get(0);
		
		assertEquals(pb1, correlativaObtenida);
	}
	
	@Test
	public void queNoSePuedaAgregarUnaCorrelativaYaExistente() {
		Universidad unlam = new Universidad();
		Materia pb2 = new Materia("pb2", Integer.valueOf(2331));
		Materia pb1 = new Materia("pb1", Integer.valueOf(1332));
		unlam.agregarMateria(pb2);
		unlam.agregarMateria(pb1);
		
		boolean resultado = unlam.agregarCorrelatividad(pb2.getId(), pb1.getId());
		assertTrue(resultado);
		
		resultado = unlam.agregarCorrelatividad(pb2.getId(), pb1.getId());
		assertFalse(resultado);
	}
	
	@Test
	public void queSePuedaEliminarUnaMateriaCorrelativa() {
		Universidad unlam = new Universidad();
		Materia pb1 = new Materia("pb1", Integer.valueOf(1332));
		Materia pb2 = new Materia("pb2", Integer.valueOf(2331));
		unlam.agregarMateria(pb1);
		unlam.agregarMateria(pb2);
		unlam.agregarCorrelatividad(pb2.getId(), pb1.getId());
		
		unlam.eliminarCorrelativad(pb2.getId(), pb1.getId());
		
		assertEquals(0, pb2.getCorrelativas().size());
	}
	
// ALUMNO // 
	
	@Test
	public void queSePuedaRegistrarUnAlumno() {
		Universidad unlam = new Universidad();
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		LocalDate fechaDeNacimiento = LocalDate.of(2001, 11, 19);
		LocalDate fechaDeIngreso = LocalDate.of(2022, 3, 10);
		Alumno alumno = new Alumno(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso);
		
		unlam.agregarAlumno(alumno);
		Alumno alumnoObtenido = unlam.getAlumnos().get(0);
		
		assertEquals(alumno, alumnoObtenido);	
	}
	
	@Test
	public void queNoSePuedaRegistrarUnAlumnoYaExistente() {
		Universidad unlam = new Universidad();
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		LocalDate fechaDeNacimiento = LocalDate.of(2001, 11, 19);
		LocalDate fechaDeIngreso = LocalDate.of(2022, 3, 10);
		Alumno alumno1 = new Alumno(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso);
		Alumno alumno2 = new Alumno("Juan", "Perez", dni, fechaDeNacimiento, fechaDeIngreso);
		
		boolean resultado = unlam.agregarAlumno(alumno1);
		assertTrue(resultado);
		
		resultado = unlam.agregarAlumno(alumno2);
		assertFalse(resultado);
	}
	
// PROFESOR // 
	
	@Test
	public void queSePuedaRegistrarUnProfesor() {
		Universidad unlam = new Universidad();
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		LocalDate fechaDeNacimiento = LocalDate.of(2001, 11, 19);
		LocalDate fechaDeIngreso = LocalDate.of(2022, 3, 10);
		Profesor profesor = new Profesor(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso);
		
		unlam.agregarProfesor(profesor);
		Profesor profesorObtenido = unlam.getProfesores().get(0);
		
		assertEquals(profesor, profesorObtenido);	
	}
	
	@Test
	public void queNoSePuedaRegistrarUnProfesorYaExistente() {
		Universidad unlam = new Universidad();
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		LocalDate fechaDeNacimiento = LocalDate.of(2001, 11, 19);
		LocalDate fechaDeIngreso = LocalDate.of(2022, 3, 10);
		Alumno alumno1 = new Alumno(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso);
		Alumno alumno2 = new Alumno("Juan", "Perez", dni, fechaDeNacimiento, fechaDeIngreso);
		
		boolean resultado = unlam.agregarAlumno(alumno1);
		assertTrue(resultado);
		
		resultado = unlam.agregarAlumno(alumno2);
		assertFalse(resultado);
	}
	
// AULA // 
	
	@Test
	public void queSePuedaRegistrarUnAula() {
		Universidad unlam = new Universidad();
		Integer numero = 26, capacidadTotal = 80;
		Aula aula = new Aula(numero, capacidadTotal);
		
		unlam.agregarAula(aula);
		Aula aulaObtenida = unlam.getAulas().get(0);
		
		assertEquals(aula, aulaObtenida);	
	}
	
	@Test
	public void queNoSePuedaRegistrarUnAulaYaExistente() {
		Universidad unlam = new Universidad();
		Integer numero = 26, capacidadTotal = 80;
		Aula aula = new Aula(numero, capacidadTotal);
		Aula aula2 = new Aula(numero, Integer.valueOf(50));
		unlam.agregarAula(aula);

		boolean resultado = unlam.agregarAula(aula2);
		
		assertFalse(resultado);	
	}
	
// COMISION //
	
	@Test
	public void queSePuedaRegistrarUnaComision() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("pb2", 2300);
		Aula aula = new Aula(15, 90);
		CicloLectivo cicloLectivo = new CicloLectivo(Turno.MAÑANA, Cuatrimestre.PRIMER_CUATRIMESTRE, 2023);
		Integer codigo = 3454;
		Comision comision = new Comision(codigo, aula, materia, cicloLectivo);
		
		unlam.agregarComision(comision);
		
		assertEquals(comision, unlam.getComisiones().get(0));
	}
	
	@Test
	public void queNoPuedaRegistrarUnaComisionYaExistente() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("pb2", 2300);
		Aula aula = new Aula(15, 90);
		CicloLectivo cicloLectivo = new CicloLectivo(Turno.MAÑANA, Cuatrimestre.PRIMER_CUATRIMESTRE, 2023);
		Integer codigo = 3454;
		Comision comision = new Comision(codigo, aula, materia, cicloLectivo);
		Comision comision2 = new Comision(codigo, aula, materia, cicloLectivo);
		unlam.agregarComision(comision);
		
		boolean resultado = unlam.agregarComision(comision2);
		
		assertFalse(resultado);
	}
	
// COMISION-ALUMNO //
	
	@Test
	public void queSePuedaInscribirUnAlumnoAUnaComisionQueNoRequieraCorrelativas() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("pb2", 2300);
		Aula aula = new Aula(15, 90);
		CicloLectivo cicloLectivo = new CicloLectivo(Turno.MAÑANA, Cuatrimestre.PRIMER_CUATRIMESTRE, 2023);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, null);
		Comision comision = new Comision(2233, aula, materia, cicloLectivo);
		Integer idAsignacion = 3454;
		AsigComisionAlumno asignacion = new AsigComisionAlumno(idAsignacion, comision, alumno);
		
		unlam.inscribirAlumno(asignacion);
		
		assertEquals(asignacion, unlam.getAsignacionesAlumno().get(0));
	}

	@Test
	public void queNoSePuedanRealizarDosAsignacionesConMismoId() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("pb2", 2300);
		Aula aula = new Aula(15, 90);
		CicloLectivo cicloLectivo = new CicloLectivo(Turno.MAÑANA, Cuatrimestre.PRIMER_CUATRIMESTRE, 2023);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, null);
		Alumno alumno2 = new Alumno("Juan", "Perez", 34345453, null);
		Comision comision = new Comision(2233, aula, materia, cicloLectivo);
		Integer idAsignacion = 3454;
		AsigComisionAlumno asignacion = new AsigComisionAlumno(idAsignacion, comision, alumno);
		AsigComisionAlumno asignacion2 = new AsigComisionAlumno(idAsignacion, comision, alumno2);
		
		unlam.inscribirAlumno(asignacion);
		boolean resultado = unlam.inscribirAlumno(asignacion2);
		
		assertFalse(resultado);
	}

	@Test
	public void queUnAlumnoNoSePuedaInscribirDosVecesAUnaMismaComision() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("pb2", 2300);
		Aula aula = new Aula(15, 90);
		CicloLectivo cicloLectivo = new CicloLectivo(Turno.MAÑANA, Cuatrimestre.PRIMER_CUATRIMESTRE, 2023);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, null);
		Comision comision = new Comision(2233, aula, materia, cicloLectivo);
		Integer idAsignacion = 3454;
		AsigComisionAlumno asignacion = new AsigComisionAlumno(idAsignacion, comision, alumno);
		AsigComisionAlumno asignacion2 = new AsigComisionAlumno(454, comision, alumno);
		
		unlam.inscribirAlumno(asignacion);
		boolean resultado = unlam.inscribirAlumno(asignacion2);
		
		assertFalse(resultado);
	}
	
	@Test
	public void queSeLePuedaAsignarLaNotaAUnAlumnoEnUnaComision() {
		Universidad unlam = new Universidad();
		Materia pb2 = new Materia("pb2", 2300);
		Aula aula = new Aula(15, 90);
		CicloLectivo cicloLectivo = new CicloLectivo(Turno.MAÑANA, Cuatrimestre.PRIMER_CUATRIMESTRE, 2023);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, null);
		Comision comision = new Comision(2233, aula, pb2, cicloLectivo);
		Integer idAsignacion = 3454;
		AsigComisionAlumno asignacion = new AsigComisionAlumno(idAsignacion, comision, alumno);
		unlam.inscribirAlumno(asignacion);
		
		unlam.asignarNota(asignacion, 7);
		
		assertEquals(Integer.valueOf(7), asignacion.getNota());
	}
	
	@Test
	public void queSePuedaInscribirUnAlumnoAUnaComisionSiAproboLasCorrelativas() {
		Universidad unlam = new Universidad();
		Materia pb2 = new Materia("pb2", 2300);
		Materia pb = new Materia("pb", 2100);
		unlam.agregarCorrelatividad(pb2, pb);
		Aula aula = new Aula(15, 90);
		CicloLectivo cicloLectivo = new CicloLectivo(Turno.MAÑANA, Cuatrimestre.PRIMER_CUATRIMESTRE, 2023);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, null);
		Comision comisionPb = new Comision(23, aula, pb, cicloLectivo);
		Comision comisionPb2 = new Comision(2233, aula, pb2, cicloLectivo);
		Integer idAsignacion = 3454;
		AsigComisionAlumno asignacionPb = new AsigComisionAlumno(221, comisionPb, alumno);
		unlam.inscribirAlumno(asignacionPb);
		unlam.asignarNota(asignacionPb, 7);
		AsigComisionAlumno asignacionPb2 = new AsigComisionAlumno(idAsignacion, comisionPb2, alumno);
		
		boolean resultado = unlam.inscribirAlumno(asignacionPb2);
		
		assertTrue(resultado);
	}
	
	@Test
	public void queNoSePuedaInscribirUnAlumnoAUnaComisionSiNoAproboLasCorrelativas() {
		Universidad unlam = new Universidad();
		Materia pb2 = new Materia("pb2", 2300);
		Materia pb = new Materia("pb", 2100);
		unlam.agregarCorrelatividad(pb2, pb);
		Aula aula = new Aula(15, 90);
		CicloLectivo cicloLectivo = new CicloLectivo(Turno.MAÑANA, Cuatrimestre.PRIMER_CUATRIMESTRE, 2023);
		Alumno alumno = new Alumno("Lorenzo", "Noceda", 43469499, null);
		Comision comision = new Comision(2233, aula, pb2, cicloLectivo);
		Integer idAsignacion = 3454;
		AsigComisionAlumno asignacion = new AsigComisionAlumno(idAsignacion, comision, alumno);
		
		boolean resultado = unlam.inscribirAlumno(asignacion);
		
		assertFalse(resultado);
	}
	
}
