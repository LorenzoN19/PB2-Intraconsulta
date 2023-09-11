package intraconsulta;

import static org.junit.Assert.*;

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
		
		unlam.registrarMateria(pb2);
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
		unlam.registrarMateria(pb2);
		
		boolean resultado = unlam.registrarMateria(repetidaPorNombre);
		assertFalse(resultado);

		resultado = unlam.registrarMateria(repetidaPorCodigo);
		assertFalse(resultado);
	}
	
	@Test
	public void queSePuedaAgregarUnaMateriaCorrelativa() {
		Universidad unlam = new Universidad();
		String nombre = "pb2";
		Integer codigo = 2331;
		Materia pb2 = new Materia(nombre, codigo);
		Materia pb1 = new Materia("pb1", Integer.valueOf(1332));
		unlam.registrarMateria(pb2);
		
		unlam.agregarMateriaCorrelativa(pb2, pb1);
		Materia correlativaObtenida = unlam.getMaterias().get(0).getCorrelativas().get(0);
		
		assertEquals(pb1, correlativaObtenida);
	}
	
	@Test
	public void queNoSePuedaAgregarUnaCorrelativaYaExistente() {
		Universidad unlam = new Universidad();
		String nombre = "pb2";
		Integer codigo = 2331;
		Materia pb2 = new Materia(nombre, codigo);
		Materia pb1 = new Materia("pb1", Integer.valueOf(1332));
		unlam.registrarMateria(pb2);
		
		boolean resultado = unlam.agregarMateriaCorrelativa(pb2, pb1);
		assertTrue(resultado);
		
		resultado = unlam.agregarMateriaCorrelativa(pb2, pb1);
		assertFalse(resultado);
	}
	
// ALUMNO // 
	
	@Test
	public void queSePuedaRegistrarUnAlumno() {
		Universidad unlam = new Universidad();
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		Alumno alumno = new Alumno(nombre, apellido, dni);
		
		unlam.registrarAlumno(alumno);
		Alumno alumnoObtenido = unlam.getAlumnos().get(0);
		
		assertEquals(alumno, alumnoObtenido);	
	}
	
	@Test
	public void queNoSePuedaRegistrarUnAlumnoYaExistente() {
		Universidad unlam = new Universidad();
		String nombre = "Lorenzo", apellido = "Noceda";
		Integer dni = 43469499;
		Alumno alumno1 = new Alumno(nombre, apellido, dni);
		Alumno alumno2 = new Alumno("Juan", "Perez", dni);
		
		boolean resultado = unlam.registrarAlumno(alumno1);
		assertTrue(resultado);
		
		resultado = unlam.registrarAlumno(alumno2);
		assertFalse(resultado);
	}
	
// AULA // 
	
	@Test
	public void queSePuedaRegistrarUnAula() {
		Universidad unlam = new Universidad();
		Integer numero = 26, capacidadTotal = 80;
		Aula aula = new Aula(numero, capacidadTotal);
		
		unlam.registrarAula(aula);
		Aula aulaObtenida = unlam.getAulas().get(0);
		
		assertEquals(aula, aulaObtenida);	
	}
	
	@Test
	public void queNoSePuedaRegistrarUnAulaYaExistente() {
		Universidad unlam = new Universidad();
		Integer numero = 26, capacidadTotal = 80;
		Aula aula = new Aula(numero, capacidadTotal);
		Aula aula2 = new Aula(numero, Integer.valueOf(50));
		unlam.registrarAula(aula);

		boolean resultado = unlam.registrarAula(aula2);
		
		assertFalse(resultado);	
	}
	
// COMISION //
	
	public void queSePuedaRegistrarUnaComision() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("pb2", 2300);
		Aula aula = new Aula(15, 90);
		CicloLectivo cicloLectivo = new CicloLectivo(Turno.MAÑANA, Cuatrimestre.PRIMER_CUATRIMESTRE, 2023);
		ArrayList<Alumno> alumnos = new ArrayList<>();
		alumnos.add(new Alumno("Lorenzo", "Noceda", 43469499));
		alumnos.add(new Alumno("Juan", "Perez", 45345353));
		Integer codigo = 3454;
		Comision comision = new Comision(codigo, aula, materia, alumnos, cicloLectivo);
		
		unlam.registrarComision(comision);
		
		assertEquals(comision, unlam.getComisiones().get(0));
	}
	
	public void queNoPuedaRegistrarUnaComisionYaExistente() {
		Universidad unlam = new Universidad();
		Materia materia = new Materia("pb2", 2300);
		Aula aula = new Aula(15, 90);
		CicloLectivo cicloLectivo = new CicloLectivo(Turno.MAÑANA, Cuatrimestre.PRIMER_CUATRIMESTRE, 2023);
		ArrayList<Alumno> alumnos = new ArrayList<>();
		alumnos.add(new Alumno("Lorenzo", "Noceda", 43469499));
		alumnos.add(new Alumno("Juan", "Perez", 45345353));
		Integer codigo = 3454;
		Comision comision = new Comision(codigo, aula, materia, alumnos, cicloLectivo);
		Comision comision2 = new Comision(codigo, aula, materia, alumnos, cicloLectivo);
		unlam.registrarComision(comision);
		
		boolean resultado = unlam.registrarComision(comision2);
		
		assertFalse(resultado);
	}
	
}
